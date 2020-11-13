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
            case MAXI:
                recetteBurger(2, this.viande);
                break;
            case MENU:
                recetteFrites();
            case SIMPLE:
                recetteBurger(1, this.viande);
        }
    }

    private void recetteBurger (int nbSteak, Viandes viande) {
        this.ingredients.put(Ingredient.Nom.SALADE,1) ;
        this.ingredients.put(Ingredient.Nom.TOMATE,1) ;
        this.ingredients.put(Ingredient.Nom.OIGNON,1) ;
        this.ingredients.put(Ingredient.Nom.PAIN,1) ;
        this.ingredients.put(Ingredient.Nom.FROMAGE,1) ;
        Ingredient.Nom typeSteak ;
        if (viande == Viandes.BOEUF) {
            typeSteak = Ingredient.Nom.STEAK_DE_BOEUF ;
        } else if (this.viande == Viandes.POULET) {
            typeSteak = Ingredient.Nom.STEAK_DE_POULET ;
        } else {
            typeSteak = Ingredient.Nom.STEAK_DE_SOJA ;
        }
        this.ingredients.put(typeSteak,nbSteak) ;
    }

    private void recetteFrites () {
        this.ingredients.put(Ingredient.Nom.POMME_DE_TERRE,1) ;
    }
}
