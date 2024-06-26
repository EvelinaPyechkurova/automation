package com.evelina.pyechkurova;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class CipherTest {

    @Test
    public void testEncode() {
        String text = "Hello, World!";
        int shift = 3;
        assumeTrue(text != null && !text.isEmpty(), "Text should not be null or empty");
        String expected = "Khoor, Zruog!";
        String actual = Cipher.encode(text, shift);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDecode() {
        String text = "Khoor, Zruog!";
        int shift = 3;
        assumeTrue(text != null && !text.isEmpty(), "Text should not be null or empty");
        String expected = "Hello, World!";
        String actual = Cipher.decode(text, shift);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "'abc', 1, 'bcd'",
            "'xyz', 3, 'abc'",
            "'Hello, World!', 5, 'Mjqqt, Btwqi!'"
    })
    public void testParameterizedEncode(String text, int shift, String expected) {
        assumeTrue(text != null && !text.isEmpty(), "Text should not be null or empty");
        String actual = Cipher.encode(text, shift);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "'bcd', 1, 'abc'",
            "'abc', 3, 'xyz'",
            "'Mjqqt, Btwqi!', 5, 'Hello, World!'"
    })
    public void testParameterizedDecode(String text, int shift, String expected) {
        assumeTrue(text != null && !text.isEmpty(), "Text should not be null or empty");
        String actual = Cipher.decode(text, shift);
        assertThat(actual).isEqualTo(expected);
    }
}