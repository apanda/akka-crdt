// ======== imports ========
import Resolvers._
import Dependencies._
//import com.typesafe.sbt.SbtMultiJvm
//import com.typesafe.sbt.SbtMultiJvm.MultiJvmKeys.MultiJvm
import scalariform.formatter.preferences._

// ======== settings ========
organization := "com.typesafe.akka"

name := "akka-crdt"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.2"

resolvers += "Sonatype Snapshots Repo"  at "https://oss.sonatype.org/content/groups/public"

resolvers += "Temporary Play JSON repo" at "https://github.com/mandubian/mandubian-mvn/raw/master/snapshots/"

libraryDependencies ++= Dependencies.runtime

libraryDependencies ++= Dependencies.test

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-encoding", "UTF-8"
)

// ======== scalariform ========
scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(RewriteArrowSymbols, true)
  .setPreference(AlignParameters, true)
  .setPreference(AlignSingleLineCaseStatements, true)


