package classes.cuisine;

/**
 * Commentaire de documentation de la classe Ingrédient
 * @version 1.0
 * @author Thomas MOSCONI
 *
 * @version 2.0
 * @author Maia DA SILVA
 */
public class Ingredient {

	/**
	 * Nom de l'ingrédient
	 */
	private Nom nom;
	/**
	 * Booléen permettant de savoir si l'ingrédient est découpé ou non
	 */
	private boolean transformer;
	/**
	 * Etat de cuisson de l'ingrédient
	 */
	private Etat etat;

	/**
	 * Enumération des différents etats de cuisson possibles
	 */
	public enum Etat {
		CRU, CUIT, BRULE
	}

	/**
	 * Enumération des noms des ingrédients disponibles
	 */
    public enum Nom{PATATE, SALADE, TOMATE, OIGNON, PAIN, FROMAGE, STEAK_DE_SOJA, STEAK_DE_POULET, STEAK_DE_BOEUF}


	/**
	 * Constructeur
	 * @param nom
	 */
	public Ingredient(Nom nom) {
		this.nom = nom;
		this.etat = Etat.CRU;
    	this.transformer = false ;
	}

	// Getteurs

	/**
	 * @return l'état de cuisson d'un ingrédient
	 */
	public Etat getEtat() {
    	return this.etat;
    }

	/**
	 * Retourne l'état de transformation d'un ingrédient
	 * @return true si l'ingrédient est découpé, false sinon
	 */
	public boolean getTransformer() {
    	return transformer;
    }

	/**
	 * @return le nom de l'ingrédient
	 */
	public Nom getNom() {
		return nom;
	}

	// Setteurs

	/**
	 * Permet de faire passer l'ingrédient d'un état entier à découpé
	 * @param etat
	 */
	public void setTransformer(boolean etat) {
		this.transformer = etat ;
	}

	/**
	 * Permet de changer l'état de cuisson d'un ingrédient
	 * @param etat
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	// Méthodes

	/**
	 * @return true si l'ingrédient est un steak
	 */
	public boolean isSteak () {
		return (this.getNom() == Nom.STEAK_DE_BOEUF
				|| this.getNom() == Nom.STEAK_DE_POULET
				|| this.getNom() == Nom.STEAK_DE_SOJA) ;
	}

	/**
	 * @return true si l'ingrédient est découpable
	 */
	public boolean isDecoupable () {
		return (this.getNom() == Nom.PATATE
				|| this.getNom() == Nom.TOMATE
				|| this.getNom() == Nom.OIGNON
				|| this.getNom() == Nom.SALADE) ;
	}
}
