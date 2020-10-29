package com.example.demo.hello;

import akka.actor.*;
import akka.actor.typed.Behavior;
import akka.actor.typed.PostStop;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class HelloWorld extends AbstractBehavior<Void> {


    private HelloWorld(ActorContext<Void> context) {
        super(context);
        context.getLog().info("Application started...");
    }

    public static Behavior<Void> create() {
        return Behaviors.setup(HelloWorld::new);
    }

    @Override
    public Receive<Void> createReceive() {
        System.out.println("32131321231");
        return newReceiveBuilder().onSignal(PostStop.class,signal -> onPostStop()).build();
    }

    private HelloWorld onPostStop() {
        getContext().getLog().info("Application Stop....");
        return this;
    }


}
