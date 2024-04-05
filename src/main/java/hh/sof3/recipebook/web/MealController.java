package hh.sof3.recipebook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.recipebook.domain.Meal;
import hh.sof3.recipebook.domain.MealRepository;
import hh.sof3.recipebook.domain.Recipe;
import hh.sof3.recipebook.domain.RecipeRepository;

public class MealController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    MealRepository mealRepository;

    @RequestMapping(value = "/mealtypes", method = RequestMethod.GET)
    public String mealTypeList(Model model) {
        List<Meal> meals = (List<Meal>) mealRepository.findAll();
        model.addAttribute("meals", meals);
        return "mealtypes"; //.html
    }

    @RequestMapping(value = "/viewmeals/{meal}", method = RequestMethod.GET)
    public String viewByMealtype(@PathVariable("meal") Meal meal, Model model) {
        model.addAttribute("recipes", recipeRepository.findByMeal(meal));
        return "viewbymealtype"; // .html
    }

    @RequestMapping(value = "/editmeal/{id}", method = RequestMethod.GET) 
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editMeal(@PathVariable("id") Long mealId, Model model) {
        model.addAttribute("meal", mealRepository.findById(mealId));
        return "editmeal"; // .html
    }

    @RequestMapping(value = "/deletemeal/{id}", method = RequestMethod.GET) 
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteMeal(@PathVariable("id") Long mealId) {
        mealRepository.deleteById(mealId);
        return "redirect:/mealtypelist"; 
    }

    // @RequestMapping(value = "/addrecipe", method = RequestMethod.GET)
    // public String addNewRecipe(Model model) {
    //     model.addAttribute("recipe", new Recipe());
    //     model.addAttribute("ingredients", ingredientRepository.findAll());
    //     model.addAttribute("meals", mealRepository.findAll());
    //     return "addnewrecipe";
    // }
    
    // @RequestMapping(value = "/saverecipe", method = RequestMethod.POST)
    // public String saveRecipe(@ModelAttribute Recipe recipe) {
    //     recipeRepository.save(recipe);
    //     return "redirect:/recipelist";
    // }

}
