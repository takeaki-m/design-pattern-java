package com.example;

import com.example.adaptor.FileIO;
import com.example.adaptor.FileProperties;
import com.example.iterator.Book;
import com.example.iterator.BookShelf;
import com.example.iterator.Iterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // -------------------------------
        // Iterator
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Iterator Pattern");
        System.out.println("-------------------------------");
        BookShelf bookShelf = new BookShelf(1);
        bookShelf.appendBook(new Book("Jump"));
        bookShelf.appendBook(new Book("Magazine"));
        bookShelf.appendBook(new Book("Sunday"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }


        // -------------------------------
        // Adaptor
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Adaptor Pattern");
        System.out.println("-------------------------------");
        String path = System.getProperty("user.dir");
        FileIO f = new FileProperties();
        try {
            f.readFromFile(path + "/src/com/example/resource/file.txt");
            f.setValue("year", "2004");
            f.setValue("month", "4");
            f.setValue("day", "21");
            f.writeToFile(path + "/src/com/example/resource/newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
