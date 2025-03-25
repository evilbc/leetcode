package org.example._167.two.sum.ii.input.array.is.sorted;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[] { left + 1, right + 1 };
            if (sum > target)
                right -= 1;
            else
                left += 1;
        }
        throw new IllegalArgumentException();
    }
}
