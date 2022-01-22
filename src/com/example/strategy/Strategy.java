package com.example.strategy;

public interface Strategy {
    // 次に出す手を得る
    Hand nextHand();
    // ひとつ前に出して手によって勝ったかどうか
    void study(boolean win);
}
