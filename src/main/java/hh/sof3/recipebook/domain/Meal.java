package hh.sof3.recipebook.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;

    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meal")
    @JsonIgnoreProperties("meal")
    private List<Recipe> recipes;

    public Meal() {

    }

    public Meal(String name) {
        this.name = name;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long id) {
        this.mealId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Meal [id=" + mealId + ", name=" + name + "]";
    }

    
}

