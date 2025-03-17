package org.example;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String s = String.valueOf(x);
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1))
                return false;
        }

        return true;
    }
}
