package org.example._150.evaluate.reverse.polish.notation;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!isOperation(token)) {
                stack.addLast(Integer.parseInt(token));
                continue;
            }

            Integer num2 = stack.removeLast();
            Integer num1 = stack.removeLast();
            int operationResult = calculate(token, num1, num2);
            stack.addLast(operationResult);
        }

        return stack.removeLast();
    }

    private boolean isOperation(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int calculate(String operation, int num1, int num2) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}
