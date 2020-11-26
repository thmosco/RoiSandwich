package classes.cuisine.materiel;

import classes.Recette;
import classes.cuisine.Ingredient;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe enfant de matériel, assiette contenant des ingrédients / un plat
 * @version 1.0
 * @author Mickeal PIRRES
 */
public class Assiette extends Materiel {

    // Constructeur
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

    /**
     * Permet de transformer le contenu d'une
     * @param recette
     * @return
     * @throws IllegalAccessException
     */
    public boolean fairePlat(Recette recette) throws IllegalAccessException {
        ArrayList<Boolean> checked = new ArrayList<Boolean>() ;
        boolean check = true ;
        int quantite = 0 ;

        // Pour chaque ingrédient de la recette
        for (int i = 0 ; i < this.objetsContenus.size() ; i++) {
            // Vérifier qu'il est présent et en bonne quantité
            if (recette.ingredients.containsKey(this.objetsContenus.get(i))) {
                quantite = recette.ingredients.get(this.objetsContenus.get(i));
                if (Collections.frequency(this.objetsContenus, this.objetsContenus.get(i)) != quantite) {
                    check = false ;
                }
            } else {
                check = false ;
            }

            // Ajouter le résultat de la vérification de l'ingrédient à la liste des vérifications
            checked.add(check) ;
        }

        // Si un aliment a un résultat négatif alors la recette ne peut pas être faite
        if (checked.contains(false)) {
            return false ;
        } else {
            // Transformer les ingrédients en une recette
            this.objetsContenus.clear();
            this.ajouterObjet(recette);
            return true ;
        }
    }

}

