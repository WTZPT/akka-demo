package com.example.demo.ch8Mailbox;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("system", ConfigFactory.load("akka.conf"));
        system.actorOf(Props.create(Demo.class).withDispatcher("prio-dispatcher"));
    }
}
