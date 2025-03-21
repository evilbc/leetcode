package org.example._2115.find.all.possible.recipes.from.given.supplies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        new Solution().findAllRecipes(new String[] { "r1", "r2", "r3", "r4", "r5", "r6", "r7" },
                List.of(List.of("i4"), List.of("i2", "i1", "i3"), List.of("i3", "r5", "r6", "r4", "r2", "r1"),
                        List.of("i3", "i2", "r5", "r1", "r6"), List.of("r6", "r2", "r4", "r7", "r3"),
                        List.of("i4", "i2", "i3", "r7", "r5", "r1", "r4", "r3"), List.of("i1", "i2", "i3")),
                new String[] { "i1", "i2", "i3", "i4" });
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> missing = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ing = ingredients.get(i);
            boolean containsAll = true;
            boolean missingOnlyRecipe = true;
            for (String ingredient : ing) {
                if (!contains(supplies, ingredient)) {
                    containsAll = false;
                    if (!contains(recipes, ingredient))
                        missingOnlyRecipe = false;
                    else
                        missing.computeIfAbsent(recipe, k -> new ArrayList<>())
                                .add(ingredient);
                }
            }
            if (containsAll)
                result.add(recipe);
            if (!missingOnlyRecipe)
                missing.remove(recipe);
        }

        List<String> toRemove = new ArrayList<>();
        int prevSize;
        do {
            prevSize = result.size();
            for (Map.Entry<String, List<String>> entry : missing.entrySet()) {
                if (allRecipesKnown(entry.getValue(), result)) {
                    result.add(entry.getKey());
                    toRemove.add(entry.getKey());
                }
            }

            for (String s : toRemove)
                missing.remove(s);

            toRemove.clear();

        } while (prevSize != result.size());

        return result;
    }

    private boolean allRecipesKnown(List<String> ingredients, List<String> recipes) {
        for (String ingredient : ingredients) {
            if (!recipes.contains(ingredient))
                return false;
        }
        return true;
    }

    private boolean contains(String[] arr, String str) {
        for (String supply : arr) {
            if (supply.equals(str))
                return true;
        }
        return false;
    }
}
