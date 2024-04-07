package hh.sof3.recipebook.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof3.recipebook.domain.Recipe;
import hh.sof3.recipebook.domain.RecipeRepository;

@CrossOrigin
@Controller
public class RecipeRestController {

    @Autowired
    RecipeRepository recipeRepository;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public @ResponseBody List<Recipe> recipeList() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Recipe> findRecipeById(@PathVariable("id") Long recipeId) {
        return recipeRepository.findById(recipeId);
    }
    
    @RequestMapping(value = "/recipes", method = RequestMethod.POST) 
    public @ResponseBody Recipe saveRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
