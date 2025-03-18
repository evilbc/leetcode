package org.example._15._3sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            twoSum(nums, i, result);
        }
        return result;
    }

    private void twoSum(int[] numbers, int index, List<List<Integer>> result) {
        int left = index + 1;
        int right = numbers.length - 1;
        int target = -numbers[index];
        while (left < right) {
            while (!isLeftmostDuplicate(numbers, index, left, right))
                left++;
            while (!isRightmostDuplicate(numbers, index, left, right))
                right--;
            if (left == right)
                return;

            int sum = numbers[left] + numbers[right];
            if (sum == target)
                result.add(Arrays.asList(numbers[index], numbers[left++], numbers[right--]));
            else if (sum > target)
                right--;
            else
                left++;
        }
    }

    private boolean isLeftmostDuplicate(int[] numbers, int index, int left, int right) {
        return !(left < right && left != index + 1 && numbers[left] == numbers[left - 1]);
    }

    private boolean isRightmostDuplicate(int[] numbers, int index, int left, int right) {
        return !(left < right && right != numbers.length - 1 && numbers[right] == numbers[right + 1]);
    }
}