package classes;
import classes.cuisine.Ingredient;
import java.util.HashMap;

public class Recette {

    public enum NomsRecettes {
        SIMPLE, MENU, MAXI, FRITES,
    }

    public enum Viandes {
        BOEUF, POULET, VEGE
    }

    private NomsRecettes nom ;
    private Viandes viande ;
    private HashMap<Ingredient.Nom, Integer> ingredients ;

    public Recette (NomsRecettes nom, Viandes viande) {
        this.nom = nom ;
        this.viande = viande ;
        this.ingredients = new HashMap<>() ;
        switch (this.nom) {
            case FRITES:
                recetteFrites();
                break;
            case SIMPLE:
            case MAXI:
                recetteBurger(this.viande);
                break;
            case MENU:
                recetteFrites();
                recetteBurger(this.viande);

        }
    }

    private void recetteBurger (Viandes viande) {
        this.ingredients.put(Ingredient.Nom.SALADE,1) ;
        this.ingredients.put(Ingredient.Nom.TOMATE,1) ;
        this.ingredients.put(Ingredient.Nom.OIGNON,1) ;
        this.ingredients.put(Ingredient.Nom.PAIN,1) ;
        this.ingredients.put(Ingredient.Nom.FROMAGE,1) ;
        int nbSteaks = 0 ;
        Ingredient.Nom typeSteak ;
        if (viande == Viandes.BOEUF) {
            typeSteak = Ingredient.Nom.STEAK_DE_BOEUF ;
        } else if (this.viande == Viandes.POULET) {
            typeSteak = Ingredient.Nom.STEAK_DE_POULET ;
        } else {
            typeSteak = Ingredient.Nom.STEAK_DE_SOJA ;
        }
        switch (this.nom) {
            case SIMPLE:
                this.ingredients.put(typeSteak,1) ;
                break;
            case MAXI :
                this.ingredients.put(typeSteak,2) ;
        }
    }

    private void recetteFrites () {
        this.ingredients.put(Ingredient.Nom.POMME_DE_TERRE,1) ;
    }
}
