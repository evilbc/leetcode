package org.example._3024.type.of.triangle;

class Solution {
    public String triangleType(int[] nums) {
        if (!canFormTriangle(nums)) return "none";
        int equalSides = howManyEqualSides(nums);
        if (equalSides == 3) return "equilateral";
        if (equalSides == 2) return "isosceles";
        return "scalene";
    }

    private boolean canFormTriangle(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        return a + b > c && a + c > b && b + c > a;
    }

    private int howManyEqualSides(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a == b && b == c) return 3;
        if (a == b || a == c || b == c) return 2;
        return 1;
    }
}
