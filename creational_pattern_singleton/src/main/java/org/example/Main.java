package org.example;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a log 1 message.");
        logger2.log("This is a log 2 message.");


        System.out.println("Are both loggers the same instance? " + (logger1 == logger2));
    }
}