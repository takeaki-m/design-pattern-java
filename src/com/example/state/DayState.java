package com.example.state;

public class DayState implements State{
    private static DayState singleton = new DayState();

    // コンストラクタはprivate
    private DayState(){};

    // 唯一のインスタンス
    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        // 時刻設定
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getSingleton());
        }
    }
    // stateパターンでは、状態の違いがクラスとして表現されているので、ifやswitchによる状態のチェックが不要
    @Override
    public void doUse(Context context) {
        context.recording("金庫使用(昼間)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(昼間)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の通話(昼間)");
    }

    @Override
    public String toString(){
        return "昼間";
    }
}
