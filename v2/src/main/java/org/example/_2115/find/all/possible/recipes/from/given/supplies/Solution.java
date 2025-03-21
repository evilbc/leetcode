package org.example._2115.find.all.possible.recipes.from.given.supplies;

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> missingByRecipes = new HashMap<>();
        Map<String, List<String>> missingByIngredients = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ings = ingredients.get(i);
            processRecipe(recipe, ings, supplies, result, missingByRecipes, missingByIngredients);
        }

        return result;
    }

    private void processRecipe(String recipe, List<String> ingredients, String[] supplies, List<String> result,
            Map<String, List<String>> missingByRecipes, Map<String, List<String>> missingByIngredients) {
        boolean hasAllIngredients = true;
        for (String ingredient : ingredients) {
            if (!contains(supplies, ingredient) && !result.contains(ingredient)) {
                hasAllIngredients = false;
                missingByIngredients.computeIfAbsent(ingredient, k -> new ArrayList<>())
                        .add(recipe);
                missingByRecipes.computeIfAbsent(recipe, k -> new ArrayList<>())
                        .add(ingredient);
            }
        }
        if (!hasAllIngredients)
            return;

        result.add(recipe);

        fillInMissing(result, recipe, missingByRecipes, missingByIngredients);
    }

    private void fillInMissing(List<String> result, String recipe, Map<String, List<String>> missingByRecipes,
            Map<String, List<String>> missingByIngredients) {
        for (String r : missingByIngredients.getOrDefault(recipe, Collections.emptyList())) {
            List<String> missing = missingByRecipes.get(r);
            missing.remove(recipe);
            if (missing.isEmpty()) {
                result.add(r);
                fillInMissing(result, r, missingByRecipes, missingByIngredients);
            }
        }
    }

    private boolean contains(String[] arr, String str) {
        for (String supply : arr) {
            if (supply.equals(str))
                return true;
        }
        return false;
    }
}
