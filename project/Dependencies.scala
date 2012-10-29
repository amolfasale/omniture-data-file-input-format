import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    ScalaToolsSnapshots
  )

  object V {
    val hadoop         = "0.20.2"    
    val logging        = "1.1.1"
    val junitInterface = "0.10-M2"
  }

  object Libraries {
    val hadoop         = "org.apache.hadoop"          %  "hadoop-core"          % V.hadoop         % "provided"
    val logging        = "commons-logging"            %  "commons-logging"      % V.logging        % "provided"
    val junitInterface = "com.novocode"               % "junit-interface"       % V.junitInterface % "test"
  }
    
}