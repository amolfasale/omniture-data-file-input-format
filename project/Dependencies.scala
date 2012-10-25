import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    ScalaToolsSnapshots,
    "SnowPlow Analytics Maven repo" at "http://maven.snplow.com/releases/"
  )

  object V {
    val hadoop    = "0.20.205"    
    val logging   = "1.1.1"
  }

  object Libraries {
    val hadoop      = "org.apache.hadoop"          %  "hadoop-core"          % V.hadoop      % "provided"
    val logging     = "commons-logging"            %  "commons-logging"      % V.logging     % "provided"
  }
    
}