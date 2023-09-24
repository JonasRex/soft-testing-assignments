package assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralConverterTest {

    RomanNumeralConverter numeralConverter = new RomanNumeralConverter();


    @Test
    void expectI() {

        int input = 1;
        String expected = "I";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXIII() {

        int input = 13;
        String expected = "XIII";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXIV() {

        int input = 14;
        String expected = "XIV";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void convert() {

            int input = 95;
            String expected = "VC";
            String result = numeralConverter.converter(input);
            assertEquals(expected, result);
    }

    @Test
    void expectCDMXCIX() {
        // Failing...
        int input = 499;
        String expected = "CDXCIX";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectIX() {
        // Failing...
        int input = 9;
        String expected = "IX";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }


    @Test
    void expectIXWithArray() {
        int input = 14;
        String expected = "XIV";
        String result = numeralConverter.converterWithArray(input);
        assertEquals(expected, result);
    }

}