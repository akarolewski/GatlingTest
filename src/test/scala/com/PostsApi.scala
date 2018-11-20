package com

import com.common.Config.httpConfig
import com.scenarios.Posts._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder

class PostsApi extends Simulation {

  val accountScenario: ScenarioBuilder = scenario("API request and response validation")
    .exec(
      fetchPost,
      fetchPostsPerUser,
      updateComment
    )

  setUp(accountScenario.inject(atOnceUsers(1)).protocols(httpConfig))
}
