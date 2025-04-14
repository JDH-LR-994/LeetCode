package jdh.lr.YandexContests.BackendSchool2025.Easy;

import java.util.Scanner;
import java.util.Stack;

public class WillThereBeAnyDownsides {
    static int i = 0;

    static long calculate(String expression) {
        Stack<Long> stack = new Stack<>();
        long currentNumber = 0;
        int sign = 1;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
                i++;
            } else if (ch == '+' || ch == '-') {
                if (currentNumber != 0) {
                    stack.push(sign * currentNumber);
                    sign = 1;
                }
                currentNumber = 0;
                sign = (ch == '+') ? 1 : -sign;
                i++;
            } else if (ch == '(') {
                i++;
                long innerValue = calculate(expression);
                currentNumber += innerValue;
            } else if (ch == ')') {
                stack.push(sign * currentNumber);
                long sum = 0;
                while (!stack.isEmpty()) {
                    sum += stack.pop();
                }
                i++;
                return sum;
            } else {
                i++;
            }
        }
        stack.push(sign * currentNumber);
        long sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        i = 0;
        System.out.println(calculate(expression));
    }
}
