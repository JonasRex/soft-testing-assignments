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

    public String converterWithArray(int number) {
        ArrayList<String> result = new ArrayList<>();
        int length = 0;

        int[] numbers = {1000, 500, 100, 50, 10, 5, 1, 0};

        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.println(result);
            int currentNumber = numbers[i];
            if (number >= currentNumber) {


                // Check the correct order of the roman numerals
                // if number is 4 then it's IV not IIII

                int times = number / currentNumber;
                if (times < 4) {

                    for (int j = 0; j < times; j++) {
                        result.add(getRomanNumerals(currentNumber));
                        length++;
                    }

                    number = number % currentNumber;

                } else {
                    // Number is 4, 9, 14 etc.
                    // Result is IV, IX, XIV etc.

                    System.out.println(result);

                    // Overwrite the previous roman numeral
                    result.remove(length - 1);
                    length--;


                    // Add the current roman numeral (1 or 2 times)
                    for (int j = 0; j < times - 3; j++) {
                        result.add(getRomanNumerals(currentNumber));
                        length++;
                    }


                    // Add the previous roman numeral
                    result.add(getRomanNumerals(numbers[i - 2]));
                    length++;







                    number = number % currentNumber;

                }
            }
        }


        return String.join("", result);
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
