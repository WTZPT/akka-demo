package com.example.demo.ch1ClassicActor;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class RequestActor1 extends AbstractActor {

    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class,message -> { log.info(message);})
                .matchAny(message -> {log.info("Any match: "+message);})
                .build();
    }
}
