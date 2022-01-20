package com.example;

import com.example.abstracefactory.factory.Factory;
import com.example.abstracefactory.factory.Link;
import com.example.abstracefactory.factory.Page;
import com.example.abstracefactory.factory.Tray;
import com.example.adaptor.FileIO;
import com.example.adaptor.FileProperties;
import com.example.builder.Director;
import com.example.builder.TextBuilder;
import com.example.iterator.Book;
import com.example.iterator.BookShelf;
import com.example.iterator.Iterator;
import com.example.singletom.Singleton;
import com.example.singletom.TicketMaker;

import javax.xml.xpath.XPathEvaluationResult;
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

        // -------------------------------
        // Singleton
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Singleton");
        System.out.println("-------------------------------");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("obj1とobj2は同じインスタンスです");
        } else {
            System.out.println("obj1とobj2は同じインスタンスではありません");
        }

        // -------------------------------
        // Builder
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Builder");
        System.out.println("-------------------------------");
        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        String result = textBuilder.getResult();
        System.out.println(result);

        // -------------------------------
        // Abstract Factory
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Abstract Factory");
        System.out.println("-------------------------------");
        Factory factory = Factory.getInstance("listfactory.ListFactory");
        Link us_yahoo = factory.createLink("Yahoo!", "https://www.yahoo.com/");
        Link google = factory.createLink("Google", "https://www.google.com/");
        Tray trayYahoo = factory.createTray("Yahoo");
        trayYahoo.add(trayYahoo);
        Tray searchEngine = factory.createTray("SearchEngine");
        searchEngine.add(google);
        Page page = factory.createPage("LinkePage", "the author");
        page.add(trayYahoo);
        page.add(searchEngine);
        page.output();








    }
}
