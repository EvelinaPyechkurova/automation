package com.evelina.pyechkurova.ciphercore;
import com.evelina.pyechkurova.cipherencoder.Encoder;
import com.evelina.pyechkurova.cipherdecoder.Decoder;
import org.apache.commons.lang3.*;
import java.util.Scanner;

public class CaesarCipher {

    static final int SHIFT_LENGTH = 2;
    static final int TEXT_LENGTH = 10;

    public static void main(String[] args) {
        int shift = (Integer.parseInt(RandomStringUtils.randomNumeric(SHIFT_LENGTH)))%26;
        System.out.println("Shift: " + shift);
        String text = RandomStringUtils.randomAlphabetic(TEXT_LENGTH);
        System.out.println("Text: "+text);
        String encodedLine = Encoder.encode(text, shift);
        System.out.println("Encoded line: " + encodedLine);
        System.out.println("Decoded line: " + Decoder.decode(encodedLine, shift));
    }
}