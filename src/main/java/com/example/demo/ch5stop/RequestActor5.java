package com.example.demo.ch5stop;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;


import java.util.HashMap;
import java.util.Map;

public class RequestActor5 extends AbstractActor {

    protected final String name;
    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    protected final Map<String, Object> map = new HashMap<>();

    public RequestActor5(String name) {
        this.name = name;
    }

    static Props props(String name) {
        return Props.create(RequestActor5.class, name);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("done",message -> {
                    getContext().stop(getSelf());
                })
                .match(String.class,message->{
                    log.info("Received Request {}",message);
                    map.put("StringMessage",message);
                })
                .matchAny(o->log.info("Received unknow message {}",o))
                .build();
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("RequestActor5 is done");
    }
}
