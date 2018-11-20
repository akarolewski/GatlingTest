package com.scenarios

import com.common.Helpers.{isValidStatus, _}
import com.common.Status.OK
import com.common.dto.PostPut
import com.dto.Posts
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import play.api.libs.json.Json

object Posts {

  private val validStatuses: Seq[Int] = Seq(OK)

  def fetchPosts(): ChainBuilder = exec(http("Fetch all posts")
    .get("/posts")
    .check(jsonPath("$..userId").ofType[Int].findAll.transform(list => list.maxBy(id => id)).saveAs("maxUserId"))
    .check(isValidStatus(validStatuses))
    .check(responseValidation(validateSchema[Seq[Posts]]))
  )

  def fetchUserPost(): ChainBuilder = exec(http("Fetch posts per user")
    .get("/posts")
    .queryParam("userId", "${maxUserId}")
    .check(jsonPath("$..id").ofType[Int].findAll.transform(list => list.maxBy(id => id)).saveAs("maximumId"))
    .check(isValidStatus(validStatuses))
    .check(responseValidation(validateSchema[Seq[Posts]]))
  )

  def putComment(body: PostPut): ChainBuilder = exec(http("Update a comment")
    .put(s"/posts/" + "${maximumId}")
    .body(StringBody(Json.toJson(body).toString))
    .check(isValidStatus(validStatuses))
  )

  val fetchPost: ChainBuilder = fetchPosts()

  val fetchPostsPerUser: ChainBuilder = fetchUserPost()

  val updateComment: ChainBuilder = putComment(
    PostPut("${maxUserId}", "${maximumId}", "Updated post title", "Comment example"))

}
