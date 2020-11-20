package classes.cuisine.materiel;
import classes.Recette;
import java.util.Collections;

public class Assiette extends Materiel {

    public Assiette(int capaciteMax, int tempsExecution) {
        super(capaciteMax, tempsExecution);
    }

    public boolean fairePlat(Recette recette) throws IllegalAccessException {
        boolean checked = true ;
        int quantite = 0 ;
        for (int i = 0 ; i < this.objetsContenus.size() ; i++) {
            if (recette.ingredients.containsKey(this.objetsContenus.get(i))) {
                quantite = recette.ingredients.get(this.objetsContenus.get(i));
                if (Collections.frequency(this.objetsContenus, this.objetsContenus.get(i)) != quantite) {
                    checked = false ;
                }
            } else {
                checked = false ;
            }
        }
        if (checked) {
            this.objetsContenus.clear();
            this.ajouterObjet(recette);
            return true ;
        } else {
            return false ;
        }
    }

}

