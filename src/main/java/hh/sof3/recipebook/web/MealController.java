package hh.sof3.recipebook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.recipebook.domain.Meal;
import hh.sof3.recipebook.domain.MealRepository;
import hh.sof3.recipebook.domain.RecipeRepository;

public class MealController {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    MealRepository mealRepository;

    @RequestMapping(value = "/mealtypelist", method = RequestMethod.GET)
    public String mealTypeList(Model model) {
        List<Meal> meals = (List<Meal>) mealRepository.findAll();
        model.addAttribute("meals", meals);

        return "mealtypelist"; // .html
    }

    @RequestMapping(value = "/viewmeals/{meal}", method = RequestMethod.GET)
    public String viewByMealtype(@PathVariable("meal") Meal meal, Model model) {
        model.addAttribute("recipes", recipeRepository.findByMeal(meal));

        return "viewbymealtype"; // .html
    }

}
