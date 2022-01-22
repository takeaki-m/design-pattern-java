package com.example.strategy;

public class Hand {
    public static final int HANDVALUE_GU = 0;
    public static final int HANDVALUE_CHO = 1;
    public static final int HANDVALUE_PAA = 2;

    public static final Hand[] hand = {
            new Hand(HANDVALUE_GU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),

    };
    private static final String[] name = {
            "GUU", "CHOKI", "PAA"
    };

    private int handValue;
    public Hand(int handValue) {
        this.handValue = handValue;

    }

    public static Hand getHand(int handvalue) {
        return hand[handvalue];
    }

    public boolean isStrongerThan (Hand h) {
        return fight(h) == 1;
    }

    public boolean isWeakerThan (Hand h) {
        return fight(h) == -1;
    }

    private int fight(Hand h) {
        if (this == h) {
            // 引き分け
            return 0;
        } else if ((this.handValue + 1) % 3 == h.handValue) {
            // thisの勝ち
           return 1;
        } else {
            // hの勝ち
            return -1;
        }
    }

    // 文字列表現への置換
    @Override
    public String toString() {
        return name[handValue];
    }
}
