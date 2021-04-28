# Akka Streams Actor Example

Example project for an investigation into Akka Streams interoperation with Actors.

https://doc.akka.io/docs/akka/current/stream/actor-interop.html

In the example the Actor is finished before it can be used in the stream.

https://doc.akka.io/docs/akka/current/actors.html#stopping-actors

This case results in the following log message:

```
[INFO] [akkaDeadLetter][04/28/2021 22:39:38.083] [QuickStart-akka.actor.default-dispatcher-6] [akka://QuickStart/deadLetters] Message [java.lang.String] from Actor[akka://QuickStart/user/translator#-1367066837] to Actor[akka://QuickStart/deadLetters] was not delivered. [1] dead letters encountered. If this is not an expected behavior then Actor[akka://QuickStart/deadLetters] may have terminated unexpectedly. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
hello
hi
```
