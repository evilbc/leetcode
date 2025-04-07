package org.example._1071.greatest.common.divisor.of.strings;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String gcd = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2)
                return gcd;
            sb.append(c1);
            if (isDivisor(str1, sb) && isDivisor(str2, sb))
                gcd = sb.toString();
        }

        return gcd;
    }

    private boolean isDivisor(String str, CharSequence candidate) {
        if (str.length() % candidate.length() != 0)
            return false;
        int candidateIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (candidateIndex == candidate.length())
                candidateIndex = 0;
            if (candidate.charAt(candidateIndex) != str.charAt(i))
                return false;
            candidateIndex++;
        }

        return true;
    }
}
