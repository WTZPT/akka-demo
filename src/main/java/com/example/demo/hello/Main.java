package com.example.demo.hello;

import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        ActorSystem.create(HelloWorld.create(),"akks-system");
    }
}
