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
import com.example.chainofrepository.*;
import com.example.command.CommandMain;
import com.example.composite.Directory;
import com.example.composite.File;
import com.example.composite.FileTreatmentException;
import com.example.decorator.FullBorder;
import com.example.decorator.SideBorder;
import com.example.decorator.StringDisplay;
import com.example.facade.PageMaker;
import com.example.flyweight.BigString;
import com.example.interpreter.Context;
import com.example.interpreter.Node;
import com.example.interpreter.ParseException;
import com.example.interpreter.ProgramNode;
import com.example.iterator.Book;
import com.example.iterator.BookShelf;
import com.example.iterator.Iterator;
import com.example.mediator.LoginFrame;
import com.example.memento.Game;
import com.example.memento.Memento;
import com.example.observer.*;
import com.example.proxy.Printable;
import com.example.proxy.PrinterProxy;
import com.example.singletom.Singleton;
import com.example.state.SafeFrame;
import com.example.strategy.Hand;
import com.example.strategy.Player;
import com.example.strategy.ProbStrategy;
import com.example.strategy.WinningStategy;
import com.example.visitor.ListVisitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args){
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

        // -------------------------------
        // Decorator
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Decorator");
        System.out.println("-------------------------------");
        com.example.decorator.Display b1 = new StringDisplay("hello wolrd");
        com.example.decorator.Display b2 = new SideBorder(b1, '#');
        com.example.decorator.Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        com.example.decorator.Display b4 = new SideBorder(
                new FullBorder(
                        new FullBorder(
                                new SideBorder(
                                        new FullBorder(
                                                new StringDisplay("Hello World")
                                        ),
                                        '*'
                                )
                        )
                ),
                '/'
        );
        b4.show();
        // -------------------------------
        // Visitor
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Visitor");
        System.out.println("-------------------------------");
        System.out.println("Making root entries");
        try {
            com.example.visitor.Directory rootDir = new com.example.visitor.Directory("root");
            com.example.visitor.Directory binDir = new com.example.visitor.Directory("bin");
            com.example.visitor.Directory tmpDir = new com.example.visitor.Directory("tmp");
            com.example.visitor.Directory usrDir = new com.example.visitor.Directory("usr");
            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            binDir.add(new com.example.visitor.File("vi", 10000));
            binDir.add(new com.example.visitor.File("latex", 20000));
            rootDir.accept(new ListVisitor());
            System.out.println("");
            System.out.println("Making User Entries");

            com.example.visitor.Directory yuki = new com.example.visitor.Directory("yuki");
            com.example.visitor.Directory hanako = new com.example.visitor.Directory("hanako");
            usrDir.add(yuki);
            usrDir.add(hanako);
            yuki.add(new com.example.visitor.File("diary.html", 100));
            hanako.add(new com.example.visitor.File("memo.txt", 300));
            rootDir.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
        // -------------------------------
        // Chain of Responsibility
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Chain of Responsibility");
        System.out.println("-------------------------------");
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new LimitSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);
        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i = 0; i < 500; i+=33) {
            alice.support(new Trouble(i));
        }
        // -------------------------------
        // Facade
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Facade");
        System.out.println("-------------------------------");
        PageMaker.makeWelcomePage("example@example.com", "welcome.html");
       // -------------------------------
        // Observer
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Observer");
        System.out.println("-------------------------------");
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObservers(observer1);
        generator.addObservers(observer2);
        generator.execute();

        // -------------------------------
        // Memento
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Memento");
        System.out.println("-------------------------------");
        Game gamer = new Game(100);
        // 最初の状態を保存しておく
        Memento memento= gamer.createMemento();
        for (int i = 0; i < 100; i++) {
            // 回数表示
            System.out.println("=== " + i);
            // 現在の主人公の状態を表示
            System.out.println("現状 " + gamer);
            // gameを進める
            gamer.bet();
            // 現在の状態
            System.out.println("所持金は" + gamer.getMoney() + "円になりました");

            //Mementoの取り扱い決定
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println(" 所持金が増えたので、現在の状態を保存しておく");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() /2 ) {
                System.out.println("所持金が減ったので以前の状態に復帰する");
                gamer.restoreMemento(memento);
            }

            // 実行待ち
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
        // -------------------------------
        // FlyWeight
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("FlyWeight");
        System.out.println("-------------------------------");

        BigString bs = new BigString("987635421");
        bs.print();
        // -------------------------------
        // Proxy
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Proxy");
        System.out.println("-------------------------------");
        Printable p = new PrinterProxy("Alice");
        System.out.println("Current Name is" + p.getPrinterName());
        p.setPrinterName("Bob");
        System.out.println("Current Name is" + p.getPrinterName());
        p.print("Hello World");
        // -------------------------------
        // Command
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Command");
        System.out.println("-------------------------------");
        new CommandMain("Command Pattern Sample");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // -------------------------------
        // Mediator
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Mediator");
        System.out.println("-------------------------------");
        new LoginFrame("Mediator Sample");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // -------------------------------
        // interpreter
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("Interpreter");
        System.out.println("-------------------------------");
        String pathIterpreter = System.getProperty("user.dir");
        try{
            BufferedReader reader = new BufferedReader(new FileReader(pathIterpreter + "/src/com/example/interpreter/program.txt"));
            String text;
            while ((text = reader.readLine()) != null){
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node =" + node);

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        // -------------------------------
        // State
        // -------------------------------
        System.out.println("-------------------------------");
        System.out.println("State");
        System.out.println("-------------------------------");
        SafeFrame frame = new SafeFrame("State Sample");
        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }




    }
}
