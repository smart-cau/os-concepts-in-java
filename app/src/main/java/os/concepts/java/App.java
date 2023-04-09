package os.concepts.java;

import os.concepts.java.thread.ThreadExample;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        ThreadExample te = new ThreadExample();
        te.start();
    }
}
