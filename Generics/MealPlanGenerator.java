package Generics;

import java.util.*;

interface MealPlan {
    String getType();
}

class VegetarianMeal implements MealPlan {
    public String getType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getType() {
        return "Keto";
    }
}

class Meal<T extends MealPlan> {
    private T plan;

    Meal(T plan) {
        this.plan = plan;
    }

    String generate() {
        return "Meal Plan: " + plan.getType();
    }
}

public class MealPlanGenerator {
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        System.out.println(meal.generate());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        Meal<? extends MealPlan> meal;
        if (type.equalsIgnoreCase("vegan")) {
            meal = new Meal<>(new VeganMeal());
        } else if (type.equalsIgnoreCase("keto")) {
            meal = new Meal<>(new KetoMeal());
        } else {
            meal = new Meal<>(new VegetarianMeal());
        }
        generatePlan(meal);
        sc.close();
    }
}
