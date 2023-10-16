package assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FahrenheitToCelsiusConverterTest {
    FahrenheitToCelsiusConverter converter = new FahrenheitToCelsiusConverter();

    @Test
    void convertFahrenheitToCelsius() {
        double celsius = converter.convert("fahrenheit", 32);
        assertEquals(0, celsius);
    }

    @Test
    void convertCelsiusToFahrenheit() {
        double fahrenheit = converter.convert("celsius", 0);
        assertEquals(32, fahrenheit);
    }
}