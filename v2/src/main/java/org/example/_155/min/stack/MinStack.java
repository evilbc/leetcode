package org.example._155.min.stack;

import java.util.LinkedList;
import java.util.List;

class MinStack {
    private static class Node {
        private int value;
        private int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    private List<Node> nodes = new LinkedList<>();

    public MinStack() {
    }

    public void push(int val) {
        int min = val;
        if (!nodes.isEmpty())
            min = Math.min(val, nodes.getFirst().min);
        nodes.addFirst(new Node(val, min));
    }

    public void pop() {
        nodes.removeFirst();
    }

    public int top() {
        if (nodes.isEmpty())
            throw new IllegalStateException("Stack is empty, can't get min");

        return nodes.getFirst().value;
    }

    public int getMin() {
        if (nodes.isEmpty())
            throw new IllegalStateException("Stack is empty, can't get min");

        return nodes.getFirst().min;
    }
}
