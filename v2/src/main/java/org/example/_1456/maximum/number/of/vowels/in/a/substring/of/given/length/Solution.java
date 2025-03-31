package org.example._1456.maximum.number.of.vowels.in.a.substring.of.given.length;

class Solution {
    public int maxVowels(String s, int k) {
        int count = countStartingVowels(s, k);
        int max = count;
        int left = 0;

        for (int right = k; right < s.length(); right++) {
            char leftChar = s.charAt(left++);
            char rightChar = s.charAt(right);

            if (isVowel(leftChar))
                count--;
            if (isVowel(rightChar)) {
                count++;
                if (count > max)
                    max = count;
            }
        }

        return max;
    }

    private int countStartingVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (isVowel(c))
                count++;
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
