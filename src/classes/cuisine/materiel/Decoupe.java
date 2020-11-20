package classes.cuisine.materiel;

import classes.cuisine.Ingredient;

public class Decoupe extends Materiel {

    public Decoupe(int capaciteMax, int tempsExecution) {
        super(capaciteMax, tempsExecution);
    }

    public boolean couper() {
        Ingredient objet ;
        for (int i = 0 ; i < this.objetsContenus.size() ; i++) {
            if (!(this.objetsContenus.get(i) instanceof Ingredient)) {
                //throw exception
                return false ;
            }
            objet = (Ingredient) this.objetsContenus.get(i);
            if (objet.isSteak()) {
                //throw exception
                return false ;
            }
            objet.setTransformer(true) ;
        }
        return true ;
    }

}
