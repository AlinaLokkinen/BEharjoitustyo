package hh.sof3.recipebook;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.recipebook.domain.Recipe;
import hh.sof3.recipebook.domain.RecipeRepository;

import hh.sof3.recipebook.domain.Meal;

@SpringBootTest
public class RecipeRepositoryTests {

    @Autowired
    RecipeRepository recipeRepository;

    @Test
    public void createNewRecipe() {
        Recipe recipe = new Recipe("test", "testing", null, null);
        recipeRepository.save(recipe);

        assertThat(recipe.getRecipeId()).isNotNull();
    }

    

}
