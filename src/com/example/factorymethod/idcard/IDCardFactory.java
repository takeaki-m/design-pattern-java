package com.example.factorymethod.idcard;

import com.example.factorymethod.framework.Factory;
import com.example.factorymethod.framework.Product;

import java.util.*;

public class IDCardFactory extends Factory {
    private HashMap database = new HashMap();
    private int number = 100;

    // serialをカウントアップする
    // protected Product createProduct(String owner, int number) {
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, number++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard card = (IDCard)product;
        database.put(card.getNumber(), card.getOwner());
    }

    public HashMap getOwners() {
        return database;
    }
}
