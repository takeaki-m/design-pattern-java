package com.example.flyweight;

import java.util.HashMap;

public class BigCharFactory {
    // すでに作成したBigCharのインスタンスを管理
    private HashMap pool = new HashMap();

    //singleton
    private static BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory(){};

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public synchronized BigChar getBigChar(char charName) {
        BigChar bc = (BigChar) pool.get("" +charName);
        if(bc == null) {
            bc = new BigChar(charName);
            pool.put(""+charName, bc);
        }
        return bc;
    }
}
