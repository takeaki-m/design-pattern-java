package com.example.adaptor;

import java.io.*;
import java.util.Properties;

// 最初は下のように実装していたので残しておく
// public class FileProperties implements FileIO {
//    private Properties properties;

public class FileProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(String filePath) throws IOException {
        super.load(new FileInputStream(filePath));
    }

    @Override
    public void writeToFile(String filePath) throws IOException {
        super.store(new FileOutputStream(filePath) , "written by FileProperties" );
    }

    @Override
    public void setValue(String key, String value) {
        super.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return super.getProperty(key);
    }
}
