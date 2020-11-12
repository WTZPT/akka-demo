package com.example.demo.ch6BecomUnbecom;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class RequestActorUnbecome extends AbstractActor{
    protected final String name;
    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    private AbstractActor.Receive hiHandler ;
    private AbstractActor.Receive helloHandler;

    public RequestActorUnbecome(String name) {
        this.name = name;
        hiHandler = receiveBuilder()
                .matchEquals("Hi",message ->{
                    log.info(message);
                    getContext().unbecome();
                })
                .matchAny(message -> {log.error(message.toString());})
                .build();
        helloHandler = receiveBuilder()
                .matchEquals("Hello",message -> {
                    log.info(message);
                    getContext().become(hiHandler,false);
                })
                .matchAny(message -> {log.error(message.toString());})
                .build();
    }

    static Props props(String name) {
        return Props.create(RequestActorUnbecome.class,name);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("init",message -> {
                    log.info(message);
                    getContext().become(helloHandler);
                })
                .build();
    }
}
