package hh.sof3.recipebook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.recipebook.domain.IngredientRepository;
import hh.sof3.recipebook.domain.MealRepository;
import hh.sof3.recipebook.domain.Recipe;
import hh.sof3.recipebook.domain.RecipeRepository;
import jakarta.validation.Valid;

@Controller
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    MealRepository mealRepository;

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

    @RequestMapping(value = "/viewrecipe/{id}", method = RequestMethod.GET)
    public String viewRecipe(@PathVariable("id") Long recipeId, Model model) {
       
        model.addAttribute("recipe", recipeRepository.findByRecipeId(recipeId));

        return "viewrecipe"; //.html
    }

    
    @RequestMapping(value = "/editrecipe/{id}", method = RequestMethod.GET) 
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editRecipe(@PathVariable("id") Long recipeId, Model model) {

        model.addAttribute("recipe", recipeRepository.findById(recipeId));
        return "editrecipe"; // .html
    }

    @RequestMapping(value = "/deleterecipe/{id}", method = RequestMethod.GET) 
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteRecipe(@PathVariable("id") Long recipeId) {
        recipeRepository.deleteById(recipeId);
        return "redirect:/recipelist"; 
    }

    @RequestMapping(value = "/addrecipe", method = RequestMethod.GET)
    public String addNewRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        model.addAttribute("meals", mealRepository.findAll());
        return "addnewrecipe";
    }
    
    @RequestMapping(value = "/saverecipe", method = RequestMethod.POST)
    public String saveRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addnewrecipe";
        } else {
            recipeRepository.save(recipe);
            return "redirect:/recipelist";
        }
    }
}
