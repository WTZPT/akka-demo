package com.example.demo.ch4;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.HashMap;
import java.util.Map;


public class RequestActor4 extends AbstractActor {

    protected final String name;
    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    protected final Map<String, Object> map = new HashMap<>();

    public RequestActor4(String name) {
        this.name = name;
    }

    static Props props(String name) {
        return Props.create(RequestActor4.class, name);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class,message->{
                    log.info("Received Request {}",message);
                    map.put("StringMessage",message);
                })
                .matchAny(o->log.info("Received unknow message {}",o))
                .build();
    }
}
