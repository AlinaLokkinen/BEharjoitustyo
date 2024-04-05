package hh.sof3.recipebook.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    @JsonIgnoreProperties("ingredient")
    private List<Recipe> recipes;

    public Ingredient() {
        
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long id) {
        this.ingredientId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient [id=" + ingredientId + ", name=" + name + "]";
    }

    

}
