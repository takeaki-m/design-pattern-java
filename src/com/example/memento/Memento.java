package com.example.memento;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    // 同じパッケージ内からは自由にアクセスできるようにしたいから、privateになっていない
    int money;
    ArrayList fruits;

    public int getMoney() {
        return money;
    }

    // publicがついていないため、誰でもこのクラスを作れるわけではない。
    // 同じパッケージに属しているクラスのみが、作成できる
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }

    // mementパッケージ以外のクラスからは、Mementoの内部を変更することはできない
    // publicではないから、同じパッケージにクラスだけが操作できる
    ArrayList getFruits() {
        return (ArrayList) fruits.clone();
    }

    // publicではないから、同じパッケージにクラスだけが操作できる
    void addFruits(String fruit) {
        fruits.add(fruit);
    }
}
