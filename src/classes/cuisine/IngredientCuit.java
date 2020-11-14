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
}
