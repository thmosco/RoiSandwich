package classes;
import classes.cuisine.* ;
import classes.cuisine.materiel.Materiel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Commentaire de documentation de la classe
 * @version 1.0
 * @author Maïa DA SILVA
 */
public class Niveau {

    // Variables de classe

    /**
     * Numéro du niveau
     */
    private int numNiveau ;
    /**
     * Tableau permettant de stocker le score et l'argent obtenus à l'issu du niveau
     */
    private int[] tabScoreArgent ;
    /**
     * Tableau des clients qui apparaitront au cours de la partie
     */
    private Client [] clients ;
    /**
     * Liste des recettes disponibles dans le niveau
     */
    private ArrayList<Recette.NomsRecettes> listeRecettes ;
    /**
     * Liste du matériel et leur nombre disponible dans le niveau
     */
    private HashMap<Materiel,Integer> materiel ;
    /**
     * Liste des ingrédients et leur quantité disponibles dans le niveau
     */
    private HashMap<Ingredient,Integer> ingredient ;
    /**
     * Nombre d'assiettes maximale mise à disposition du joueur dans le niveau
     */
    private int nbAssietteMax ;

    /**
     * Constructeur
     * @param numNiveau
     */
    public Niveau(int numNiveau) {
        this.numNiveau = numNiveau;
        this.tabScoreArgent = new int [2];

        switch (this.numNiveau) {
            case 1 :
                this.nbAssietteMax = -1 ;
                this.clients = new Client[25] ;

                this.ingredient = null ;

                this.materiel = new HashMap<Materiel,Integer>() ;
                /*
                this.materiel.put(new Evier(),1) ;
                this.materiel.put(new Decoupe(),1) ;
                this.materiel.put(new PlaqueCuisson(),1) ;
                this.materiel.put(new Poubelle(),1) ;
                 */

                break ;

            case 2 :
                this.nbAssietteMax = 9 ;
                this.clients = new Client[50] ;

                this.ingredient = null ;

                this.materiel = new HashMap<Materiel,Integer>() ;
                /*
                this.materiel.put(new Evier(),1) ;
                this.materiel.put(new Decoupe(),1) ;
                this.materiel.put(new PlaqueCuisson(),1) ;
                this.materiel.put(new Poubelle(),1) ;
                 */

                break ;

            case 3 :
                this.nbAssietteMax = 6 ;
                this.clients = new Client[75] ;

                this.ingredient = null ;

                this.materiel = new HashMap<Materiel,Integer>() ;
                /*
                this.materiel.put(new Evier(),1) ;
                this.materiel.put(new Decoupe(),1) ;
                this.materiel.put(new PlaqueCuisson(),1) ;
                this.materiel.put(new Poubelle(),1) ;
                 */
        }
    }

    /**
     * Permet de remplir le tableau de client avec des clients et leur commande
     */
    public void creerClients () {
        for (int i = 0 ; i < this.clients.length ; i++) {
            for (int j = 0 ; i < this.listeRecettes.size() ; j++) {
                this.clients[i] = new Client () ;
            }
        }
    }

    /**
     * Permet de stocker le score et l'argent obtenus dans le tableau à la fin de la partie
     * @param score
     * @param argent
     */
    public void setScoreArgent (int score, int argent) {
        this.tabScoreArgent[1] = score ;
        this.tabScoreArgent[2] = argent ;
    }

    /**
     * @return liste du matériel et quantité disponible dans le niveau
     */
    public HashMap<Materiel, Integer> getMateriel() {
        return materiel;
    }

    /**
     * @return liste des ingrédient et quantité disponibles dans le niveau
     */
    public HashMap<Ingredient, Integer> getIngredient() {
        return ingredient;
    }

    /**
     * @return nombre d'assiettes max disponbles dans le niveau
     */
    public int getNbAssietteMax() {
        return nbAssietteMax;
    }
}
