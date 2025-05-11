package jdh.lr.CodeWars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeanSquareErrorTest {
    @Test
    public void test1() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {4, 5, 6};
        assertEquals(9.0, MeanSquareError.solution(a1, a2), 1e-15);
    }

    @Test
    public void test2() {
        int[] b1 = {10, 20, 10, 2};
        int[] b2 = {10, 25, 5, -2};
        assertEquals(16.5, MeanSquareError.solution(b1, b2), 1e-15);
    }

    @Test
    public void test3() {
        int[] c1 = {0, -1};
        int[] c2 = {-1, 0};
        assertEquals(1.0, MeanSquareError.solution(c1, c2), 1e-15);
    }

    @Test
    public void test4() {
        int[] d1 = {10, 10};
        int[] d2 = {10, 10};
        assertEquals(0.0, MeanSquareError.solution(d1, d2), 1e-15);
    }
}