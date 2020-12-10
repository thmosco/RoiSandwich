package classes.cuisine.materiel;

import classes.Recette;
import classes.cuisine.Ingredient;

/**
 * Classe enfant de matériel, assiette contenant des ingrédients / un plat
 * @version 1.0
 * @author Mickeal PIRRES
 */
public class Assiette extends Materiel {

    private Recette.Noms nomPlat ;

    /**
     * Constructeur
     */
    public Assiette() {
        super(10, 0);
        this.nomPlat = null ;
    }

    // Getteur

    /**
     * @return le nom du plat contenu dans l'assiette
     * @return null si aucun plat n'a été créé par le joueur
     */
    public Recette.Noms getPlat() {
        return this.nomPlat ;
    }

    // Setteur

    /**
     * Permet au joueur d'indiqquer quel plat il a créé
     * @param nomRecette
     */
    public void setPlat(Recette.Noms nomRecette) {
        this.nomPlat = nomRecette ;
    }

    // Méthodes

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe Matériel
     * Permet d'ajouter un ingrédient "dans" l'assiette
     * @param ingredient
     * @return true si l'ingrédient a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Ingredient ingredient) {
        return super.ajouterObjet(ingredient) ;
    }

    /**
     * @Override méthode retirerObjet(Objet objet) de la classe Matériel
     * Permet de retirer un ingredient de l'assiette
     * @param ingredient
     * @return true si la l'ingredient a bien été retiré
     *
     * @version 1.0
     * @author Maia DA SILVA
     */
    public boolean retirerObjet(Ingredient ingredient) {
        return this.objetsContenus.remove(ingredient) ;
    }
}

