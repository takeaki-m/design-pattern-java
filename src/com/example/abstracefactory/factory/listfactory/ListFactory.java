package com.example.abstracefactory.factory.listfactory;

import com.example.abstracefactory.factory.Factory;
import com.example.abstracefactory.factory.Link;
import com.example.abstracefactory.factory.Page;
import com.example.abstracefactory.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return null;
    }

    @Override
    public Page createPage(String title, String author) {
        return null;
    }
}
