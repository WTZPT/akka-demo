package com.example.demo.ch6BecomUnbecom;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;

class RequestActor6Test {
    ActorSystem system = ActorSystem.create();

    @Test
    public void test() {
        TestActorRef<RequestActor6> ref = TestActorRef.create(system,RequestActor6.props("request6"));
        ref.tell("init",ActorRef.noSender()); //info init
        ref.tell("Hello",ActorRef.noSender()); //info Hello
        ref.tell("Hi",ActorRef.noSender()); //info Hi
        ref.tell("Hello",ActorRef.noSender()); //info Hello
        ref.tell("Hi",ActorRef.noSender()); //info Hi
        ref.tell("Hello",ActorRef.noSender());//info Hello
        ref.tell("Hello",ActorRef.noSender()); //error Hello
    }
}