package assignment2;

class StringUtility {
    String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    String capitalizeString(String string) {
        return string.toUpperCase();
    }

    String lowerCaseString(String string) {
        return string.toLowerCase();
    }
}