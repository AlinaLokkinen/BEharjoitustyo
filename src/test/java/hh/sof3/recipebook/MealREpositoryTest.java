package hh.sof3.recipebook;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof3.recipebook.domain.Meal;
import hh.sof3.recipebook.domain.MealRepository;

@SpringBootTest
public class MealREpositoryTest {

    @Autowired
    MealRepository mealRepository;

    @Test
    public void createNewIngredient() {
        Meal meal = new Meal("newMeal");
        mealRepository.save(meal);
        assertThat(meal.getMealId()).isNotNull();
    }

    // Delete an ingredient
    @Test
    public void DeleteIngredient() {
        Meal meal = mealRepository.findById(Long.valueOf(1)).get();
        mealRepository.delete(meal);
        Optional<Meal> deleteMeal = mealRepository.findById(Long.valueOf(1));
        assertThat(deleteMeal).isEmpty();
    }

}
