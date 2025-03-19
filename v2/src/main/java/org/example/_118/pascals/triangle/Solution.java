package org.example._118.pascals.triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                List<Integer> lastRow = triangle.get(i - 1);
                int number = 0;
                if (j > 0)
                    number += lastRow.get(j - 1);
                if (j < i)
                    number += lastRow.get(j);
                row.add(number);
            }
            triangle.add(row);
        }
        return triangle;
    }
}
