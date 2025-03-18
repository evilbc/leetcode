package org.example._653.two.sum.iv.input.is.a.bst;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> targets = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        if (targets.contains(root.val))
            return true;

        targets.add(k - root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}