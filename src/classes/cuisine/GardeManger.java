/**
 * Commentaire de documentation de la classe GardeManger
 * @version 1.0
 * @author Thomas MOSCONI
 */

package classes.cuisine;

import classes.cuisine.Ingredient.Nom;

public class GardeManger {
	
	Ingredient[] gardemanger;
	
	public Ingredient saisirUnIngredient(Nom nom) {
		Ingredient ingredient = new Ingredient(nom);
		return ingredient;
	}
	
}
