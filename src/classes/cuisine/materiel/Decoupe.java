package classes.cuisine.materiel;

import classes.cuisine.Ingredient;

public class Decoupe extends Materiel {

    public Decoupe() {
        super(1, 10);
    }

    public boolean ajouterObjet (Ingredient ingredient) throws IllegalAccessException {
        if (ingredient.isSteak()) {
            return false ;
        }
        super.ajouterObjet(ingredient);
        if (super.ajouterObjet(ingredient)) {
            ingredient.setTransformer(true) ;
            return true ;
        } else {
            return false ;
        }
    }
}
