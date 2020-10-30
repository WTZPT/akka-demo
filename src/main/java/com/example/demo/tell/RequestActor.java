package com.example.demo.tell;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.HashMap;
import java.util.Map;

public class RequestActor extends AbstractActor {

    protected final LoggingAdapter log = Logging.getLogger(context().system(),this);
    protected final Map<String,Object> map = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SetRequest.class,message -> {
                    log.info("Received Set request: {}", message);
                    map.put(message.getKey(), message.getValue());
                    sender().tell(new Status.Success(message.getKey()), self());
                })
                .match(GetRequest.class,message -> {
                    log.info("Received Get request: {}", message);
                    Object value = map.get(message.key);
                    Object response = (value != null)
                            ? value
                            : new Status.Failure(new KeyNotFoundException(message.key));
                    sender().tell(response, self());
                })
                .matchAny(o -> sender().tell(new Status.Failure(new ClassNotFoundException()),self()))
                .build();
    }
}