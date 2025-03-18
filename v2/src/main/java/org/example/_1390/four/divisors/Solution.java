package org.example._1390.four.divisors;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += divisorSum(num);
        return sum;
    }

    private int divisorSum(int num) {
        int count = 2; // 1 and itself
        int[] divisors = new int[2];
        double root = Math.floor(Math.pow(num, 0.5));
        if (root * root == num)
            return 0;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                count += 2;
                divisors[0] = i;
                divisors[1] = num / i;
            }
            if (count > 4)
                return 0;
        }
        if (count != 4)
            return 0;
        return 1 + num + divisors[0] + divisors[1];
    }
}