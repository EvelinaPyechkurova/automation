package com.evelina.pyechkurova.testcipher;

import com.evelina.pyechkurova.cipherlibrary.Cipher;

public class CipherTest {

    public static void main(String[] args) {
        testEncode();
        testDecode();
        testEncodeWithNonLetters();
        testDecodeWithNonLetters();
        testEncodeWithNegativeShift();
        testDecodeWithNegativeShift();
    }

    public static void testEncode() {
        String text = "hello";
        int shift = 3;
        String expected = "khoor";
        String actual = Cipher.encode(text, shift);
        String result = (expected.equals(actual)) ? "passed" : "failed";
        System.out.println(result);
    }

    public static void testDecode() {
        String text = "khoor";
        int shift = 3;
        String expected = "hello";
        String actual = Cipher.decode(text, shift);
        String result = (expected.equals(actual)) ? "passed" : "failed";
        System.out.println(result);
    }


    public static void testEncodeWithNonLetters() {
        String text = "hello, world!";
        int shift = 3;
        String expected = "khoor, zruog!";
        String actual = Cipher.encode(text, shift);
        String result = (expected.equals(actual)) ? "passed" : "failed";
        System.out.println(result);
    }

    public static void testDecodeWithNonLetters() {
        String text = "khoor, zruog!";
        int shift = 3;
        String expected = "hello, world!";
        String actual = Cipher.decode(text, shift);
        String result = (expected.equals(actual)) ? "passed" : "failed";
        System.out.println(result);
    }

    public static void testEncodeWithNegativeShift() {
        String text = "hello";
        int shift = -3;
        String expected = "ebiil";
        String actual = Cipher.encode(text, shift);
        String result = (expected.equals(actual)) ? "passed" : "failed";
        System.out.println(result);
    }

    public static void testDecodeWithNegativeShift() {
        String text = "ebiil";
        int shift = -3;
        String expected = "hello";
        String actual = Cipher.decode(text, shift);
        String result = (expected.equals(actual)) ? "passed" : "failed";
        System.out.println(result);
    }
}