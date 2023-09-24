package assignment1;

public class RomanNumeralConverter {


    public String hardcodedConverter(int number) {
        switch (number) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";

            default:
                return "Invalid";
        }
    }

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
            } else {
                result += getRomanNumerals(currentNumber);
                number = number % currentNumber;
            }

        }
        return result;
    }

    private String getRomanNumerals(int number) {
        switch (number) {
            case 1:
                return "I";
            case 5:
                return "V";
            case 10:
                return "X";
            case 50:
                return "L";
            case 100:
                return "C";
            case 500:
                return "D";
            case 1000:
                return "M";

            default:
                return "Invalid";
        }
    }
}
