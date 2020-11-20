package classes.cuisine.materiel;
import classes.cuisine.Ingredient;
import classes.cuisine.IngredientCuit;

public class MaterielDeCuisson extends Materiel {

    public MaterielDeCuisson() {
            super(1, 10);
        }
        
    public boolean ajouterObjet (IngredientCuit ingredient) throws IllegalAccessException {
        super.ajouterObjet(ingredient);
        if (super.ajouterObjet(ingredient)) {
            startCuisson() ;
            return true ;
        } else {
            return false ;
        }
    }

    public boolean startCuisson() {
        // start timer
        return true ;
    }

    public boolean stopCuisson(double tmpsCuisson) {
        IngredientCuit ingredient ;
        for (int i = 0 ; i > this.objetsContenus.size() ; i++) {
            ingredient = (IngredientCuit) this.objetsContenus.get(i);
            if (tmpsCuisson < ingredient.getTempsCuisson()) {
                ingredient.setEtat(Ingredient.Etat.CRU);
            } else if (tmpsCuisson == ingredient.getTempsCuisson()) {
                ingredient.setEtat(Ingredient.Etat.CUIT);
            } else if (tmpsCuisson > ingredient.getTempsCuisson()) {
                ingredient.setEtat(Ingredient.Etat.BRULE);
            } else {
                return false ;
            }
        }
        return true ;
    }
}


}
