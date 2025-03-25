package org.example._146.lru.cache;

import java.util.*;

class LRUCache {
    private static final int NO_KEY = -1;
    private final Map<Integer, Node> map;
    private final int capacity;
    private final Node head;
    private final Node tail;
    private int size;

    public LRUCache(int capacity) {
        head = new Node(NO_KEY, NO_KEY);
        tail = new Node(NO_KEY, NO_KEY);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        useNode(key);
        Node node = map.get(key);
        return node == null ? NO_KEY : node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            useNode(key);
            node.val = value;
            return;
        }
        addNode(new Node(key, value));
    }

    private void useNode(int key) {
        Node node = map.get(key);
        if (node == null)
            return;

        deleteNode(node);
        addNode(node);
    }

    private void addNode(Node node) {
        if (size == capacity) {
            Node toDelete = tail.prev;
            deleteNode(toDelete);
            map.remove(toDelete.key);
        }

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        map.put(node.key, node);

        size++;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head;
        size--;
    }

    private static class Node {
        private Node next;
        private Node prev;
        private final int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
