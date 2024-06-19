package com.evelina.pyechkurova.ciphercore;
import com.evelina.pyechkurova.cipherlibrary.Cipher;
import java.util.Scanner;

// Module that uses my java library
public class Main {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        String text = "Hello World!";
        int shift = 5;

        //text = stringScanner.nextLine();
        //shift = stringScanner.nextInt();

        System.out.println("Text: "+text+", shift: "+shift);
        String encoded = Cipher.encode(text, shift);
        System.out.println("Encoded text: "+encoded);
        String decoded = Cipher.decode(encoded, shift);
        System.out.println("Decoded text: "+decoded);
    }
}