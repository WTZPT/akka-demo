package com.example.demo.ch8Mailbox;

import akka.actor.AbstractActor;
import akka.actor.PoisonPill;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Demo extends AbstractActor {
    LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    {
        for (Object msg :
                new Object[] {
                        "lowpriority",
                        "lowpriority",
                        "highpriority",
                        PoisonPill.getInstance(),
                        "pigdog",
                        "pigdog2",
                        "pigdog3",
                        "highpriority"

                }) {
            getSelf().tell(msg, getSelf());
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(PoisonPill.class,m -> getContext().stop(getSelf()))
                .matchAny(
                        message -> {
                            log.info(message.toString());
                        })
                .build();
    }

    @Override
    public void postStop() throws Exception {
        log.debug("actor stop....");
        super.postStop();
    }
}
