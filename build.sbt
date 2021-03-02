name := "CoinGeckoScala"

version := "0.1"

scalaVersion := "2.13.5"


scalacOptions ++= Seq("-deprecation", "-feature", "-language:postfixOps")

libraryDependencies ++= Seq("com.lihaoyi" %% "requests" % "0.6.5",
                            "com.lihaoyi" %% "upickle" % "0.9.5",
                            "org.scalactic" %% "scalactic" % "3.2.5",
                            "org.scalatest" %% "scalatest" % "3.2.5" % "test"
)
