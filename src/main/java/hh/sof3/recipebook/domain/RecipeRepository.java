package hh.sof3.recipebook.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findByRecipeId(Long recipeId);
    List<Recipe> findByMeal(Meal meal);    
    List<Recipe> findByIngredient(Ingredient ingredient);
}
