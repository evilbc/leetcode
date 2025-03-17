package org.example;

import java.util.*;

public class Trie {

    private static class Node {
        private final Node[] children = new Node[26];
        private boolean isEndOfWord;

        public Node() {
        }

        public Node getChild(char ch) {
            return children[ch - 'a'];
        }

        public boolean hasChild(char ch) {
            return children[ch - 'a'] != null;
        }

        public void addChild(char ch) {
            children[ch - 'a'] = new Node();
        }
    }

    private final Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return true;
    }
}
