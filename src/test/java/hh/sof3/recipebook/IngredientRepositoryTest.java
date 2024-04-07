package hh.sof3.recipebook;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.recipebook.domain.Ingredient;
import hh.sof3.recipebook.domain.IngredientRepository;

@SpringBootTest
public class IngredientRepositoryTest {

    @Autowired
    IngredientRepository ingredientRepository;

    // Create a new ingredient
    @Test
    public void createNewIngredient() {
        Ingredient ingredient = new Ingredient("newIngredient");
        ingredientRepository.save(ingredient);
        assertThat(ingredient.getIngredientId()).isNotNull();
    }

    // Delete an ingredient
    @Test
    public void DeleteIngredient() {
        Ingredient ingredient = ingredientRepository.findById(Long.valueOf(1)).get();
        ingredientRepository.delete(ingredient);
        Optional<Ingredient> deleteIngredient = ingredientRepository.findById(Long.valueOf(1));
        assertThat(deleteIngredient).isEmpty();
    }
}

