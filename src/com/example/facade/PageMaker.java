package com.example.facade;

import com.example.strategy.WinningStategy;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker(){};

    public static void makeWelcomePage(String mailAddress, String fileName) {
        try {
            Properties mailProp = Database.getProperties("maildata");
            String userName = mailProp.getProperty(mailAddress);
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.paragraph("Welcome to " + userName + "page");
            writer.mailto(mailAddress, userName);
            writer.close();
            System.out.println(fileName + "is created for" + mailAddress + "(" + userName + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
