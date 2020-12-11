package classes.cuisine;

import classes.Niveau;
import classes.cuisine.Ingredient.Nom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Commentaire de documentation de la classe GardeManger
 * @version 1.0
 * @author Thomas MOSCONI
 *
 * @version 2.0
 * @author Maia DA SILVA
 */
public class GardeManger {

	// Variables de classe

	/**
	 * liste des compteurs des ingrédients : représente le nb d'ingrédient utilisé par le joueur
	 */
	private HashMap<Ingredient.Nom, Integer> compteurs ;

	/**
	 * niveau de la partie en cours
	 */
	private Niveau niveau ;

	/**
	 * Constructeur
	 * @param niveau
	 */
	public GardeManger(Niveau niveau) {
		this.niveau = niveau ;
		Ingredient.Nom [] ingredients = Ingredient.Nom.values() ;
		for (int i = 0 ; i < ingredients.length ; i++) {
			compteurs.put(ingredients[i],0) ;
		}
	}

	public boolean prendreIngredient (Ingredient.Nom ingredient) {
		int compteur = compteurs.get(ingredient) ;
		if (compteur > this.niveau.getNbIngredient()) {
			return false ;
		}
		return compteurs.replace(ingredient, compteur, compteur++) ;
	}
}
