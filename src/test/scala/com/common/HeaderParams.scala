package com.common

import com.typesafe.config.Config
import ConfigLoader.conf

object HeaderParams {
  val headersConf: Config = conf.getConfig("headers")
  val userAgent = "User-Agent"
  val accept = "Accept"
  val acceptLanguage = "Accept-Language"
  val contentType = "Content-Type"
  val requestWith = "X-Requested-With"
  val host = "Host"
  val encoding = "Accept-Encoding"
  val sentHeaders = Map(
    userAgent -> headersConf.getString(userAgent),
    accept -> headersConf.getString(accept),
    acceptLanguage -> headersConf.getString(acceptLanguage),
    contentType -> headersConf.getString(contentType),
    requestWith -> headersConf.getString(requestWith),
    host -> headersConf.getString(host),
    encoding -> headersConf.getString(encoding)
  )
}