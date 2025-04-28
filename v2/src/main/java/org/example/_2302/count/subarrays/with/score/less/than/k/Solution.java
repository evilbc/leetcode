package org.example._2302.count.subarrays.with.score.less.than.k;

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result = 0;
        long sum = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (score(sum, left, right) >= k) {
                sum -= nums[left];
                left++;
            }
            result += countSubarraysInRange(left, right);
            right++;
        }

        return result;
    }

    private long score(long sum, int left, int right) {
        return sum * (right - left + 1);
    }

    private int countSubarraysInRange(int left, int right) {
        return right - left + 1;
    }
}
