name := "DeCSHighlighter"

version := "0.1"

scalaVersion := "2.13.4" //"2.13.0"

val playJsonVersion = "2.9.1" //"2.9.0"
val scalajVersion = "2.4.2" //"2.4.1"
val servletApiVersion = "4.0.1" //"3.0.1"
val scalaTestVersion = "3.3.0-SNAP2" //"3.2.0-M2"
val supersafeVersion = "1.1.7"
val luceneVersion = "8.7.0" //"8.6.2"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % playJsonVersion,
  "org.scalaj" %% "scalaj-http" % scalajVersion,
  "javax.servlet" % "javax.servlet-api" % servletApiVersion % "provided",
  "org.apache.lucene" % "lucene-core" % luceneVersion,
  "org.apache.lucene" % "lucene-analyzers-common" % luceneVersion,
  "org.apache.lucene" % "lucene-backward-codecs" % luceneVersion,
  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
)

logBuffered in Test := false
trapExit := false

resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-Ywarn-unused")

enablePlugins(JettyPlugin)

javaOptions in Jetty ++= Seq(
  "-Xdebug",
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000"
)

containerPort := 7171

assemblyMergeStrategy in assembly := {
  case "module-info.class" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

//test in assembly := {}
