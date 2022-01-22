package com.example.decorator;

public abstract class Border extends Display {
    // 飾りが囲っている、中身
    protected Display display;
    protected Border(Display display) {
        this.display = display;
    }
}
