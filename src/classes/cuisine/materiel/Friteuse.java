package classes.cuisine.materiel;

import classes.Recette;
import classes.cuisine.Ingredient;
import classes.cuisine.IngredientCuit;

public class Friteuse extends MaterielDeCuisson {

    public Friteuse() {
        super();
    }
    public boolean ajouterObjet (IngredientCuit ingredient) throws IllegalAccessException {
        if (!(ingredient.getNom().equals(Ingredient.Nom.POMME_DE_TERRE)) && ingredient.getTransformer() == false) {
            // exception
        }
        super.ajouterObjet(ingredient);
    }

}

