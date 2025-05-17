package org.example._212.word.search.ii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final char ALREADY_USED = '.';

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(i, j, board, trie.root, result, new StringBuilder());
            }
        }
        return result;
    }

    private void findWords(int x, int y, char[][] board, Trie.Node node, List<String> result, StringBuilder sb) {
        if (isOutOfBounds(x, y, board) || board[x][y] == ALREADY_USED || !node.hasChild(board[x][y])) return;
        char c = board[x][y];
        board[x][y] = ALREADY_USED;
        node = node.getChild(c);
        sb.append(c);

        if (node.isEndOfWord) {
            result.add(sb.toString());
            node.isEndOfWord = false;
        }

        for (int[] direction : DIRECTIONS) {
            findWords(x + direction[0], y + direction[1], board, node, result, sb);
        }
        board[x][y] = c;
        sb.setLength(sb.length() - 1);
    }

    private boolean isOutOfBounds(int x, int y, char[][] board) {
        return !(x >= 0 && x < board.length && y >= 0 && y < board[0].length);
    }

    private static class Trie {
        private static class Node {
            private final Node[] children = new Node[26];
            private boolean isEndOfWord;

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

        public Trie() {
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
    }
}
