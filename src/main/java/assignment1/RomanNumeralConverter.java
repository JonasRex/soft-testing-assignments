package assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RomanNumeralConverter {

    public String converter(int number) {
        String result = "";


        int[] numbers = {1000, 500, 100, 50, 10, 5, 1};
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            if (number >= currentNumber) {

                // TODO: Check the correct order of the roman numerals
                // E.G. 4 is IV not IIII


                int times = number / currentNumber;
                if (times < 4) {
                    for (int j = 0; j < times; j++) {
                        result += getRomanNumerals(currentNumber);
                    }
                    number = number % currentNumber;
                } else {


                    result += getRomanNumerals(currentNumber);
                    result += getRomanNumerals(numbers[i - 1]);
                    number = number % currentNumber;
                }
            }

        }
        return result;
    }


    private String getRomanNumerals(int number) {
        return switch (number) {
            case 0 -> "";
            case 1 -> "I";
            case 5 -> "V";
            case 10 -> "X";
            case 50 -> "L";
            case 100 -> "C";
            case 500 -> "D";
            case 1000 -> "M";
            default -> "Invalid";
        };
    }
}
