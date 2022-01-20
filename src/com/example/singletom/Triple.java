package com.example.singletom;

public class Triple {
    private static Triple[] triple = new Triple[] {
            new Triple(1),
            new Triple(2),
            new Triple(3),
    };
    private int id;
/*
    private static Triple triple1 = new Triple();
    private static Triple triple2 = new Triple();
    private static Triple triple3 = new Triple();
*/

//    private Triple() {
//    }
    private Triple (int id) {
        this.id = id;
    }

    public Triple getInstanceWithNumber(int instanceNumber) {
        return triple[id];
//        switch (instanceNumber) {
//            case 1:
//                return triple1;
//            case 2:
//                return triple2;
//            case 3:
//                return triple3;
//            default:
//                return triple1;
//        }
    }

    public String toString() {
        return "[Triple id=" + id + "]";
    }
}
