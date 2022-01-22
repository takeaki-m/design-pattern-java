package com.example.chainofrepository;

public class LimitSupport extends Support{
    public int limit;
    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    // 解決用メソッド
    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit? true : false;
    }
}
