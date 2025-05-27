package org.example._941.valid.mountain.array;

class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 2) return false;
        if (arr[0] >= arr[1]) return false;

        int i = 2;
        while (i < arr.length && arr[i - 1] < arr[i]) {
            i++;
        }
        if (i == arr.length || arr[i - 1] == arr[i]) return false;
        while (i < arr.length && arr[i - 1] > arr[i]) {
            i++;
        }
        return i == arr.length;
    }
}
