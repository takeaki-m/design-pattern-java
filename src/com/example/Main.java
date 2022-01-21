package com.example;

import com.example.abstracefactory.factory.Factory;
import com.example.abstracefactory.factory.Link;
import com.example.abstracefactory.factory.Page;
import com.example.abstracefactory.factory.Tray;
import com.example.adaptor.FileIO;
import com.example.adaptor.FileProperties;
import com.example.bridge.CountDisplay;
import com.example.bridge.Display;
import com.example.bridge.StringDisplayImpl;
import com.example.builder.Director;
import com.example.builder.TextBuilder;
import com.example.composite.Directory;
import com.example.composite.File;
import com.example.composite.FileTreatmentException;
import com.example.iterator.Book;
import com.example.iterator.BookShelf;
import com.example.iterator.Iterator;
import com.example.singletom.Singleton;
import com.example.singletom.TicketMaker;
import com.example.strategy.Hand;
import com.example.strategy.Player;
import com.example.strategy.ProbStrategy;
import com.example.strategy.WinningStategy;

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
//        System.out.println("-------------------------------");
//        System.out.println("Abstract Factory");
//        System.out.println("-------------------------------");
//        Factory factory = Factory.getInstance("listfactory.ListFactory");
//        Link us_yahoo = factory.createLink("Yahoo!", "https://www.yahoo.com/");
//        Link google = factory.createLink("Google", "https://www.google.com/");
//        Tray trayYahoo = factory.createTray("Yahoo");
//        trayYahoo.add(trayYahoo);
//        Tray searchEngine = factory.createTray("SearchEngine");
//        searchEngine.add(google);
//        Page page = factory.createPage("LinkePage", "the author");
//        page.add(trayYahoo);
//        page.add(searchEngine);
//        page.output();


        // -------------------------------
        // Bridge
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Bridge");
        System.out.println("-------------------------------");
        Display d1 = new Display(new StringDisplayImpl("Hello, Japan"));
        CountDisplay d2 = new CountDisplay(new StringDisplayImpl("Hello World"));
        d1.display();
        d2.multiDisplay(5);

        // -------------------------------
        // Strategy
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Strategy");
        System.out.println("-------------------------------");

        int seed1 = Integer.parseInt("314");
        int seed2 = Integer.parseInt("497");

        Player p1 = new Player("Taro", new WinningStategy(seed1));
        Player p2 = new Player("Hanako", new ProbStrategy(seed2));
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = p1.nextHand();
            Hand nextHand2 = p2.nextHand();
            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner" + p1);
                p1.win();
                p2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner" + p2);
                p1.lose();
                p2.win();
            } else {
                System.out.println("Even");
                p1.even();
                p2.even();
            }

            System.out.println("Total Result");
            System.out.println(p1.toString());
            System.out.println(p2.toString());

        }

        // -------------------------------
        // Composite
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Composite");
        System.out.println("-------------------------------");
        System.out.println("Making root entries");
        try {
            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));
            rootDir.printList();
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }








    }
}
