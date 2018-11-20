package com.common.dto

import play.api.libs.json.{Json, OFormat}

case class PostPut(
  userId: String,
  id: String,
  title: String,
  body: String
)

object PostPut {
  implicit val format: OFormat[PostPut] = Json.format[PostPut]
}
