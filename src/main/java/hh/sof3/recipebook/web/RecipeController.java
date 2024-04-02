package hh.sof3.recipebook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.recipebook.domain.Ingredient;
import hh.sof3.recipebook.domain.IngredientRepository;
import hh.sof3.recipebook.domain.Meal;
import hh.sof3.recipebook.domain.MealRepository;
import hh.sof3.recipebook.domain.Recipe;
import hh.sof3.recipebook.domain.RecipeRepository;

@Controller
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        
        return "index"; //.html
    }

    @RequestMapping(value = "/recipelist", method = RequestMethod.GET) 
    public String recipeList(Model model) {

        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
        model.addAttribute("recipes", recipes);

        return "recipelist"; //.html
    }

    @RequestMapping(value = "/mealtypelist", method = RequestMethod.GET)
    public String mealTypeList(Model model) {
        List<Meal> meals = (List<Meal>) mealRepository.findAll();
        model.addAttribute("meals", meals);

        return "mealtypelist"; // .html
    }

    @RequestMapping(value = "/ingredientlist", method = RequestMethod.GET)
    public String ingredientList(Model model) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredients);

        return "ingredientlist"; // .html
    }

    @RequestMapping(value = "/viewrecipe/{id}", method = RequestMethod.GET)
    public String viewRecipe(@PathVariable("id") Long recipeId, Model model) {
       
        model.addAttribute("recipe", recipeRepository.findByRecipeId(recipeId));

        return "viewrecipe"; //.html
    }
}
