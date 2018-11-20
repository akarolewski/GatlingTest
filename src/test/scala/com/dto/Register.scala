package com.dto

import play.api.libs.json.{Json, OFormat}

case class Register(
  username: String,
  password: String
)

object Register {
  implicit val format: OFormat[Register] = Json.format[Register]
}