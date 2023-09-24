package assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FahrenheitToCelsiusConverterTest {
    FahrenheitToCelsiusConverter converter = new FahrenheitToCelsiusConverter();

    @org.junit.jupiter.api.Test
    void convertFahrenheitToCelsius() {
        double celsius = converter.convert("fahrenheit", 32);
        assertEquals(0, celsius);
    }

    @org.junit.jupiter.api.Test
    void convertCelsiusToFahrenheit() {
        double fahrenheit = converter.convert("celsius", 0);
        assertEquals(32, fahrenheit);
    }
}