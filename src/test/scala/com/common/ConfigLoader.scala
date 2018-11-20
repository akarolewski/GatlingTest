package com.common

import com.typesafe.config.{Config, ConfigFactory}

object ConfigLoader {
  val conf: Config = ConfigFactory.load()
}
