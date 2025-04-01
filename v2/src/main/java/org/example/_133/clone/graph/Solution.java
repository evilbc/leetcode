package org.example._133.clone.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final int MAX_NODES = 100;

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Node[] nodes = new Node[MAX_NODES];
        boolean[] visited = new boolean[MAX_NODES];
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            int index = current.val - 1;
            if (visited[index])
                continue;
            visited[index] = true;
            Node newNode = getNode(current.val, nodes);
            for (Node neighbor : current.neighbors) {
                queue.add(neighbor);
                Node newNeighbor = getNode(neighbor.val, nodes);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return nodes[0];
    }

    private Node getNode(int val, Node[] nodes) {
        int index = val - 1;
        if (nodes[index] != null)
            return nodes[index];
        Node newNode = new Node(val);
        nodes[index] = newNode;
        return newNode;
    }
}
