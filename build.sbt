enablePlugins(GatlingPlugin)

scalaVersion := "2.12.4"

scalacOptions := Seq(
  "-encoding",
  "UTF-8",
  "-target:jvm-1.8",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:implicitConversions",
  "-language:postfixOps"
)

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.3.0" % "test,it"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"