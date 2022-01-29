package com.example.memento;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game {
    private int money;
    private List fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitName = {
            "Apple","Banana","Grape","Orange"
    };

    public Game(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("フルーツ" + f + "もらいました");
            fruits.add(f);
        } else {
            System.out.println("何も起こらなかった");
        }
    }

    // snapshot
    public Memento createMemento() {
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String)it.next();
            if (f.startsWith("おいしい")){
                m.addFruits(f);
            }
        }
        return m;
    }

    // undo
    public void restoreMemento(Memento memento) {
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "Game{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }

    private String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitName[random.nextInt(fruitName.length)];
    }
}
