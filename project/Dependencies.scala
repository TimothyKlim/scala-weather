/*
 * Copyright (c) 2013-2015 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
import sbt._
import Keys._

object Dependencies {

  val resolutionRepos = Seq(
    "Sonatype" at "https://oss.sonatype.org/content/repositories/releases",
    // For scala-util
    "Snowplow Analytics" at "http://maven.snplow.com/releases/",
    // For Twitter's LRU cache
    "Twitter Maven Repo" at "http://maven.twttr.com/",
    // For scalaz-7.0 & specs2
    "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
  )

  object V {
    // Java
    val jodaTime = "2.9.4"
    val jodaConvert = "1.8.1"

    // Scala
    val scalaz = "7.2.6"
    val json4s = "3.4.0"
    val akka = "2.4.10"
    val collUtil = "6.37.0"

    // Tests
    val mockito = "1.9.5"
    val scalaCheck = "1.13.2"
    val specs2 = "3.8.5"
  }

  object Libraries {
    // Java
    val jodaTime = "joda-time" % "joda-time" % V.jodaTime
    val jodaConvert = "org.joda" % "joda-convert" % V.jodaConvert

    // Scala
    val scalaz = "org.scalaz" %% "scalaz-core" % V.scalaz
    val json4s = "org.json4s" %% "json4s-core" % V.json4s
    val json4sJackson = "org.json4s" %% "json4s-jackson" % V.json4s
    val json4sScalaz = "org.json4s" %% "json4s-scalaz" % V.json4s
    val akka = "com.typesafe.akka" %% "akka-actor" % V.akka
    val akkaStreams = "com.typesafe.akka" %% "akka-stream-experimental" % V.akka
    val akkaHttp = "com.typesafe.akka" %% "akka-http-experimental" % V.akka

    val collUtil = "com.twitter" %% "util-collection" % V.collUtil

    // Tests
    val mockito = "org.mockito" % "mockito-core" % V.mockito % "test"
    val specs2 = "org.specs2" %% "specs2-core" % V.specs2 % "test"
    val specs2Mock = "org.specs2" %% "specs2-mock" % V.specs2 % "test"
    val specsScalaCheck = "org.specs2" %% "specs2-scalacheck" % V.specs2 % "test"
    val scalaCheck = "org.scalacheck" %% "scalacheck" % V.scalaCheck % "test"
  }
}
