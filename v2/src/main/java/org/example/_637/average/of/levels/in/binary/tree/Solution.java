package org.example._637.average.of.levels.in.binary.tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<double[]> list = new ArrayList<>();
        traverse(root, 1, list);
        List<Double> result = new ArrayList<>();
        for (double[] values : list) {
            result.add(values[0] / values[1]);
        }
        return result;
    }

    private void traverse(TreeNode node, int level, List<double[]> list) { // list[0] sum, list[1] coount
        if (node == null)
            return;
        if (list.size() < level)
            list.add(new double[] { 0d, 0d });

        double[] values = list.get(level - 1);
        values[0] += node.val;
        values[1]++;
        traverse(node.left, level + 1, list);
        traverse(node.right, level + 1, list);
    }
}
