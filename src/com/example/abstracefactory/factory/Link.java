package com.example.abstracefactory.factory;

public abstract class Link extends Item {
    protected String url;

    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }

    // SuperClass Itemの抽象メソッドが呼ばれる
}
