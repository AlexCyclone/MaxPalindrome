package icu.cyclone.alex;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxPalindrome(3));
    }

    public static int maxPalindrome(int mulFactor) {
        int max = (int) Math.pow(10, mulFactor) - 1;
        int maxPalindrome = 0;

        for (int i = max; i * i > maxPalindrome && i > Math.pow(10, mulFactor - 1); i--) {
            for (int j = i; i * j > maxPalindrome && j > Math.pow(10, mulFactor - 1) - 1; j--) {
                maxPalindrome = isPalindrome(i * j) && (i * j > maxPalindrome) ? i * j : maxPalindrome;
            }
        }
        return maxPalindrome;
    }

    public static boolean isPalindrome(int digit) {
        if (digit < 0) {
            throw new IllegalArgumentException("int must be bositive");
        }

        int originalDigit = digit;
        int invertDigit = 0;

        while (digit > 0) {
            invertDigit = invertDigit * 10 + digit % 10;
            digit /= 10;
        }

        return invertDigit == originalDigit;
    }
}
