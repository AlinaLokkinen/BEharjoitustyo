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
import hh.sof3.recipebook.domain.RecipeRepository;

@Controller
public class IngredientController {
    
   @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;
    
    @RequestMapping(value = "/ingredientlist", method = RequestMethod.GET)
    public String ingredientList(Model model) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredients);

        return "ingredientlist"; // .html
    }

    @RequestMapping(value = "/viewingredients/{ingredient}", method = RequestMethod.GET)
    public String viewByIngredients(@PathVariable("ingredient") Ingredient ingredient, Model model) {

        model.addAttribute("recipes", recipeRepository.findByIngredient(ingredient));

        return "viewbyingredienttype"; //.html
    }
}
