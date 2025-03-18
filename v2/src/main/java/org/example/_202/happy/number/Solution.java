package org.example._202.happy.number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        return  isHappy(n, seen);
    }

    private boolean isHappy(int n, Set<Integer> seen) {
        if (n == 1)
            return true;
        if (seen.contains(n))
            return false;
        seen.add(n);

        int next = 0;
        while (n > 0) {
            next += Math.pow(n%10, 2);
            n /= 10;
        }
        return isHappy(next, seen);
    }
}