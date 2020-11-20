package classes.cuisine.materiel;

import classes.cuisine.Ingredient;
import classes.cuisine.IngredientCuit;

public class PlaqueCuisson extends MaterielDeCuisson {

    public PlaqueCuisson() {
        super();
    }

    public boolean ajouterObjet (IngredientCuit ingredient) throws IllegalAccessException {
        if (ingredient.isSteak() == false) {
            // exception
        }
        super.ajouterObjet(ingredient);
    }
}