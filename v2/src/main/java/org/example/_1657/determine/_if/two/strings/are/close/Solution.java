package org.example._1657.determine._if.two.strings.are.close;

import java.util.Arrays;

class Solution {
    private static final int LETTERS = 26;

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] arr1 = new int[LETTERS];
        int[] arr2 = new int[LETTERS];

        for (int i = 0; i < word1.length(); i++) {
            arr1[word1.charAt(i) - 'a']++;
            arr2[word2.charAt(i) - 'a']++;
        }
        if (!allCharsExistInBoth(arr1, arr2))
            return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
            if (arr1[i] == 0)
                return true;
        }

        return true;
    }

    private boolean allCharsExistInBoth(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if ((arr1[i] == 0 && arr2[i] > 0) || (arr1[i] > 0 && arr2[i] == 0))
                return false;
        }
        return true;
    }

}
