package classes.cuisine;

import classes.Niveau;
import classes.cuisine.Ingredient.Nom;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Commentaire de documentation de la classe GardeManger
 * 
 * @version 1.0
 * @author Thomas MOSCONI
 *
 * @version 2.0
 * @author Maia DA SILVA
 */
public class GardeManger {

	// Variables de classe

	/**
	 * liste des pains disponibles garde manger et leur quantité
	 */
	private ArrayList pains;
	/**
	 * liste des fromages disponibles garde manger et leur quantité
	 */
	private ArrayList fromages;
	/**
	 * liste des oignons disponibles garde manger et leur quantité
	 */
	private ArrayList oignons;
	/**
	 * liste des salades disponibles garde manger et leur quantité
	 */
	private ArrayList salades;
	/**
	 * liste des tomates disponibles garde manger et leur quantité
	 */
	private ArrayList tomates;
	/**
	 * liste des patates disponibles garde manger et leur quantité
	 */
	private ArrayList patates;
	/**
	 * liste des steaks de boeuf disponibles garde manger et leur quantité
	 */
	private ArrayList boeuf;
	/**
	 * liste des steaks de poulet disponibles garde manger et leur quantité
	 */
	private ArrayList poulet;
	/**
	 * liste des steaks de soja disponibles garde manger et leur quantité
	 */
	private ArrayList soja;

	/**
	 * Constructeur
	 * 
	 * @param niveau
	 */
	public GardeManger(Niveau niveau) {
		// Initialisation des listes
		this.pains = new ArrayList<Ingredient>();
		this.fromages = new ArrayList<Ingredient>();
		this.oignons = new ArrayList<Ingredient>();
		this.salades = new ArrayList<Ingredient>();
		this.tomates = new ArrayList<Ingredient>();
		this.patates = new ArrayList<IngredientCuit>();
		this.boeuf = new ArrayList<IngredientCuit>();
		this.poulet = new ArrayList<IngredientCuit>();
		this.soja = new ArrayList<IngredientCuit>();

		// Création des ingrédients dans le garde manger
		Iterator iterator = niveau.getIngredient().keySet().iterator();

		while (iterator.hasNext()) {
			Ingredient ingredient = (Ingredient) iterator.next();

			// Création des pains dans la quantité indiquée par le niveau
			if (ingredient.getNom() == Nom.PAIN) {

//				for (int i = 0 ; i < niveau.getIngredient().get(iterator.next()); i++) {
				this.pains.add(new Ingredient(Nom.PAIN));
//				}

				// Création des fromages dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.FROMAGE) {


				// Création des oignons dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.OIGNON) {


				// Création des salades dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.SALADE) {


				// Création des tomates dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.TOMATE) {


				// Création des patates dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.PATATE) {

					this.patates.add(new IngredientCuit(Nom.PATATE)) ;
//				}
//				}

				// mickael
				for (int i = 0; i < niveau.getQuantiteIngredient(); i++) {

					this.patates.add(new IngredientCuit(Nom.PATATE));
//					}
				}

				// Création des steaks de boeuf dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.STEAK_DE_BOEUF) {


				// Création des steaks de poulet dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.STEAK_DE_POULET) {


				// Création des steaks de soja dans la quantité indiquée par le niveau
			} else if (ingredient.getNom() == Nom.STEAK_DE_SOJA) {

			}
		}
	}

	// mickael
	public ArrayList getPatates() {
		return patates;
	}
	//mickael
	public Ingredient saisirUnIngredient(String nom) {
		Ingredient i;
		if(nom.equals("PATATE")) {
			i = (Ingredient) patates.get(0);
			patates.remove(0);
			return i;
			}
		if(nom.equals("STEAK_DE_BOEUF")) {
			i = (Ingredient) boeuf.get(0);
			boeuf.remove(0);
			return i;
		}
		return null;

	}
}
