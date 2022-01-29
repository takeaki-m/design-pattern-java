package com.example.flyweight;

import com.example.adaptor.FileIO;
import com.example.adaptor.FileProperties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    // 文字の名前
    private char charName;

    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try {
            String path = System.getProperty("user.dir");
            BufferedReader reader = new BufferedReader(new FileReader(path + "/src/com/example/flyweight/" + "big" + charName + ".txt"));
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontData = buf.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(fontData);
    }
}
