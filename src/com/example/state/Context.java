package com.example.state;

public interface Context {
    // 自国の設定
    void setClock(int hour);
    // 状態変化
    void changeState(State state);
    // 警備センター呼び出し
    void callSecurityCenter(String msg);
    // 警備センター記録
    void recording(String msg);
}
