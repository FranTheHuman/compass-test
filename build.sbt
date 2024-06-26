ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "compass_test"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
