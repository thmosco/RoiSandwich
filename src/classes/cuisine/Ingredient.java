package classes.cuisine;

public class Ingredient {

    private Nom nom;
    //private int quantite;//
    private boolean transformer;
    private Etat etat;

    public enum Etat{CRU, CUIT, BRULE}

    public enum Nom{POMME_DE_TERRE, SALADE, TOMATE, OIGNON, PAIN, FROMAGE, STEAK_DE_SOJA, STEAK_DE_POULET, STEAK_DE_BOEUF}


    public Ingredient(Nom nom, Etat etat) {

        this.nom = nom;
        this.etat = Etat.CRU;
    }
}
