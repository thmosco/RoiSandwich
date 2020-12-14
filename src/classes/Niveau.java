package classes;

import classes.cuisine.*;
import classes.cuisine.materiel.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Commentaire de documentation de la classe
 * 
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
     * Score minimum nécessaire pour débloqué le niveau
     */
    private int scoreMin ;
    /**
     * Tableau permettant de stocker le score et l'argent obtenus à l'issu du niveau
     */
    private int[] tabScoreArgent ;
    /**
     * Liste des clients qui apparaitront au cours de la partie
     */
    private ArrayList<Client> clients ;
    /**
     * Nombre maximum de clients qui apparaitront au cours de la partie
     */
    private int nbMaxClients ;
    /**
     * Tableau des clients qui apparaitront au cours de la partie
     */
    private int [] tmpsAttente ;
    /**
     * Liste des recettes disponibles dans le niveau
     */
    private ArrayList<Recette.Noms> listeRecettes ;
    /**
     * Liste du matériel et leur nombre disponible dans le niveau
     */
    private HashMap<Materiel,Integer> materiel ;
    /**
     * Liste des ingrédients et leur quantité disponibles dans le niveau
     */
    private int nbIngredient ;
    /**
     * Nombre d'assiettes maximale mise à disposition du joueur dans le niveau
     */
    private int nbAssietteMax ;


	private Comptoir comptoir;
	private GardeManger gardeManger;
	private Cuisine cuisine;
	private Stock stock;



	/**
	 * Constructeur
	 * 
	 * @param numNiveau
	 */
	public Niveau(int numNiveau) {
		this.numNiveau = numNiveau;
		this.tabScoreArgent = new int[2];

        this.comptoir = new Comptoir() ;
  

		//this.cuisine = new Cuisine(this);
		this.stock = new Stock();

        this.clients = new ArrayList<Client>() ;
        this.materiel = new HashMap<Materiel,Integer>() ;

        int capaciteAssemblage ;
        int capaciteLaveVaisselle ;
        int quantiteOutilsCuisson ;
        int quantiteDecoupe ;

		
		this.listeRecettes = new ArrayList<Recette.Noms>();
		this.listeRecettes.add(Recette.Noms.FRITES);
		this.listeRecettes.add(Recette.Noms.SIMPLE);

		// Réglages du niveau
		switch (this.numNiveau) {
		// niveau 1 (par défaut)
		default:
			this.scoreMin = 0;
			this.nbAssietteMax = 25;
			this.nbMaxClients = 25;

            // quantité des ingrédients
            nbIngredient = 50 ;

			// définition de la quantité des outils
			capaciteAssemblage = 1;
			capaciteLaveVaisselle = 2;
			quantiteOutilsCuisson = 1;
			quantiteDecoupe = 1;
			break;
		// niveau 2
		case 2:
			this.scoreMin = 300;
			this.nbAssietteMax = 9;
			this.nbMaxClients = 50;


                nbIngredient = 100 ;


			// définition de la quantité des outils
			capaciteAssemblage = 2;
			capaciteLaveVaisselle = 4;
			quantiteOutilsCuisson = 2;
			quantiteDecoupe = 2;

			// ajout d'une nouvelle recette
			this.listeRecettes.add(Recette.Noms.MAXI);

			break;
		// niveau 3
		case 3:
			this.scoreMin = 600;
			this.nbAssietteMax = 6;
			this.nbMaxClients = 75;

                // quantité des ingrédients
                nbIngredient = 150 ;


			// définition de la quantité des outils
			capaciteAssemblage = 3;
			capaciteLaveVaisselle = 4;
			quantiteOutilsCuisson = 2;
			quantiteDecoupe = 2;

			// ajout d'une nouvelle recette
			this.listeRecettes.add(Recette.Noms.MENU);
		}


        // définition d'outils associés à leur quantité
        this.materiel.put(new Decoupe(),quantiteDecoupe) ;
        this.materiel.put(new Friteuse(),quantiteOutilsCuisson) ;
        this.materiel.put(new PlaqueCuisson(),quantiteOutilsCuisson) ;
        this.materiel.put(new Poubelle(),1) ;
        // définition de la station d'assemblage associée à sa capacité maximum
        this.materiel.put(new Assemblage(),capaciteAssemblage) ;
        // définition du lave vaisselle associé à sa capacité maximum
        this.materiel.put(new LaveVaisselle(),capaciteLaveVaisselle) ;

		// définition d'outils associés à leur quantité
		this.materiel.put(new Decoupe(), quantiteDecoupe);
		this.materiel.put(new Friteuse(), quantiteOutilsCuisson);
		this.materiel.put(new PlaqueCuisson(), quantiteOutilsCuisson);
		this.materiel.put(new Poubelle(), 1);
		// définition de la station d'assemblage associée à sa capacité maximum
		this.materiel.put(new Assemblage(), capaciteAssemblage);
		// définition du lave vaisselle associé à sa capacité maximum
		this.materiel.put(new LaveVaisselle(), capaciteLaveVaisselle);

		this.gardeManger = new GardeManger(this);}
	

    /**
     * @return liste des ingrédient et quantité disponibles dans le niveau
     */
    public int getNbIngredient() {
        return nbIngredient;
    }

	/**
	 * @return liste du matériel et quantité disponible dans le niveau
	 */
	public HashMap<Materiel, Integer> getMateriel() {
		return materiel;
	}

	/**
	 * @return nombre d'assiettes max disponbles dans le niveau
	 */
	public int getNbAssietteMax() {
		return nbAssietteMax;
	}
	/**
	 * @return nombre d'assiettes max disponbles dans le niveau
	 */
	public GardeManger getGardeManger() {
		return gardeManger;
	}

	// Setteurs

	/**
	 * Permet de stocker le score et l'argent obtenus dans le tableau à la fin de
	 * la partie
	 * 
	 * @param score
	 * @param argent
	 */
	public void setScoreArgent(int score, int argent) {
		this.tabScoreArgent[1] = score;
		this.tabScoreArgent[2] = argent;
	}

	// Méthodes

	/**
	 * Permet de remplir le tableau de client avec des clients et leur commande
	 * 
	 * @return true si les clients ont bien été créés
	 */
	public boolean creerClients() {
		int attente;
		Recette recette;
		// Pour chaque client
		for (int a = 0; a < this.clients.size(); a++) {
			// Pour chaque temps d'attente
			for (int b = 0; b < this.tmpsAttente.length; b++) {
				// Pour chaque recette
				for (int c = 0; c < this.listeRecettes.size(); c++) {
					// Pour chaque viande
					for (int d = 0; d < Recette.Steaks.values().length; d++) {
						// définition du temps d'attente propre au client
						attente = this.tmpsAttente[b];
						// définition de la commande propre au client
						recette = new Recette(this.listeRecettes.get(c), Recette.Steaks.values()[d]);
						// création du client
						this.clients.add(new Client(attente, recette));
					}
				}
			}
		}
		return true;
	}
}
