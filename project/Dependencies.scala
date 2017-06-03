import sbt._

object Dependencies {

  object Common {
    object Versions {
      val `scala.version` = "2.12.2"

    }

    val libraries = Seq(

    )
  }

  object Client {
    object Versions {

    }

    val libraries = Seq(

    )
  }

  object Service {
    object Versions {
      val `akka.version` = "2.4.17"
      val `http.version` = "10.0.6"
    }

    import Versions._

    val libraries = Seq(
      "com.typesafe.akka" %% "akka-actor"      % `akka.version`,
      "com.typesafe.akka" %% "akka-stream"     % `akka.version`,
      "com.typesafe.akka" %% "akka-http"       % `http.version`,
      "com.typesafe.akka" %% "akka-http-spray-json"  % `http.version`,
      "com.typesafe.akka" %% "akka-slf4j"      % `akka.version`,
      "com.typesafe.akka" %% "akka-stream-kafka" % "0.16",
      "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided",
      "com.softwaremill.macwire" %% "macrosakka" % "2.3.0" % "provided",
      "ch.qos.logback"    %  "logback-classic" % "1.2.3"
    )
  }
}
