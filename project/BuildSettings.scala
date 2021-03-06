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
import org.scalafmt.sbt.ScalaFmtPlugin.autoImport._

object BuildSettings {

  // Basic settings for our app
  lazy val basicSettings = Seq[Setting[_]](
    organization := "com.snowplowanalytics",
    version := "0.3.0-kt",
    description := "High-performance Scala library for performing current and historical weather lookups ",
    scalaVersion := "2.11.8",
    scalacOptions := Seq("-encoding",
                         "UTF-8",
                         "-target:jvm-1.8",
                         "-unchecked",
                         "-deprecation",
                         "-feature",
                         "-language:higherKinds",
                         "-language:existentials",
                         "-language:postfixOps",
                         "-Xexperimental",
                         "-Xlint",
                         // "-Xfatal-warnings",
                         "-Xfuture",
                         "-Ybackend:GenBCode",
                         "-Ydelambdafy:method",
                         "-Yno-adapted-args",
                         "-Yopt-warnings",
                         "-Yopt:l:classpath",
                         "-Yopt:unreachable-code" /*,
                         "-Ywarn-dead-code",
                         "-Ywarn-infer-any",
                         "-Ywarn-numeric-widen",
                         "-Ywarn-unused",
                         "-Ywarn-unused-import",
                         "-Ywarn-value-discard"*/ ),
    resolvers ++= Dependencies.resolutionRepos
  )

  // Publish settings
  // TODO: update with ivy credentials etc when we start using Nexus
  lazy val publishSettings = Seq[Setting[_]](
    // Enables publishing to maven repo
    publishMavenStyle := true,
    publishTo <<= version { version =>
      val basePath = "target/repo/%s".format {
        if (version.trim.endsWith("SNAPSHOT")) "snapshots/" else "releases/"
      }
      Some(
        Resolver
          .file("Local Maven repository", file(basePath)) transactional ())
    }
  )

  lazy val buildSettings = basicSettings ++ reformatOnCompileSettings ++ publishSettings
}
