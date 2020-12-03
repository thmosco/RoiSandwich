package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.Button;
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

	private Object container;

	// mickael
	private Ingredient patate = new Ingredient(Nom.POMME_DE_TERRE, "image/amandine.png");
	private IngredientCuit beef = new IngredientCuit(Nom.STEAK_DE_BOEUF, "image/dsc_0315.jpg");
	private Decoupe plancheADecoupe = new Decoupe();
	private Friteuse appareilAFritte = new Friteuse();

	@FXML
	ImageView pommeDeTerre;
	@FXML
	ImageView boeuf;
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

	// containerView à supprimer quand tout marche
	@FXML
	ImageView containerView;

	public void prendreIngredient(MouseEvent event) {
		final Node source = (Node) event.getSource();
		String id = source.getId();
		System.out.println(id);
		typeIngredient(id);
		System.out.println(container + " a été ajouté");

		// met l'image de l'ingredient dans un container (à supprimer à la fin, Mickael)
		containerView.setImage(new Image(((Ingredient) container).getUrlImage()));
	}

	public void interagirDansDecoupe(MouseEvent event) {
		if (container != null) {
			if (container instanceof Ingredient) {

				try {
					// met l'image de l'ingredient dans l'imageview du materiel (mickael)
					containerDansDecoupe.setImage(new Image(((Ingredient) container).getUrlImage()));
					// enleve l'image dans container (à supprimer à la fin, Mickael)
					containerView.setVisible(false);
					plancheADecoupe.ajouterObjet((Ingredient) container);
					System.out.println(((Ingredient) container).getNom() + " a été découpé");
					container = null;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
//			System.out.println(((Ingredient) container).getNom() + " a été découpé ");
			container = plancheADecoupe.objetsContenus.get(0);
			System.out.println(container.toString());

			// supprime l'image de l'ingrédient dans l'imageview du materiel(mickael)
			plancheADecoupe.retirerObjet((Ingredient) container);
			containerDansDecoupe.setVisible(false);
			containerView.setVisible(true);
			containerView.setImage(new Image(((Ingredient) container).getUrlImage()));

		}
	}

	public void interagirDansFriteuse(MouseEvent event) {

		if (container != null) {
			if (container instanceof Ingredient) {
				if (((Ingredient) container).getNom() == Nom.POMME_DE_TERRE) {
					if (((Ingredient) container).getTransformer() == true) {
						if (((Ingredient) container).getEtat().equals(Etat.CRU)) {

							try {
								((Ingredient) container).setEtat(Etat.CUIT);
								appareilAFritte.ajouterObjet(((Ingredient) container));
								System.out.println("Ingredient cuit");
//							containerView.setVisible(false);
								containerView.imageProperty().set(null);
								containerDansFritteuse.setImage(new Image(((Ingredient) container).getUrlImage()));
								container = null;

							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println("déja cuit");
						}
					} else {
						System.out.println("veuillez découper les pommes de terre avant de les cuir");
					}
				} else {
					System.out.println("Cette ingredient ne peut pas aller dans la friteuse");
				}
			}
		} else if (appareilAFritte.objetsContenus.size() != 0) {
			System.out.println("Vous avez récupéré l'ingredient dans la fritteuse ");
			container = appareilAFritte.objetsContenus.get(0);
			containerDansFritteuse.setVisible(false);
			appareilAFritte.retirerObjet(((Ingredient) container));
			containerView.setImage(new Image(((Ingredient) container).getUrlImage()));
			containerView.setVisible(true);

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
		} else {
			System.out.println("Cette ingredient ne peut pas aller sur les plaque de cuisson");
		}
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

	// recupere et stock dans container l'ingredient en fonction de l'id de la
	// source du click (mickael)
	public void typeIngredient(String s) {
		switch (s) {
		case "pommeDeTerre":
			container = patate;
			break;
		case "boeuf":
			container = beef;
			break;
		default:
			container = null;
		}

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
