package com.epam.lowcost.controller;

public class Greet {
    private long id;
    private String name;

    public Greet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
