package com.common

import io.gatling.http.check.HttpCheck
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import Status.OK
import com.typesafe.scalalogging.Logger
import io.gatling.core.check.ValidatorCheckBuilder
import play.api.libs.json.{JsError, JsSuccess, Json, Reads}

object Helpers {

  private val logger = Logger("Validation Errors")

  def isValidStatus(httpStatus: Seq[Int]): HttpCheck = status.in(httpStatus)

  def responseValidation(check: HttpCheck): HttpCheck =
    checkIf[Response, HttpCheck]((r: Response, _: Session) => r.statusCode.contains(OK)) {
      check
    }

  def validateJSONBody[T: Reads]: ValidatorCheckBuilder[HttpCheck, Response, String, Boolean] =
    bodyString.transform { (json, _) =>
      Json.parse(json).validate[T] match {
        case JsSuccess(_, _) => true
        case JsError(errors) =>
          logger.error(errors.toString)
          false
      }
    }

  def validateSchema[T: Reads] = validateJSONBody.is(true)
}
