package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import classes.cuisine.Ingredient;
import classes.cuisine.Ingredient.Etat;
import classes.cuisine.Ingredient.Nom;
import classes.*;
import classes.cuisine.*;
import classes.cuisine.materiel.*;

public class Controller implements Initializable {

	private Object container;

	@FXML
	ImageView ingredient1;
	@FXML
	ImageView ingredient2;
	@FXML
	ImageView ingredient3;
	@FXML
	ImageView ingredient4;
	@FXML
	ImageView ingredient5;
	@FXML
	ImageView ingredient6;
	@FXML
	ImageView ingredient7;
	@FXML
	ImageView ingredient8;
	@FXML
	ImageView ingredient9;

	@FXML
	ImageView stock1;
	@FXML
	ImageView stock2;
	@FXML
	ImageView stock3;

	@FXML
	ImageView client1;
	@FXML
	ImageView client2;
	@FXML
	ImageView client3;

	@FXML
	ImageView decoupe;

	@FXML
	ImageView plaque_cuisson;

	@FXML
	ImageView friteuse;

	@FXML
	ImageView assemblage;

	@FXML
	ImageView evier;

	@FXML
	ImageView garde_manger;

	public void prendreIngredient(MouseEvent event) {
		// Niveau.getIngredient();
		Ingredient ingredient = new Ingredient(Nom.POMME_DE_TERRE);
		this.container = ingredient;
	}

	public void interagirDansDecoupe(MouseEvent event) {
		if (container != null) {
			if (container instanceof Ingredient) {
				((Ingredient) container).setTransformer(true);
				System.out.println(((Ingredient) container).getTransformer());
				System.out.println("Ingredient découpé");
				container = null;
			}
		} else {
			System.out.println("Vous avez récupéré l'ingredient dans la planche à découper (pas encore dispo)");
		}
	}

	public void interagirDansFriteuse(MouseEvent event) {
		if (container instanceof Ingredient) {
			if (((Ingredient) container).getNom() == Nom.POMME_DE_TERRE) {
				((Ingredient) container).setEtat(Etat.CUIT);
				System.out.println("Ingredient cuit");
			}
			else {
				System.out.println("Cette ingredient ne peut pas aller dans la friteuse");
				}
			
		}
	}

	public void interagirDansLaveVaisselle(MouseEvent event) {
		if (container != null) {
			if (container instanceof Assiette) {
					System.out.println("Assiette dans Lave Vaiselle");
			} else {
				System.out.println("Ceci n'est pas une assiette");
			}
		} else {
			System.out.println("Vous n'avez rien dans votre main");
		}
	}

	public void interagirPlaqueCuisson(MouseEvent event) {
		if (container instanceof IngredientCuit) {
				((Ingredient) container).setEtat(Etat.CUIT);
				System.out.println(((Ingredient) container).getEtat());
			}
		else { System.out.println("Cette ingredient ne peut pas aller sur les plaque de cuisson");}
	}

	public void interagirAssemblage(MouseEvent event) {

	}

	public void interagirStock(MouseEvent event) {
		if (container instanceof Assiette) {

		}

	}

	public void interagirClient(MouseEvent event) {
		if (container != null) {
			if (container instanceof Assiette) {

			} else {
				System.out.println("Ceci n'est pas une assiette !");
			}
		} else {
			System.out.println("Vous n'avez rien dans votre main");
		}

	}

	public void jeterPoubelle(MouseEvent event) {
		if (container != null) {
			if (container instanceof Ingredient) {
				container = null;
				System.out.println("Items supprimé");
			} else {
				System.out.println("Ceci n'est pas un Ingredient");
			}
		} else {
			System.out.println("Vous n'avez rien dans votre main");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
