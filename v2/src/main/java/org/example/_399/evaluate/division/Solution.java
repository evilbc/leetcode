package org.example._399.evaluate.division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    private static final double UNKNOWN = -1.0d;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            map.computeIfAbsent(equation.get(0), k -> new HashMap<>())
                    .put(equation.get(1), value);
            map.computeIfAbsent(equation.get(1), k -> new HashMap<>())
                    .put(equation.get(0), 1 / value);
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Double result = dfs(query.get(0), query.get(1), map, new HashSet<>());
            results[i] = result == null ? UNKNOWN : result;
        }
        return results;
    }

    private Double dfs(String dividend, String divisor, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (!map.containsKey(dividend) || visited.contains(dividend))
            return null;
        Map<String, Double> dividendMap = map.get(dividend);
        if (dividendMap.containsKey(divisor))
            return dividendMap.get(divisor);
        visited.add(dividend);

        for (Map.Entry<String, Double> entry : dividendMap.entrySet()) {
            Double result = dfs(entry.getKey(), divisor, map, visited);
            if (result != null)
                return result * entry.getValue();
        }

        return null;
    }
}
