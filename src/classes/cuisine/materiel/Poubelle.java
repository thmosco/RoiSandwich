package classes.cuisine.materiel;

import classes.Recette;
import classes.cuisine.Ingredient;
import classes.cuisine.IngredientCuit;

/**
 * Classe enfant de matériel, contient des ingrédients cuisables
 * @version 1.0
 * @author Mickeal PIRRES
 *
 * @version 2.0
 * @author Maïa DA SILVA
 */
public class Poubelle extends Materiel {

    /**
     * Constructeur
     */
    public Poubelle() {
        super(10, 0);
    }

    // Méthodes

    /**
     * Permet de "détruire" les aliments jetés dans la poubelle
     * @return true si la poubelle a été vidée
     */
    public boolean detruire() {
        // pop up de confirmation
        // ...
        this.objetsContenus.clear();
        // si this = assiette > envoyer l'assiette à l'évier
        return true ;
    }

}
