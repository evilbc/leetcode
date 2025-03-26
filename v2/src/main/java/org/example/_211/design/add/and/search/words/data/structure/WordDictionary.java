package org.example._211.design.add.and.search.words.data.structure;

import java.util.ArrayList;
import java.util.List;

class WordDictionary {
    private static class Node {
        private final Node[] children = new Node[26];
        private boolean isEndOfWord;

        public Node() {
        }

        public Node getChild(char ch) {
            return children[ch - 'a'];
        }

        public List<Node> getChildren() {
            List<Node> result = new ArrayList<>();
            for (Node child : children) {
                if (child != null)
                    result.add(child);
            }
            return result;
        }

        public boolean hasChild(char ch) {
            return children[ch - 'a'] != null;
        }

        public void addChild(char ch) {
            children[ch - 'a'] = new Node();
        }
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, Node current) {
        if (index == word.length())
            return current.isEndOfWord;

        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                return searchAllChildren(word, i, current);
            }
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    private boolean searchAllChildren(String word, int index, Node current) {
        for (Node child : current.getChildren()) {
            if (search(word, index + 1, child))
                return true;
        }
        return false;
    }

}
