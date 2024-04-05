package hh.sof3.recipebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.recipebook.domain.Ingredient;
import hh.sof3.recipebook.domain.IngredientRepository;
import hh.sof3.recipebook.domain.Meal;
import hh.sof3.recipebook.domain.MealRepository;
import hh.sof3.recipebook.domain.Recipe;
import hh.sof3.recipebook.domain.RecipeRepository;
import hh.sof3.recipebook.domain.User;
import hh.sof3.recipebook.domain.UserRepository;

@SpringBootApplication
public class RecipebookApplication {
	private static final Logger log = LoggerFactory.getLogger(RecipebookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecipebookApplication.class, args);
	}

	@Bean
	public CommandLineRunner recipeBook(RecipeRepository recipeRepository, MealRepository mealRepository, IngredientRepository ingredientRepository, UserRepository userRepository) {

		return (args) -> {

			log.info("creating main ingredients and saving to db");
			Ingredient tofu = new Ingredient("Tofu");
			Ingredient lentils = new Ingredient("Lentils");
			Ingredient pulledOats = new Ingredient("Pulled oats");
			Ingredient soy = new Ingredient("Soy products");

			ingredientRepository.save(tofu);
			ingredientRepository.save(lentils);
			ingredientRepository.save(pulledOats);
			ingredientRepository.save(soy);

			log.info("creating meal types");
			Meal breakfast = new Meal("Breakfast");
			Meal lunch = new Meal("Lunch");
			Meal dinner = new Meal("Dinner");
			Meal dessert = new Meal("Dessert");

			mealRepository.save(breakfast);
			mealRepository.save(lunch);
			mealRepository.save(dinner);
			mealRepository.save(dessert);


			log.info("Creating recipes and adding them to database");

			Recipe r1 = new Recipe("Sesame Tofu", "Dice or tear tofu and dry it well. Cut up veggies. Add the sauce ingredients into a bowl and mix. Fry tofu until crispy and add sauce to pan, cook for a few minutes. Serve with rice.", lunch, tofu);

			Recipe r2 = new Recipe("Airfryer tofu", "Press tofu to remove excess water, then cut into cubes. Toss with your favorite seasonings (like soy sauce, garlic powder, and paprika). Airfry until crispy, shaking the basket halfway through.", lunch, tofu);

			Recipe r3 = new Recipe("Lentil curry", "Fry onions, garlic, and ginger until fragrant. Add curry powder, cumin, and coriander. Stir in cooked lentils, coconut milk, and diced tomatoes. Simmer until flavors meld together. Serve with rice.", dinner, lentils);

			Recipe r4 = new Recipe("Lentil Salad", "Cook lentils until tender, then let them cool. Add chopped vegetables. Dress with olive oil, lemon juice, salt, and pepper.", lunch, lentils);

			Recipe r5 = new Recipe("Pulled oat tacos", "Fry pulled oats with taco seasoning until heated through. Warm taco shells or tortillas. Fill with pulled oats, and top with your favorite taco toppings like lettuce, salsa, and avocado.", dinner, pulledOats);

			Recipe r6 = new Recipe("Soy bolognese", "Fry vegetables until softened. Add soy protein. Stir in tomato sauce, a splash of soy sauce, and Italian herbs. Serve with pasta.", dinner, soy);

			Recipe r7 = new Recipe("Tofu chocolate mousse", "Blend silken tofu, cocoa powder, and a sweetener like maple syrup or dates until smooth. Chill in the fridge for a couple of hours before serving. Optional: top with whipped coconut cream or shaved chocolate.", dessert, tofu);

			Recipe r8 = new Recipe("Tofu scramble", "Crumble tofu into small pieces and mash with a potato masher. Cook in a pan with oil, stirring frequently.", breakfast, tofu);

			recipeRepository.save(r1);
			recipeRepository.save(r2);
			recipeRepository.save(r3);
			recipeRepository.save(r4);
			recipeRepository.save(r5);
			recipeRepository.save(r6);
			recipeRepository.save(r7);
			recipeRepository.save(r8);

			for (Recipe r : recipeRepository.findAll()) {
				log.info(r.toString());
			}

			// somepassword
			User u1 = new User("user", "$2a$10$1Di02.wMXe/DADxrDKw0COEYi.CVLLTWSo22ZXRkq4Nz0BOItireC", "USER");
			
			// anotherpassword
			User u2 = new User("admin", "$2a$10$aEQF1v54/SDvZHwHQcPWqO9k1oNARBAq3uHNITW2PvWSbHklIcQZ.", "ADMIN");

			userRepository.save(u1);
			userRepository.save(u2);

			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}

		};
	}
}