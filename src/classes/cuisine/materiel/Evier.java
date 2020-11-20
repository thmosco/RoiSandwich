package classes.cuisine.materiel;

import classes.Recette;
import classes.cuisine.Ingredient;

public class Evier extends Materiel {

    public Evier() {
        super(2, 10);
    }

    public boolean ajouterObjet (Assiette assiette) throws IllegalAccessException {
        if (assiette.objetsContenus.get(0) instanceof Recette) {
            // envoyer message de confirmation au jouer
            // > proposer de stocker le plat
            return false ;
        }
        super.ajouterObjet(assiette);
        if (super.ajouterObjet(assiette)) {
            assiette.objetsContenus.clear();
            return true ;
        } else {
            return false ;
        }
    }
}