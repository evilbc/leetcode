package org.example._843.guess.the.word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {
    private static final int SUCCESS = 6;
    private static final Random RANDOM = new Random();

    public void findSecretWord(String[] words, Master master) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        while (!wordList.isEmpty()) {
            String guess = wordList.get(RANDOM.nextInt(wordList.size()));
            int guessResult = master.guess(guess);
            if (guessResult == SUCCESS)
                return;

            List<String> candidates = new ArrayList<>();
            for (String word : wordList) {
                if (!word.equals(guess) && letterMatchCount(word, guess) == guessResult)
                    candidates.add(word);
            }
            wordList = candidates;
        }
    }

    private int letterMatchCount(String word1, String word2) {
        int matchCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i))
                matchCount++;
        }
        return matchCount;
    }
}
