package org.example._17.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final String[] digitCharacters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty())
            return result;

        letterCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void letterCombinations(String digits, int index, StringBuilder builder, List<String> list) {
        if (index == digits.length()) {
            list.add(builder.toString());
            return;
        }

        int number = Character.getNumericValue(digits.charAt(index));
        for (char ch : digitCharacters[number].toCharArray())
            letterCombinations(digits, index + 1, new StringBuilder(builder).append(ch), list);
    }
}
