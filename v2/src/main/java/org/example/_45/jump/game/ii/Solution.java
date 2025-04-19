package org.example._45.jump.game.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int jump(int[] nums) {
        int near = 0;
        int far = 0;
        int howMany = 0;

        while (far < nums.length - 1) {
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            near = far + 1;
            far = farthest;
            howMany++;
        }

        return howMany;
    }
}
