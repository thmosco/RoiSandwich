package classes.cuisine.materiel;

import classes.cuisine.Ingredient;

/**
 * Classe enfant de matériel, station de découpe pour les ingrédients découpables uniquement
 * @version 1.0
 * @author Mickeal PIRRES
 *
 * @version 2.0
 * @author Maïa DA SILVA
 */
public class Decoupe extends Materiel {

    /**
     * Constructeur
     */
    public Decoupe() {
        super(1, 10);
    }

    // Méthodes

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe Matériel
     * Permet d'ajouter un ingrédient sur la station de découpe
     * @param ingredient
     * @return true si l'ingrédient a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Ingredient ingredient) throws IllegalAccessException {
        if (ingredient.isSteak()) {
            return false ;
        }
        return super.ajouterObjet(ingredient);
    }

    /**
     * @return true si l'ingrédient a bien été découpé
     */
    public boolean decouper () {
        Ingredient ingredient = (Ingredient) this.objetsContenus.get(0);
        ingredient.setTransformer(true) ;
        return true ;
    }
}
