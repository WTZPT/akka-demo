package com.example.demo.ch6BecomUnbecom;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestActor6Test {
    ActorSystem system = ActorSystem.create();

    @Test
    public void test() {
        TestActorRef<RequestActor6> ref = TestActorRef.create(system,RequestActor6.props("request6"));
        ref.tell("init",ActorRef.noSender());
        ref.tell("Hello",ActorRef.noSender());
        ref.tell("Hi",ActorRef.noSender());
        ref.tell("Hello",ActorRef.noSender());
        ref.tell("Hi",ActorRef.noSender());
        ref.tell("Hello",ActorRef.noSender());
        ref.tell("Hello",ActorRef.noSender());
    }
}