package io.vs.rkafka.service

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

object ReactiveAnalyzerApp extends App {
  implicit val actorSystem = ActorSystem("service")
  implicit val materializer = ActorMaterializer()
  implicit val context = actorSystem.dispatcher

}
