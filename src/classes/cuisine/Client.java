package classes.cuisine;

import classes.Recette;
import classes.cuisine.materiel.Assiette;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe repésentant un client
 * @version 1.0
 * @author Maïa DA SILVA
 */
public class Client {

    // Variables de classes

    /**
     * représente le temps que le client est prêt à attendre pour être servit
     */
    private int tmpsAttente ;
    /**
     * représente la commande du client
     */
    private Recette commande ;

    /**
     * Constructeur
     * @param tmpsAttente
     * @param commande
     */
    public Client(int tmpsAttente, Recette commande) {
        this.tmpsAttente = tmpsAttente;
        this.commande = commande;
    }

    // Getteur

    public int getTmpsAttente() {
        return tmpsAttente;
    }

    // Méthodes

    /**
     * Permet de vérifier que l'assiette qu'on lui a servit correspond à sa commande
     * @param assiette
     * @return true si la commande est bonne
     * @throws IllegalAccessException
     */
    public boolean verifierPlat(Assiette assiette) throws IllegalAccessException {
        // vérifier que le nom du plat servit est le bon
        if (verifierNomRecette(assiette)) {
            ArrayList<Boolean> checked = new ArrayList<Boolean>() ;
            boolean check = true ;
            int quantite = 0 ;

            // Récupération des ingrédient de la recette
            Set<Ingredient> listeIngredient = this.commande.ingredients.keySet() ;
            Iterator iterator = listeIngredient.iterator() ;

            // Pour chaque ingrédient de la recette
            while (iterator.hasNext()) {
                // Vérifier qu'il est présent dans l'assiette
                if (assiette.objetsContenus.contains(iterator.next())) {
                    Ingredient ingredient = (Ingredient) iterator.next();
                    // Vérifier qu'il est présent en bonne quantité dans l'assiette
                    quantite = this.commande.ingredients.get(iterator.next());
                    check = verifierQuantite(assiette.objetsContenus,ingredient,quantite) ;
                    // S'il s'agit d'un steak ou d'une patate : vérifier la cuisson
                    check = verifierCuisson(ingredient) ;
                    // S'il s'agit d'un ingrédient découpable : vérifier qu'il est découpé
                    check = verifierDecoupage(ingredient) ;
                } else {
                    check = false ;
                }
                // Ajouter le résultat de la vérification de l'ingrédient à la liste des vérifications
                checked.add(check) ;
            }

            // Si un aliment a un résultat négatif alors la commande n'a pas été respectée
            return !(checked.contains(false)) ;
        }
        return false ;
    }

    /**
     * Permet de vérifié que le nom plat annoncé lors du service correspond à la commande
     * @param assiette
     * @return true si le nom du plat de l'assiette correspond au nom du plat commandé
     */
    public boolean verifierNomRecette (Assiette assiette) {
        return assiette.getPlat() == this.commande.getNom() ;
    }

    /**
     * Permet de vérifier qu'un ingrédient est présent en bonne quantité dans l'assiette
     * @param listeIngredients
     * @param ingredient
     * @param quantite
     * @return true si l'ingrédient est présent en bonne quantité dans l'assiette
     */
    public boolean verifierQuantite(ArrayList listeIngredients, Ingredient ingredient, int quantite) {
        return (Collections.frequency(listeIngredients, ingredient) != quantite) ;
    }

    /**
     * Permet de vérifier la cuisson d'un ingrédient (cuisable)
     * @param ingredient
     * @return true si l'ingrédient est bien cuit
     */
    public boolean verifierCuisson(Ingredient ingredient) {
        return ((ingredient.isSteak() || ingredient.getNom() == Ingredient.Nom.PATATE) &&
                ingredient.getEtat() != Ingredient.Etat.CUIT) ;
    }

    /**
     * Permet de vérifier si un ingrédient est découpé ou non
     * @param ingredient
     * @return true si l'ingrédient est découpé
     */
    public boolean verifierDecoupage(Ingredient ingredient) {
        return (ingredient.isDecoupable() && ingredient.getTransformer() == false) ;
    }

}
