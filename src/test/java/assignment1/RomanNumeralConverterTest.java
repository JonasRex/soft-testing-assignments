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
    void expectII() {

        int input = 2;
        String expected = "II";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectIII() {

        int input = 3;
        String expected = "III";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectIV() {

        int input = 4;
        String expected = "IV";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectV() {

        int input = 5;
        String expected = "V";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectVI() {

        int input = 6;
        String expected = "VI";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectVII() {

        int input = 7;
        String expected = "VII";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectVIII() {

        int input = 8;
        String expected = "VIII";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectIX() {

        int input = 9;
        String expected = "IX";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectX() {

        int input = 10;
        String expected = "X";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXI() {

        int input = 11;
        String expected = "XI";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXII() {

        int input = 12;
        String expected = "XII";
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
    void expectXV() {

        int input = 15;
        String expected = "XV";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXVI() {

        int input = 16;
        String expected = "XVI";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXVII() {

        int input = 17;
        String expected = "XVII";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXVIII() {

        int input = 18;
        String expected = "XVIII";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXIX() {

        int input = 19;
        String expected = "XIX";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

    @Test
    void expectXX() {

        int input = 20;
        String expected = "XX";
        String result = numeralConverter.converter(input);
        assertEquals(expected, result);
    }

}