package hh.sof3.recipebook;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.recipebook.web.IngredientController;
import hh.sof3.recipebook.web.MealController;
import hh.sof3.recipebook.web.RecipeController;

@SpringBootTest
class RecipebookApplicationTests {

	@Autowired
	RecipeController recipeController;

	@Autowired
	IngredientController ingredientController;

	@Autowired
	MealController mealController;

	@Test
	void recipeContollerNotNull() {
		assertThat(recipeController).isNotNull();
	}

	@Test
	void ingredientContollerNotNull() {
		assertThat(ingredientController).isNotNull();
	}

	@Test
	void mealContollerNotNull() {
		assertThat(mealController).isNotNull();
	}

}
