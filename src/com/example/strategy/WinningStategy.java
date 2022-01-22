package com.example.strategy;

import java.util.Random;

public class WinningStategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if(!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
