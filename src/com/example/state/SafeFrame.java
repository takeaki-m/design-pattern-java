package com.example.state;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeFrame extends Frame implements ActionListener, Context {
    // 現在時刻表示
    private TextField textClock = new TextField(60);
    // 警備センター出力
    private TextArea textScreen = new TextArea(10, 60);
    // 金庫使用ボタン
    private Button buttonUser = new Button("金庫使用");
    // 非常ベルボタン
    private Button buttonAlarm = new Button("非常ベル");
    // 通常通話
    private Button buttonPhone = new Button("通常通話");
    // 終了ボタン
    private Button buttonExit = new Button("終了");

    //現在の状態
    private State state = DayState.getInstance();

    public SafeFrame(String title) throws HeadlessException {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);

        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);

        Panel panel1 = new Panel();
        panel1.add(buttonUser);
        panel1.add(buttonAlarm);
        panel1.add(buttonPhone);
        panel1.add(buttonExit);

        add(panel1, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        buttonUser.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    // ボタンが押されたらここにくる
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());

        if (e.getSource() == buttonUser) {
            state.doUse(this);
        } else if (e.getSource() == buttonAlarm) {
            state.doAlarm(this);
        } else if (e.getSource() == buttonPhone) {
            state.doPhone(this);
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        } else {
                System.out.println("?");
        }
    }

    @Override
    public void setClock(int hour) {
        String clockString = "現在時刻は";
        if (hour < 10) {
            clockString += "0" + hour + ":00";
        } else{
            clockString += hour + ":00";
        }

        System.out.println(clockString);
        textClock.setText(clockString);
        state.doClock(this, hour);
    }

    @Override
    public void changeState(State state) {
        System.out.println(this.state + "から" + state + "へ状態が変化しました");
        this.state = state;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("caal!" + msg + "\n");
    }

    @Override
    public void recording(String msg) {
        textScreen.append("record..." + msg + "\n");
    }
}
