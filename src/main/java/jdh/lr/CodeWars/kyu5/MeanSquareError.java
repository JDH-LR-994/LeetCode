package jdh.lr.CodeWars.kyu5;

public class MeanSquareError {
    public static double solution(int[] c1, int[] c2) {
        double sum = 0;
        for (int i = 0; i < c1.length; ++i) {
            sum += Math.pow(c1[i] - c2[i], 2);
        }
        return sum / c1.length;
    }
}
