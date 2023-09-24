package assignment1;

public class FahrenheitToCelsiusConverter {
    public double convert(String type, double tempature ) {
        if (type.equals("fahrenheit")) {
            return (tempature - 32) * 5 / 9;
        } else if (type.equals("celsius")) {
            return (tempature * 9 / 5) + 32;
        } else {
            return 0;
        }
    }


}
