package classes.cuisine.materiel;

import classes.Recette;
import classes.cuisine.Ingredient;

/**
 * Classe enfant de matériel, assiette contenant des ingrédients / un plat
 * @version 1.0
 * @author Mickeal PIRRES
 */
public class Assiette extends Materiel {

    /**
     * Constructeur
     */
    public Assiette() {
        super(10, 0);
    }

    // Méthodes

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe Matériel
     * Permet d'ajouter un ingrédient "dans" l'assiette
     * @param ingredient
     * @return true si l'ingrédient a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Ingredient ingredient) throws IllegalAccessException {
        return super.ajouterObjet(ingredient) ;
    }

}

