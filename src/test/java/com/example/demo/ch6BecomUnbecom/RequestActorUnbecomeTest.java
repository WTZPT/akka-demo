package com.example.demo.ch6BecomUnbecom;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;

class RequestActorUnbecomeTest {
    ActorSystem system = ActorSystem.create();
    @Test
    public void test() {
        TestActorRef<RequestActorUnbecome> actorRef = TestActorRef.create(system,RequestActorUnbecome.props("Request"));
        actorRef.tell("init", ActorRef.noSender());// info init
        actorRef.tell("Hello",ActorRef.noSender());//info Hello
        actorRef.tell("Hi",ActorRef.noSender());//info Hi
        actorRef.tell("Hello",ActorRef.noSender());//info Hello
        actorRef.tell("Hello",ActorRef.noSender());//error Hello
        actorRef.tell("Hi",ActorRef.noSender());//info Hi
    }
}