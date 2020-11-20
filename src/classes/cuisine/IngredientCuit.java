/**
 * Commentaire de documentation de la classe IngredientCuit
 * @version 1.0
 * @author Thomas MOSCONI
 */
package classes.cuisine;

public class IngredientCuit extends Ingredient {

	private int tempsCuisson = 10000;
	
	public IngredientCuit(Nom nom) {
		super(nom);
	}

	public IngredientCuit(Nom nom, int temps_de_cuisson) {
		super(nom);
		this.tempsCuisson = temps_de_cuisson;
	}

	public int getTempsCuisson() {
		return tempsCuisson;
	}
}
