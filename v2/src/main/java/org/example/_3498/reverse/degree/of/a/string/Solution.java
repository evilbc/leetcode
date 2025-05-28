package org.example._3498.reverse.degree.of.a.string;

class Solution {
    public int reverseDegree(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += (i + 1) * (('z' - s.charAt(i)) + 1);
        }
        return result;
    }
}