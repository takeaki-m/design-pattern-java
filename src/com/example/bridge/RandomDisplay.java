package com.example.bridge;

import java.util.Random;

public class RandomDisplay extends Display{
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        Random random = new Random();
        int max = random.nextInt(times);
        open();
        for (int i = 0; i < max; i++) {
            print();
        }
        close();
    }
}
