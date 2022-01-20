package com.example.singletom;

public class TicketMaker {
    private static int ticket = 10000;
    private static TicketMaker ticketMaker = new TicketMaker();

    private TicketMaker() {
    }

    // public static int getNextTicketNumber() {
    // synchronizedをつけないと、複数のスレッドに同じ値を返す恐れがある
    public synchronized int getNextTicketNumber() {
        return ticket++;
    }

    public static TicketMaker getInstance() {
        return ticketMaker;
    }
}
