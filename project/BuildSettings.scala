import sbt._
import Keys._

object BuildSettings {

  // Basic settings for our app
  lazy val basicSettings = Seq[Setting[_]](
    organization  := "SnowPlow Analytics Ltd",
    version       := "0.0.1",
    description   := "File input format for Hadoop (incl. Hive) that makes it easy to read Omniture log data files directly into Hive, even if the fields contain new line and tab characters",
    scalaVersion  := "2.9.1",
    scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
    resolvers     ++= Dependencies.resolutionRepos
  )

  // sbt-assembly settings for building a fat jar
  import sbtassembly.Plugin._
  import AssemblyKeys._
  lazy val sbtAssemblySettings = assemblySettings ++ Seq(
    assembleArtifact in packageScala := false,
    jarName in assembly <<= (name, version) { (name, version) => name + "-" + version + ".jar" },
    mergeStrategy in assembly <<= (mergeStrategy in assembly) {
      (old) => {
        case x if x.startsWith("META-INF/") => MergeStrategy.discard
        case x => old(x)
      }
    }
  )

  lazy val buildSettings = basicSettings ++ sbtAssemblySettings
}