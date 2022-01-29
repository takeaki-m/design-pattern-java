package com.example.mediator;

public interface Colleague {
    //メンバーに相談を持ちかけるメンバーを表す

    // 相談役を指定するメソッド（最初に呼び出されて相談役が設定される
    void setMediator(Mediator mediator);

    // 相談役からやってくる指示に相当する
    // 自分の状態を自分で決めるのではなく、外部から設定される
    // true- 自分を有効状態に false->自分を無効状態に
    void setColleagueEnabled(boolean enabled);
}