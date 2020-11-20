/**
 * Commentaire de documentation de la classe Ingredient
 * @version 1.0
 * @author Thomas MOSCONI
 */

package classes.cuisine;

public class Ingredient {

	private Nom nom;
	// private int quantite;//
	private boolean transformer;
	private Etat etat;

	public enum Etat {
		CRU, CUIT, BRULE
	}

    public enum Nom{POMME_DE_TERRE, SALADE, TOMATE, OIGNON, PAIN, FROMAGE, STEAK_DE_SOJA, STEAK_DE_POULET, STEAK_DE_BOEUF}

	public Ingredient(Nom nom) {
		this.nom = nom;
		this.etat = Etat.CRU;
    	this.transformer = false ;
	}

	public Etat getEtat() {
    	return this.etat;
    }

	public boolean getTransformer() {
    	return transformer;
    }

	public Nom getNom() {
		return nom;
	}

	public boolean isSteak () {
		return (this.getNom() == Nom.STEAK_DE_BOEUF
				|| this.getNom() == Nom.STEAK_DE_POULET
				|| this.getNom() == Nom.STEAK_DE_SOJA) ;
	}

	public void setTransformer(boolean etat) {
		this.transformer = etat ;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
}
