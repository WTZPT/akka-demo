package com.example.demo.ch7LifeCycle;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class RequestActor7 extends AbstractActor {

    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    protected final String name;

    public RequestActor7(String name) {
        this.name = name;
    }

    static Props props(String name) {
        return Props.create(RequestActor7.class,name);
    }

    @Override
    public void preStart() throws Exception {
        log.info("preStart...");
        super.preStart();
    }

    @Override
    public void postStop() throws Exception {
        log.info("postStop...");
        super.postStop();
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("hello",message -> {
                    log.info(message);
                })
                .build();
    }
}
