package classes.cuisine.materiel;

import classes.cuisine.IngredientCuit;

/**
 * Classe enfant de matérielDeCuisson, contient des steaks
 * @version 1.0
 * @author Mickeal PIRRES
 *
 * @version 2.0
 * @author Maïa DA SILVA
 */
public class PlaqueCuisson extends MaterielDeCuisson {

    /**
     * Constructeur
     */
    public PlaqueCuisson() {
        super();
    }

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe MatérielDeCuisson
     * Permet d'ajouter un steak sur la plaque de cuisson
     * @param ingredient
     * @return true si le steak a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (IngredientCuit ingredient) throws IllegalAccessException {
        if (!ingredient.isSteak()) {
            return false ;
        }
        return super.ajouterObjet(ingredient);
    }
}