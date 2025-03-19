package org.example._733.flood.fill;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        floodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (image[sr][sc] != oldColor)
            return;

        image[sr][sc] = newColor;

        if (sr > 0)
            floodFill(image, sr - 1, sc, newColor, oldColor);
        if (sr + 1 < image.length)
            floodFill(image, sr + 1, sc, newColor, oldColor);

        if (sc > 0)
            floodFill(image, sr, sc - 1, newColor, oldColor);
        if (sc + 1 < image[sr].length)
            floodFill(image, sr, sc + 1, newColor, oldColor);
    }
}
