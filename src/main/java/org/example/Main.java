package org.example;

public class Main {

    // Palindrom Sayıyı Bulma
    public static boolean isPalindrome(int number) {
        int reversed = 0;
        int originalNumber = number;

        number = Math.abs(number); // Negatif sayılar için pozitif işleme
        while (number > 0) {
            int lastDigit = number % 10;
            reversed = (reversed * 10) + lastDigit;
            number /= 10;
        }

        return Math.abs(originalNumber) == reversed;
    }


    // Mükemmel Sayıları Bulma
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    // Sayıları Kelimelere Dök
    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        StringBuilder words = new StringBuilder();
        int reversedNumber = reverse(number);
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversedNumber);

        while (reversedNumber > 0) {
            int lastDigit = reversedNumber % 10;
            words.append(digitToWord(lastDigit)).append(" ");
            reversedNumber /= 10;
        }

        // Eğer sayıdaki orijinal rakam sayısı ile ters sayının rakam sayısı eşit değilse
        while (reversedDigitCount < originalDigitCount) {
            words.append("Zero ");
            reversedDigitCount++;
        }

        return words.toString().trim();
    }

    // Yardımcı metodlar
    private static int reverse(int number) {
        int reversed = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            reversed = (reversed * 10) + lastDigit;
            number /= 10;
        }
        return reversed;
    }

    private static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    private static String digitToWord(int digit) {
        return switch (digit) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "";
        };
    }
}
