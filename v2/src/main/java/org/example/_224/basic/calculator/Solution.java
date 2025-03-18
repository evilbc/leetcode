package org.example._224.basic.calculator;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        boolean negate = false;
        boolean minusSign = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-')
                minusSign = true;

            else if (ch == '(') {
                stack.push(ch);
                if (minusSign) {
                    minusSign = false;
                    negate = !negate;
                    stack.push('-');
                }
            }

            else if (ch == ')') {
                if (stack.pop() == '-') { // dodać unary -> 4 - (-3)
                    negate = !negate;
                    stack.pop();
                }
            }

            else if (ch == '+' || ch == ' ')
                continue;

            else {
                int number = Character.getNumericValue(ch);
                while (i < s.length() - 1 && Character.getNumericValue(s.charAt(i+1)) <= 9 && Character.getNumericValue(s.charAt(i+1)) >= 0) {
                    number = number*10 + Character.getNumericValue(s.charAt(++i));
                }
                number *= (minusSign ^ negate) ? -1 : 1;
                sum += number;
                if (minusSign)
                    minusSign = false;
            }
        }

        return sum;
    }
}