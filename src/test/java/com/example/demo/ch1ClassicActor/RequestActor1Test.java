package com.example.demo.ch1ClassicActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;

class RequestActor1Test {
    ActorSystem actorSystem = ActorSystem.create();

    @Test
    public void test() {
        TestActorRef<RequestActor1> actorRef = TestActorRef.create(actorSystem, Props.create(RequestActor1.class));
        actorRef.tell("Hello world!", ActorRef.noSender());
    }

}