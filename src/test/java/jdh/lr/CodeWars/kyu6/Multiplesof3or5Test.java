package jdh.lr.CodeWars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Multiplesof3or5Test{
    @Test
    public void test() {
        assertEquals(23, new Multiplesof3or5().solution(10));
    }
}