package com.evelina.pyechkurova;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("First cat:");
        Cat cat = new Cat("Vestra", "Street cat", 25, "Evelina", 120, "good");
        System.out.println("Second cat:");
        Cat cat2 = new Cat("Mira", "Scottish Fold", 13, "Lilia", 99, "good");
        System.out.println("Third cat:");
        Cat cat3 = new Cat("Matska", "Street cat", 13, "Lilia", 25, "good");
    }
}
