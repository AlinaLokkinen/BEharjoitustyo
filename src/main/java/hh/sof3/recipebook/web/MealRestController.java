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

import hh.sof3.recipebook.domain.Meal;
import hh.sof3.recipebook.domain.MealRepository;

@CrossOrigin
@Controller
public class MealRestController {

    @Autowired
    MealRepository mealRepository;

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public @ResponseBody List<Meal> mealList() {
        return (List<Meal>) mealRepository.findAll();
    }

    @RequestMapping(value = "/meals/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Meal> mealById(@PathVariable("id") Long mealId) {
        return mealRepository.findById(mealId);
    }

    @RequestMapping(value = "/meals", method = RequestMethod.POST) 
    public @ResponseBody Meal saveMeal(@RequestBody Meal meal) {
        return mealRepository.save(meal);
    }

}
