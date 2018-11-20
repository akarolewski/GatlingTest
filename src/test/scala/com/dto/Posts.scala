package com.dto

import play.api.libs.json.{Json, OFormat}

case class Posts(
  userId: Int,
  id: Int,
  title: String,
  body: String
)

object Posts {
  implicit val format: OFormat[Posts] = Json.format[Posts]
}