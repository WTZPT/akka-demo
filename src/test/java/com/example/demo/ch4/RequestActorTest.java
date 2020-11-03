package com.example.demo.ch4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestActorTest {
    ActorSystem system = ActorSystem.create();
    @Test
    public void test() {
        TestActorRef<RequestActor> actorRef = TestActorRef.create(system, RequestActor.props("request"));
        actorRef.tell(String.valueOf("this is a message"), ActorRef.noSender());
        RequestActor requestActor = actorRef.underlyingActor();
        assertEquals("request",requestActor.name);
        assertEquals("this is a message",requestActor.map.get("StringMessage"));
    }
}