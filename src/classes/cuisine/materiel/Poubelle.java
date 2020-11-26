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
     * Permet d'ajouter le contenu d'une assiette dans la poubelle
     * @param assiette
     * @return true si le contenu d'une assiette a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Assiette assiette) throws IllegalAccessException {
        // pop up de confirmation
        // ...
        super.ajouterObjet(assiette.objetsContenus);
        // ajouter l'assiette à l'évier
        // ...
        return true ;
    }

    /**
     * Permet de "détruire" les aliments jetés dans la poubelle
     * @return true si la poubelle a été vidée
     */
    public boolean detruire() {
        this.objetsContenus.clear();
        return true ;
    }

}
