package org.example._2115.find.all.possible.recipes.from.given.supplies;

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> availableSupplies = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        Map<String, Boolean> visited = new HashMap<>();

        Map<String, List<String>> recipeIngredients = new HashMap<>();
        for (int i = 0; i < ingredients.size(); i++) {
            recipeIngredients.put(recipes[i], ingredients.get(i));
        }

        for (String recipe : recipes) {
            processRecipe(recipe, recipeIngredients, availableSupplies, visited, result);
        }

        return result;
    }

    private boolean processRecipe(String recipe, Map<String, List<String>> recipeIngredients,
            Set<String> availableSupplies, Map<String, Boolean> visited, List<String> result) {
        if (visited.containsKey(recipe))
            return visited.get(recipe);

        visited.put(recipe, false);
        if (!recipeIngredients.containsKey(recipe))
            return false;

        for (String ingredient : recipeIngredients.get(recipe)) {
            if (!availableSupplies.contains(ingredient) && !processRecipe(ingredient, recipeIngredients,
                    availableSupplies, visited, result)) {
                return false;
            }
        }

        visited.put(recipe, true);
        availableSupplies.add(recipe);
        result.add(recipe);
        return true;
    }
}
