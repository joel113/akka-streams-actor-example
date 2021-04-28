package com.joel.akka.streams

import akka.NotUsed
import akka.actor.{Actor, ActorSystem, Props}
import akka.stream.scaladsl.Source
import akka.util.Timeout

import scala.concurrent.duration.DurationInt

class Translator extends Actor {
  def receive = {
    case word: String =>
      val reply = word.toUpperCase
      sender() ! reply // reply to the ask
    case "done" =>
      context.stop(self)
  }
}

object Main extends App {

  implicit val system: ActorSystem = ActorSystem("QuickStart")

  val translator = system.actorOf(Props[Translator](), "translator")

  implicit val askTimeout = Timeout(5.seconds)

  val words: Source[String, NotUsed] = Source(List("hello", "hi"))

  translator ! "done"

  words
    .ask[String](parallelism = 5)(translator)
    // continue processing of the replies from the actor
    .map(_.toLowerCase)
    .log("stream")
    .runForeach(println)

}
