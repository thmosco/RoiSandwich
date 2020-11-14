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

	public enum Nom {
		POMME_DE_TERRE, SALADE, OIGNON, PAIN, FROMAGE, STEAK_DE_SOJA, STEAK_DE_POULET, STEAK_DE_BOEUF, TOMATE
	}

	public Ingredient(Nom nom) {
		this.nom = nom;
		this.etat = Etat.CRU;
	}

	public Etat getEtat() {
    	return this.etat;
    }

	public boolean getTransformer() {
    	return transformer;
    }

}
