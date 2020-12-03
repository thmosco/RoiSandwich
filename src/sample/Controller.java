package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

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

//	

	private Object container;

	// mickael

	@FXML
	ImageView PATATE;
	@FXML
	ImageView STEAK_DE_BOEUF;
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
	ImageView containerDansDecoupe;

	@FXML
	ImageView plaque_cuisson;

	@FXML
	ImageView friteuse;

	@FXML
	ImageView containerDansFritteuse;

	@FXML
	ImageView assemblage;

	@FXML
	ImageView evier;

	@FXML
	ImageView garde_manger;

	// containerView Ã  supprimer quand tout marche
	@FXML
	ImageView containerView;

	@FXML
	Label containerLabel;

	@FXML
	public void prendreIngredient(MouseEvent e) {
		Object image = e.getSource();
		String idImage = ((Node) image).getId();
		for (Ingredient i : Main.niveau1.getIngredient().keySet()) {
			if (idImage.equals(i.getNom().toString())) {
				container = new Object();
				container = i;
				containerLabel.setText(i.getNom().toString());
			}
		}
		System.out.println(((Ingredient) container).getNom() + " a été selectionné");

	}

	public void decouper(MouseEvent e) {
		// si le container est nul alors il faut selectionner un ingredient
		if (container == null) {
			System.out.println("veuillez selectionner un ingredient");
		}
		// sinon
		else {
			// si le container est découpable
			if (((Ingredient) container).isDecoupable() == true) {
				// si cette ingredient découpable n'est pas déja transformé alors le découper
				if (((Ingredient) container).getTransformer() == false) {
					((Ingredient) container).setTransformer(true);
					System.out.println(((Ingredient) container).getNom() + " a été découpé ");
				}
				// sinon cette ingredient découpable a déja été découpé
				else {
					System.out.println(((Ingredient) container).getNom() + " a déja été découpé");
				}
			}
			// sinon cette ingredient n'est pas découbale
			else {
				System.out.println(((Ingredient) container).getNom() + " n'est pas découpable");
			}
		}
	}

	public void cuir(MouseEvent e) {
		if (container == null) {
			System.out.println("veuillez selectionner un ingredient");
		} else {
			if (((Ingredient) container).isSteak() == true) {
				if (((Ingredient) container).getEtat() == Etat.CRU) {
					((Ingredient) container).setEtat(Etat.CUIT);
					System.out.println(((Ingredient) container).getNom() + " a été cuit");
				} else {
					System.out.println(((Ingredient) container).getNom() + " a déja été cuit");
				}
			} else {
				System.out.println(((Ingredient) container).getNom() + " ne peut pas etre cuit");
			}
		}
	}

	public void frire(MouseEvent e) {
		if (container == null) {
			System.out.println("veuillez selectionner un ingredient");
		} else {

			Ingredient a = ((Ingredient) container);
			if (a.getNom().toString().equals("PATATE")) {
				if (a.getTransformer() == true) {
					if (a.getEtat() == Etat.CRU) {
						a.setEtat(Etat.CUIT);
						System.out.println(a.getNom() + " a été cuit");
					} else {
						System.out.println(a.getNom() + " a déja été cuit");
					}

				} else {
					System.out.println(a.getNom() + " doit etre découpé");
				}
			} else {
				System.out.println("seul les patates peuvent être fries");
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
