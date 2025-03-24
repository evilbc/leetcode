package org.example._408.convert.sorted.array.to.binary.search.tree;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }

    private TreeNode buildNode(int[] nums, int left, int right) {
        if (left > right || left < 0 || right >= nums.length)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildNode(nums, left, mid - 1);
        root.right = buildNode(nums, mid + 1, right);
        return root;
    }
}