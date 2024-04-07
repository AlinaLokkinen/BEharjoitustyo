package hh.sof3.recipebook.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;

    @NotNull
    private String name;
    
    private String description;

    @ManyToOne
    @JsonIgnoreProperties("recipes")
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;

    @ManyToOne
    @JsonIgnoreProperties("recipes")
    @JoinColumn(name = "mealId")
    private Meal meal;

    public Recipe() {
        
    }

    public Recipe(String recipeName, String description, Meal meal,  Ingredient ingredient) {
        this.name = recipeName;
        this.description = description;
        this.ingredient = ingredient;
        this.meal = meal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @Override
    public String toString() {
        return "Recipe [id=" + recipeId + ", name=" + name + ", description=" + description + ", ingredient=" + ingredient
                + ", meal=" + meal + "]";
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    

}
