package com.example.chainofrepository;

public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    // 何も問題を処理しないクラス
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
