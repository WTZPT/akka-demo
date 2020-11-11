package com.example.demo.ch7LifeCycle;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Kill;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestActor7Test {
    ActorSystem system = ActorSystem.create();
    @Test
    public void test1() {
        TestActorRef<RequestActor7> actorRef = TestActorRef.create(system, RequestActor7.props("request"));
        actorRef.tell(Kill.getInstance(), ActorRef.noSender());
    }
}