package classes.cuisine.materiel;

import classes.Recette;
import classes.cuisine.Ingredient;

public class Evier extends Materiel {

    public Evier(int capaciteMax, int tempsExecution) {
        super(capaciteMax, tempsExecution);
    }

    public void ajouterObjet (Assiette assiette) throws IllegalAccessException {
        super.ajouterObjet(assiette);
    }

    public boolean nettoyage() {
        Assiette assiette ;
        for (int i = 0 ; i < this.objetsContenus.size() ; i++) {
            assiette = (Assiette) this.objetsContenus.get(i);
            if (assiette.objetsContenus.get(0) instanceof Recette) {
                // envoyer message de confirmation au jouer
                // > proposer de stocker le plat
            }
            assiette.objetsContenus.clear();
        }
        return true ;
    }
}