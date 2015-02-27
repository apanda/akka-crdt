import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtAspectj.{ Aspectj, aspectjSettings, useInstrumentedClasses }
import com.typesafe.sbt.SbtAspectj.AspectjKeys.inputs
import Dependencies._

object InterpositionBuild extends Build {
  lazy val interposition = Project(
    id = "akka-crdt",
    base = file("."),
    settings = Defaults.defaultSettings ++ aspectjSettings ++ Seq(
      organization := "com.typesafe.sbt.aspectj",
      version := "0.1",
      scalaVersion := "2.11.5",
      resolvers += "Sonatype Snapshots Repo"  at "https://oss.sonatype.org/content/groups/public",
      resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
      libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.6",
      libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.3.6",
      libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2",
      libraryDependencies += "com.assembla.scala-incubator" %% "graph-core" % "1.9.0",
      libraryDependencies += "com.assembla.scala-incubator" %% "graph-dot" % "1.9.0",
      libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
      libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2",
      libraryDependencies ++= Dependencies.runtime,
      libraryDependencies ++= Dependencies.test,


      // add akka-actor as an aspectj input (find it in the update report)
      inputs in Aspectj <++= update map { report =>
        report.matching(moduleFilter(organization = "com.typesafe.akka", name = "akka-actor*"))
      },

      // replace the original akka-actor jar with the instrumented classes in runtime
      fullClasspath in Runtime <<= useInstrumentedClasses(Runtime)
    )
  )
}
