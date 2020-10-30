package com.example.demo.general;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import lombok.ToString;


import java.util.HashMap;
import java.util.Map;
@ToString
public class RequestActor extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    protected final Map<String,Object> map = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(Request.class,message ->{
                    log.info("Received Request {}",message);
                    map.put(message.getKey(), message.getValue());
                })
                .matchAny(o->log.info("Received unknow message {}",o))
                .build();
    }
}
