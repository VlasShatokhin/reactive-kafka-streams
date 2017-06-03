import Dependencies.{Client, Common, Service}
import sbt.{Project, ThisBuild}
import sbt.Keys._
import sbt._
import sbtassembly.AssemblyKeys._
import sbtassembly.AssemblyPlugin

object BuildConfiguration {

  type ProjectProfile = Project => Project

  private val compilerFlags = Seq(
    "-deprecation",
    "-unchecked",
    "-Xexperimental",
    "-Xlint",
    "-feature",
    "-target:jvm-1.8",
    "-Xfatal-warnings")

  private val buildSettings = Seq(
    organization := "io.vs.rkafka",
    version := "0.1",
    scalaVersion := Common.Versions.`scala.version`,
    scalacOptions ++= compilerFlags,
    compileOrder := CompileOrder.JavaThenScala,
    crossPaths := false,
    sourcesInBase := false,
    target := (baseDirectory in ThisBuild).value / "target" / thisProject.value.id,
    test in assembly := {},
    logLevel := Level.Info)

  def rootProfile: ProjectProfile = _
    .settings(buildSettings: _*)
    .disablePlugins(AssemblyPlugin)

  def commonProfile: ProjectProfile = _
    .settings(buildSettings: _*)
    .settings(libraryDependencies ++= Common.libraries)
    .disablePlugins(AssemblyPlugin)

  def serviceProfile: ProjectProfile = _
    .settings(buildSettings: _*)
    .settings(libraryDependencies ++= Service.libraries)

  def clientProfile: ProjectProfile = _
    .settings(buildSettings: _*)
    .settings(libraryDependencies ++= Client.libraries)
}
