package classes.cuisine.materiel;

import classes.cuisine.Ingredient;

public class Decoupe extends Materiel {

    public Decoupe(int capaciteMax, int tempsExecution) {
        super(capaciteMax, tempsExecution);
    }

    public void ajouterObjet (Ingredient ingredient) throws IllegalAccessException {
        super.ajouterObjet(ingredient);
    }

    public boolean couper() {
        Ingredient ingredient ;
        for (int i = 0 ; i < this.objetsContenus.size() ; i++) {
            ingredient = (Ingredient) this.objetsContenus.get(i);
            if (ingredient.isSteak()) {
                //throw exception
                return false ;
            }
            ingredient.setTransformer(true) ;
        }
        return true ;
    }

}
