package com.evelina.pyechkurova.cipherdecoder;


public class Decoder {
    public static String decode(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base - shift + 26) % 26 + base));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}