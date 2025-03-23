package org.example._125.valid.palindrome;

class Solution {
    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");;
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1)
            return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            if (!isAlphanumeric(leftChar)) {
                left++;
                continue;
            }
            char rightChar = s.charAt(right);
            if (!isAlphanumeric(rightChar)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}