package org.example._530.minimum.absolute.difference.in.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        traverse(root, sorted);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < sorted.size(); i++) {
            int diff = sorted.get(i) - sorted.get(i - 1);
            if (diff == 0)
                return 0;
            if (diff < minDiff)
                minDiff = diff;
        }
        return minDiff;
    }

    private void traverse(TreeNode current, List<Integer> list) {
        if (current == null)
            return;

        traverse(current.left, list);
        list.add(current.val);
        traverse(current.right, list);
    }
}
