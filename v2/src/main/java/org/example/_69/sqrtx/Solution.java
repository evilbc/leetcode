package org.example._69.sqrtx;

class Solution {
    public static int mySqrt(int x) {
        if (x == 0)
            return 0;

        if (x == 1)
            return 1;

        return mySqrt(0, x, x);
    }

    private static int mySqrt(int left, int right, int target) {
        if (right < left)
            return right;

        int middle = (left + right) / 2;

        if (target / middle == middle)
            return middle;

        if (target / middle > middle)
            return mySqrt(middle + 1, right, target);

        return mySqrt(left, middle - 1, target);
    }
}