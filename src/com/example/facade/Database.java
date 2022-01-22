package com.example.facade;

import com.example.visitor.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database(){}

    public static Properties getProperties(String dbname){
        String userDir = System.getProperty("user.dir");
        String filename = userDir + "/src/com/example/facade/" + dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    };
}
