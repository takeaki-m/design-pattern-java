package com.example.chainofrepository;

public class SpecialSupport extends Support {
    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    // 指定された番号だけ処理する
    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number ? true : false;
    }
}
