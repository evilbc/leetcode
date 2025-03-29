package org.example._605.can.place.flowers;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && canPlace(flowerbed, i)) {
                flowerbed[i] = 1;
                if (--n == 0)
                    return true;
            }
        }
        return false;
    }

    private boolean canPlace(int[] flowerbed, int index) {
        return (index == 0 || flowerbed[index - 1] == 0) && (index == flowerbed.length - 1
                || flowerbed[index + 1] == 0);
    }
}
