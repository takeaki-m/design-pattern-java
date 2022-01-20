package com.example.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {

        builder.makeTitle("Greeting");
        builder.makeString("document");
        builder.makeItem(new String[]{
                "Good morning",
                "Hello"
        });
        builder.makeString("at night");
        builder.close();
    }
}
