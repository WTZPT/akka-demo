package com.example.demo.ch5stop;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Kill;
import akka.actor.PoisonPill;
import akka.testkit.TestActorRef;
import org.junit.jupiter.api.Test;



class RequestActor5Test {
    ActorSystem system = ActorSystem.create();
    @Test
    public void test1() {
        TestActorRef<RequestActor5> actorRef = TestActorRef.create(system, RequestActor5.props("request"));
        actorRef.tell(Kill.getInstance(), ActorRef.noSender());
    }

    @Test
    public void test2() {
        TestActorRef<RequestActor5> actorRef = TestActorRef.create(system, RequestActor5.props("request"));
        actorRef.tell(PoisonPill.getInstance(), ActorRef.noSender());
    }

    @Test
    public void test3() {
        TestActorRef<RequestActor5> actorRef = TestActorRef.create(system, RequestActor5.props("request"));
        actorRef.tell("done", ActorRef.noSender());
    }

    @Test
    public void test4() {
        TestActorRef<RequestActor5> actorRef = TestActorRef.create(system, RequestActor5.props("request"));
        actorRef.tell("message", ActorRef.noSender());
        system.stop(actorRef);
    }
}