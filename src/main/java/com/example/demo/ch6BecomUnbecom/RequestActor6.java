package com.example.demo.ch6BecomUnbecom;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.HashMap;
import java.util.Map;

public class RequestActor6 extends AbstractActor {

    protected final String name;
    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    private Receive hiHandler ;
    private Receive helloHandler;

    public RequestActor6(String name) {
        this.name = name;
        hiHandler = receiveBuilder()
                .matchEquals("Hi",message -> {log.info(message); getContext().become(helloHandler); })
                .matchAny(message -> {log.error(message.toString());})
                .build();
        helloHandler = receiveBuilder()
                .matchEquals("Hello",message -> {log.info(message); getContext().become(hiHandler);})
                .matchAny(message -> {log.error(message.toString());})
                .build();
    }

    public static Props props(String name) {
        return Props.create(RequestActor6.class,name);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class,message -> {
                    log.info(message);
                    getContext().become(helloHandler);
                })
                .build();
    }
}
