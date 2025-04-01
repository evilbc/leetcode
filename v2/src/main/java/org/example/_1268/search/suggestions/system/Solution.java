package org.example._1268.search.suggestions.system;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MAX_SIZE = 3;
    private static final int LETTER_COUNT = 26;

    private static class Node {
        private final Node[] children = new Node[LETTER_COUNT];
        private boolean isEndOfWord;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node head = new Node();

        for (String product : products) {
            addWord(head, product);
        }

        Node current = head;
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            if (current == null) {
                result.add(new ArrayList<>());
                continue;
            }
            current = current.children[c - 'a'];
            sb.append(c);
            result.add(getCurrentSuggestions(current, sb));
        }
        return result;
    }

    private List<String> getCurrentSuggestions(Node node, StringBuilder sb) {
        List<String> result = new ArrayList<>();
        traverse(node, sb, result);
        return result;
    }

    private void traverse(Node node, StringBuilder sb, List<String> result) {
        if (node == null || result.size() == MAX_SIZE)
            return;

        if (node.isEndOfWord) {
            result.add(sb.toString());
        }

        for (int i = 0; i < LETTER_COUNT; i++) {
            Node child = node.children[i];
            if (child == null)
                continue;
            sb.append((char) ('a' + i));
            traverse(child, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }

    private void addWord(Node head, String str) {
        Node current = head;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node();
            }
            current = current.children[c - 'a'];
        }
        current.isEndOfWord = true;
    }
}
