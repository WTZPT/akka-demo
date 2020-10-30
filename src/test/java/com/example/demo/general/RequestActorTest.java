package com.example.demo.general;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestActorTest {
    ActorSystem system = ActorSystem.create();
    @Test
    public void test() {
        TestActorRef<RequestActor> actorRef = TestActorRef.create(system, Props.create(RequestActor.class));
        actorRef.tell(new Request("key","value"), ActorRef.noSender());
        RequestActor requestActor = actorRef.underlyingActor();
        System.out.println(requestActor.toString());
        assertEquals(requestActor.map.get("key"),"value");
    }

}