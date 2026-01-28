package org.example;

public class DebugDemo {
    static String name = "rawoof";

    public static void main(String[] args) {
        System.out.print(printName());
    }

    public static boolean printName() {
        System.out.println(name.length());
        return false;
    }
}


// java.lang.NullPointerException