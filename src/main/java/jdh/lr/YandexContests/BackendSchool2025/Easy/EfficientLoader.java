package jdh.lr.YandexContests.BackendSchool2025.Easy;


import java.util.Scanner;

public class EfficientLoader {
    public static long findMaxPalindromeLengthAtPosition(long[] array, long centerPosition) {
        long leftExpansion = 0;
        long rightExpansion = 0;
        int currentPosition = (int) centerPosition;

        while (((centerPosition + rightExpansion) != array.length - 1)
                && array[currentPosition + (int) rightExpansion + 1] == array[currentPosition]) {
            rightExpansion++;
        }

        while (((centerPosition - leftExpansion - 1) >= 0)
                && array[currentPosition - (int) leftExpansion - 1] == array[currentPosition]) {
            leftExpansion++;
        }

        while ((centerPosition + rightExpansion + 1) < array.length
                && (centerPosition - leftExpansion - 1) >= 0) {
            if (array[currentPosition + (int) rightExpansion + 1]
                    != array[currentPosition - (int) leftExpansion - 1]) {
                break;
            } else {
                leftExpansion++;
                rightExpansion++;
            }
        }

        return leftExpansion + rightExpansion + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long arraySize = scanner.nextLong();
        long[] numbers = new long[(int) arraySize];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextLong();
        }

        long maxPalindromeLength = 0;
        for (int i = 0; i < numbers.length; i++) {
            long currentPalindromeLength = findMaxPalindromeLengthAtPosition(numbers, i);
            maxPalindromeLength = Math.max(maxPalindromeLength, currentPalindromeLength);
        }

        System.out.println(maxPalindromeLength == 1 ? 0 : maxPalindromeLength);
    }
}
