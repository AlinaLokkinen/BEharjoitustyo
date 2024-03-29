package hh.sof3.recipebook.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mealId;
    private String name;

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

