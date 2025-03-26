package org.example._724.find.pivot.index;

class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        while (pivot < nums.length) {
            rightSum -= nums[pivot];
            if (pivot > 0)
                leftSum += nums[pivot - 1];
            if (leftSum == rightSum)
                return pivot;
            pivot++;
        }

        return -1;
    }
}
