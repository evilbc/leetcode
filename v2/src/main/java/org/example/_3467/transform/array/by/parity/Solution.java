package org.example._3467.transform.array.by.parity;

class Solution {
    public int[] transformArray(int[] nums) {
        int even = 0;
        for (int num : nums) {
            if (num % 2 == 0) even++;
        }
        int[] arr = new int[nums.length];
        for (int i = even; i < nums.length; i++) {
            arr[i] = 1;
        }
        return arr;
    }
}