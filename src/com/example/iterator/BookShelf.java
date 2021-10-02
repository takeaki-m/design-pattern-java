package com.example.iterator;

import java.util.ArrayList;

public class BookShelf implements Aggregate {
    // 当初はsh池のように実装していたがコードサンプルを見て変更
    // private List<Book> books;
    private ArrayList books;

    public BookShelf(int initialSize) {
        books = new ArrayList(initialSize);
    }

    public Book getBookAt(int index){
        return (Book)books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
