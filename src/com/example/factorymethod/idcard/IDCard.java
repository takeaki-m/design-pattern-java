package com.example.factorymethod.idcard;

import com.example.factorymethod.framework.Product;

import javax.swing.*;

public class IDCard extends Product {
    private String owner;
    private int number;
    IDCard(String owner, int number){
        System.out.println("Create" + owner + "(" + number + ")"+ "card");
        this.owner = owner;
        this.number = number;
    }
    @Override
    public void use() {
        System.out.println("use" + owner + "(" + number + ")"+ "card");
    }

    public String getOwner() {
        return owner;
    }

    public int getNumber() {
        return number;
    }
}
