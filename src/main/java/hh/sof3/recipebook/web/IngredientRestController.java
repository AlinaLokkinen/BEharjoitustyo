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

import hh.sof3.recipebook.domain.Ingredient;
import hh.sof3.recipebook.domain.IngredientRepository;

@CrossOrigin
@Controller
public class IngredientRestController {

    @Autowired
    IngredientRepository ingredientRepository;

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET) 
    public @ResponseBody List<Ingredient> ingredientList() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Ingredient> findByIngredientId(@PathVariable("id") Long ingredientId) {
        return ingredientRepository.findById(ingredientId);
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.POST) 
    public @ResponseBody Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
