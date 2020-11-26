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

    public Poubelle(int capaciteMax, int tempsExecution) {
        super(10, 0);
    }

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe Matériel
     * Permet d'ajouter un ingrédient dans la poubelle
     * @param ingredient
     * @return true si l'ingrédient a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Ingredient ingredient) throws IllegalAccessException {
        if (!(ingredient instanceof IngredientCuit)) {
            // message d'erreur : pas un ingredient cuisable > pas utile de le jeter
            return false ;
        } else if (ingredient.getEtat() != Ingredient.Etat.BRULE) {
            // message d'erreur : ingredient pas brulé
            return false ;
        }
        return super.ajouterObjet(ingredient);
    }

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe Matériel
     * Permet d'ajouter une recette dans la poubelle
     * @param recette
     * @return true si la recette a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Assiette assiette) throws IllegalAccessException {
        // pop up de confirmation
        return super.ajouterObjet(assiette.objetsContenus);
    }

    public boolean detruire() {
        this.objetsContenus.clear();
    }

}
