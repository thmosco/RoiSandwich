package classes;
import classes.cuisine.Ingredient;
import java.util.HashMap;

/**
 * Commentaire de documentation de la classe
 * @version 1.0
 * @author Maïa DA SILVA
 */
public class Recette {

    // Variables de classe

    // Enumération des recettes disponibles
    public enum NomsRecettes {
        SIMPLE, MENU, MAXI, FRITES,
    }

    // Enumération des différents types de steaks disponibles
    public enum Steaks {
        BOEUF, POULET, VEGE
    }

    // Nom de la recette
    private NomsRecettes nom;

    // Steak choisit
    private Steaks viande;

    // Liste des ingrédients et de leur quantité nécéssaire à la recette
    public HashMap<Ingredient, Integer> ingredients;

    /**
     * Constructeur
     *
     * @param nom
     * @param viande
     */
    public Recette(NomsRecettes nom, Steaks viande) {
        this.nom = nom;
        this.viande = viande;
        this.ingredients = new HashMap<>();
        switch (this.nom) {
            case FRITES:
                this.ingredients.put(new Ingredient(Ingredient.Nom.PATATE), 1);
                break;
            case MAXI:
                recetteBurger(2, this.viande);
                break;
            case MENU:
                this.ingredients.put(new Ingredient(Ingredient.Nom.PATATE), 1);
            case SIMPLE:
                recetteBurger(1, this.viande);
        }
    }

    public NomsRecettes getNom() {
        return nom;
    }

    /**
     * Permet d'obtenir la liste des ingrédient pour la réalisation d'un burger
     *
     * @param nbSteak
     * @param viande
     */
    private void recetteBurger(int nbSteak, Steaks viande) {
        this.ingredients.put(new Ingredient(Ingredient.Nom.SALADE), 1);
        this.ingredients.put(new Ingredient(Ingredient.Nom.TOMATE), 1);
        this.ingredients.put(new Ingredient(Ingredient.Nom.OIGNON), 1);
        this.ingredients.put(new Ingredient(Ingredient.Nom.PAIN), 1);
        this.ingredients.put(new Ingredient(Ingredient.Nom.FROMAGE), 1);
        Ingredient.Nom typeSteak;
        if (viande == Steaks.BOEUF) {
            typeSteak = Ingredient.Nom.STEAK_DE_BOEUF;
        } else if (this.viande == Steaks.POULET) {
            typeSteak = Ingredient.Nom.STEAK_DE_POULET;
        } else {
            typeSteak = Ingredient.Nom.STEAK_DE_SOJA;
        }
        this.ingredients.put(new Ingredient(typeSteak), nbSteak);
    }
}