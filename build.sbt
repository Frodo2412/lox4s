ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.2"

lazy val root = (project in file("."))
    .settings(
      name             := "lox4s",
      idePackagePrefix := Some("com.brunolemus.lox4s"),
      libraryDependencies ++= Seq(
        "org.typelevel" %% "cats-effect" % "3.5.4",
        "co.fs2"        %% "fs2-core"    % "3.10.2",
        "co.fs2"        %% "fs2-io"      % "3.10.2"
      )
    )
