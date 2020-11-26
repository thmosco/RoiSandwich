package classes.cuisine.materiel;

import classes.cuisine.Ingredient;
import classes.cuisine.IngredientCuit;

/**
 * Classe enfant de matérielDeCuisson, contient des pommes de terre découpées
 * @version 1.0
 * @author Mickeal PIRRES
 *
 * @version 2.0
 * @author Maïa DA SILVA
 */
public class Friteuse extends MaterielDeCuisson {

    /**
     * Constructeur
     */
    public Friteuse() {
        super();
    }

    // Méthode

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe MatérielDeCuisson
     * Permet d'ajouter une patate dans la friteuse
     * @param ingredient
     * @return true si la patate a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (IngredientCuit ingredient) throws IllegalAccessException {
        if (ingredient.getNom() == Ingredient.Nom.PATATE) {
            if (ingredient.getTransformer() == false) {
                // message d'erreur : patate pas découpée
                return false ;
            }
            return super.ajouterObjet(ingredient);
        } else{
            // message d'erreur : pas une patate
            return false ;
        }
    }

}

