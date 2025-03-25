package org.example._20.valid.parentheses;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        List<Character> leftBrackets = Arrays.asList('(', '{', '[');
        List<Character> rightBrackets = Arrays.asList(')', '}', ']');

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (leftBrackets.contains(ch))
                stack.push(ch);

            if (rightBrackets.contains(ch))
                if (stack.isEmpty() || rightBrackets.indexOf(ch) != leftBrackets.indexOf(stack.pop()))
                    return false;
        }

        return stack.isEmpty();
    }
}
