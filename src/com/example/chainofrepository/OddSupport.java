package com.example.chainofrepository;

public class OddSupport extends Support{

    public OddSupport(String name) {
        super(name);
    }

    // 奇数番号のトラブルを処理するクラス
    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1 ? true : false;
    }
}
