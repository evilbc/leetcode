package org.example._437.path.sum.iii;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, new ArrayList<>());
        return count;
    }

    private void traverse(TreeNode node, int targetSum, List<Long> sums) {
        if (node == null)
            return;

        List<Long> newSums = new ArrayList<>();
        for (Long sum : sums) {
            long newSum = sum + node.val;
            newSums.add(newSum);
            if (newSum == targetSum) {
                count++;
            }
        }

        if (node.val == targetSum)
            count++;
        newSums.add((long) node.val);
        traverse(node.left, targetSum, newSums);
        traverse(node.right, targetSum, newSums);
    }
}
