package com.example.mediator;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPassword;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;
    private ActionEvent e;

    // Colleagueを生成して配置した後に表示する
    public LoginFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new GridLayout(4,2));
        // Colleageueの生成
        this.createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPassword);
        add(buttonOk);
        add(buttonCancel);

        // 有効向こうの初期設定
        colleagueChanged();

        //表示
        pack();
        show();
    }

    @Override
    public void createColleagues() {
        // Colleagueの生成
        CheckboxGroup g  = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPassword = new ColleagueTextField("", 10);
        textPassword.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        //Mediatorのセット
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPassword.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        //Listenerのセット
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPassword.addTextListener(textPassword);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // colleagueからの通知で、各colleagueの有効・無効を判定する
    @Override
    public void colleagueChanged() {
       if(checkGuest.getState()) {
           textUser.setColleagueEnabled(false);
           textPassword.setColleagueEnabled(false);
           buttonOk.setColleagueEnabled(true);
       } else {
           textUser.setColleagueEnabled(true);
           userPassChanged();
       }
    }

    private void userPassChanged() {
        if (textUser.getText().length() > 3 ) {
            textPassword.setColleagueEnabled(true);
            if (textPassword.getText().length()> 3) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPassword.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }


}
