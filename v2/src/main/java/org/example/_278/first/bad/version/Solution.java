package org.example._278.first.bad.version;

class Solution {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (!isBadVersion(middle))
                left = middle + 1;
            else
                right = middle;
        }
        return right;
    }

    private boolean isBadVersion(int num) {
        return true;
    }
}