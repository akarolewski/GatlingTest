package com.common

import ConfigLoader.conf
import HeaderParams.sentHeaders
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder


object Config {

  val appUrl: String = conf.getString("url")
  val urlConfig: HttpProtocolBuilder = http.baseURL(appUrl)
  val httpConfig: HttpProtocolBuilder = urlConfig.headers(sentHeaders)
}
