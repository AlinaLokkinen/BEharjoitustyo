package hh.sof3.recipebook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.recipebook.domain.Recipe;
import hh.sof3.recipebook.domain.RecipeRepository;
import hh.sof3.recipebook.domain.Ingredient;
import hh.sof3.recipebook.domain.IngredientRepository;
import hh.sof3.recipebook.domain.Meal;
import hh.sof3.recipebook.domain.MealRepository;

@SpringBootTest
public class RecipeRepositoryTests {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    // create a new recipe
    @Test
    public void createNewRecipe() {
        Recipe recipe = new Recipe("test", "testing", null, null);
        recipeRepository.save(recipe);

        assertThat(recipe.getRecipeId()).isNotNull();
    }

    // delete a recipe
    @Test
    public void DeleteRecipe() {
        Recipe recipe = recipeRepository.findById(Long.valueOf(1)).get();
        recipeRepository.delete(recipe);
        Optional<Recipe> deleteRecipe = recipeRepository.findById(Long.valueOf(1));
        assertThat(deleteRecipe).isEmpty();
    }

    // find a recipe by a meal type
    @Test
    public void findRecipeByMealType() {
        Meal meal = mealRepository.findById(Long.valueOf(1)).get();
        List<Recipe> recipes = recipeRepository.findByMeal(meal);
        assertThat(recipes).hasSizeGreaterThan(0);
    }

    // find a recipe by an ingredient
    @Test
    public void findRecipeByIngredient() {
        Ingredient ingredient = ingredientRepository.findById(Long.valueOf(1)).get();
        List<Recipe> recipes = recipeRepository.findByIngredient(ingredient);
        assertThat(recipes).hasSizeGreaterThan(0);
    }

    

}
