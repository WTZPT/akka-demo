package com.example.demo.ch8Mailbox;

import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedStablePriorityMailbox;
import com.typesafe.config.Config;

public class MyPrioMailbox extends UnboundedStablePriorityMailbox {
    public MyPrioMailbox(ActorSystem.Settings settings, Config config) {
        super(
                new PriorityGenerator() {
                    @Override
                    public int gen(Object message) {
                        if (message.equals("highpriority")) {
                            return 0; // 'highpriority messages should be treated first if possible
                        }
                        else if (message.equals("lowpriority")) {
                            return 2; // 'lowpriority messages should be treated last if possible
                        }
                        else if (message.equals(PoisonPill.getInstance())) {
                            return 3; // PoisonPill when no other left
                        }
                        else {
                            return 1; // By default they go between high and low prio
                        }
                    }
                }
        );
    }
}
