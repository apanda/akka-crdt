import sbt._

object Dependencies {
  val AkkaVersion = "2.3.6"

  val akkaActor         = "com.typesafe.akka"         %% "akka-actor"               % AkkaVersion    % "compile"
  val akkaCluster       = "com.typesafe.akka"         %% "akka-cluster"             % AkkaVersion    % "compile"
  val playJson          = "com.typesafe.play"        %% "play-json"                % "2.3.4"        % "compile"
  val levelDbNative     = "org.fusesource.leveldbjni" % "leveldbjni-all"            % "1.6.1"        % "compile"
  val levelDbJava       = "org.iq80.leveldb"          % "leveldb"                   % "0.5"          % "compile"
  val unfiltered        = "net.databinder"            %% "unfiltered-netty-server"  % "0.8.4"        % "compile"
  val dispatch          = "net.databinder.dispatch"   %% "dispatch-core"            % "0.11.2"       % "compile"
  val scalaTest         = "org.scalatest"             %% "scalatest"                % "2.2.4"        % "test"
  val akkaMultiNodeTest = "com.typesafe.akka"         %% "akka-remote-tests"        % AkkaVersion    % "test"

  val runtime = List(akkaActor, akkaCluster, playJson, unfiltered, dispatch, levelDbNative, levelDbJava)
  val test    = List(scalaTest, akkaMultiNodeTest)
}
