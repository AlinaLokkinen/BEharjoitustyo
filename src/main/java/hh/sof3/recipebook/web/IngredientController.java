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

import hh.sof3.recipebook.domain.Ingredient;
import hh.sof3.recipebook.domain.IngredientRepository;
import hh.sof3.recipebook.domain.RecipeRepository;
import jakarta.validation.Valid;

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

    @RequestMapping(value = "/editingredient/{id}", method = RequestMethod.GET) 
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editIngredient(@PathVariable("id") Long ingredientId, Model model) {

        model.addAttribute("ingredient", ingredientRepository.findById(ingredientId));
        return "editingredient"; // .html
    }

    @RequestMapping(value = "/deleteingredient/{id}", method = RequestMethod.GET) 
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteIngredient(@PathVariable("id") Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
        return "redirect:/ingredientlist"; 
    }

    @RequestMapping(value = "/addingredient", method = RequestMethod.GET)
    public String addIngredient(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "addnewingredient";
    }
    
    @RequestMapping(value = "/saveingredient", method = RequestMethod.POST)
    public String saveingredient(@Valid @ModelAttribute("ingredient") Ingredient ingredient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addnewingredient";
        } else {
            ingredientRepository.save(ingredient);
            return "redirect:/ingredientlist";
        }
    }


}
