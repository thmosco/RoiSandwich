package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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

	private Materiel materielFriteuse;

	private Materiel materielAssemblage;

	private Materiel materielPlaqueDeCuisson;

	private Materiel materielDecoupe;

	private Materiel materielLaveVaisselle;

	private Materiel materielPoubelle;

	// mickael
	// private Ingredient patate = new Ingredient(Nom.PATATE, "image/amandine.png");
	// private IngredientCuit beef = new IngredientCuit(Nom.STEAK_DE_BOEUF,
	// "image/dsc_0315.jpg");
	// private Decoupe plancheADecoupe = new Decoupe();
	// private Friteuse appareilAFritte = new Friteuse();

	@FXML
	ImageView PATATE;
	@FXML
	ImageView SALADE;
	@FXML
	ImageView TOMATE;
	@FXML
	ImageView OIGNON;
	@FXML
	ImageView PAIN;
	@FXML
	ImageView FROMAGE;
	@FXML
	ImageView STEAK_DE_SOJA;
	@FXML
	ImageView STEAK_DE_POULET;
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
	private ImageView emplacementAssietteClient1;

	@FXML
	private ImageView emplacementAssietteClient2;

	@FXML
	private ImageView emplacementAssietteClient3;

	@FXML
	BorderPane decoupe;

	@FXML
	ImageView containerDansDecoupe;

	@FXML
	BorderPane plaque_cuisson;

	@FXML
	ImageView containerDansCuisson;

	@FXML
	ProgressBar cuissonProgress;

	Service<Void> CuissonEnCoursSteak;

	@FXML
	BorderPane friteuse;

	@FXML
	private BorderPane assemblage;

	@FXML
	ImageView containerDansFriteuse;

	@FXML
	ImageView evier;

	@FXML
	ImageView garde_manger;

	@FXML
	ImageView poubelle;

	@FXML
	ImageView containerView;

	@FXML
	ImageView assiettePropre;

	@FXML
	private Label compteurPAIN;

	@FXML
	private Label compteurFROMAGE;

	@FXML
	private Label compteurOIGNON;

	@FXML
	private Label compteurTOMATE;

	@FXML
	private Label compteurSALADE;

	@FXML
	private Label compteurPATATE;

	@FXML
	private Label compteurSTEAK_DE_BOEUF;

	@FXML
	private Label compteurSTEAK_DE_POULET;

	@FXML
	private Label compteurSTEAK_DE_SOJA;

	@FXML
	private Label compteurAssitette;

	@FXML
	private ImageView emplacementAssiette;

//	@FXML
//	private TextArea assemblageTextArea;

	public void prendreAssiettePropre(MouseEvent e) {
		if (container == null) {
			Object image = e.getSource();
			Object c = Main.niveau1.getCuisine().retirerAssietteDeLaCuisine();
			mettreDansContainer(c);
		} else {
			System.out.println("container non vide");
		}

//		materielAssemblage.ajouterObjet(assiette);
	}

	@FXML
	public void prendreIngredient(MouseEvent e) {
		if (container == null) {
			Object image = e.getSource();
			String idImage = ((Node) image).getId();
			Object c = Main.niveau1.getGardeManger().prendreIngredient(Nom.valueOf(idImage));
			mettreDansContainer(c);
		} else {
			System.out.println("Vous avez déjà quelque chose dans votre main");
		}
	}

	public void decouper(MouseEvent e) throws IllegalAccessException {
		// si le container est nul alors il faut selectionner un ingredient
		if (container == null) {
			if (checkSiIngredientPresentDansMateriel(materielDecoupe)) {
				containerDansDecoupe.setImage(null);
			}
		}
		// si le container n'est pas vide
		else {
			try {

				if (((Ingredient) container).isDecoupable()) {
					if (((Decoupe) materielDecoupe).getEmplacementVide()) {
						Ingredient ingredient = (Ingredient) container;
						containerDansDecoupe
								.setImage(new Image(getClass().getResourceAsStream(ingredient.getImgIngredient())));
						materielDecoupe.ajouterObjet(ingredient);
						viderContainer();
						// si le container est découpable
						if (ingredient.isDecoupable()) {
							// si cette ingredient découpable n'est pas déja transformé alors le découper
							if (ingredient.getTransformer() == false) {
								((Decoupe) materielDecoupe).decouper();
								System.out.println(ingredient.getImgIngredient());
								containerDansDecoupe.setImage(
										new Image(getClass().getResourceAsStream(ingredient.getImgIngredient())));
								System.out.println(ingredient.getNom() + " a été découpé ");
							}
							// sinon cette ingredient découpable a déja été découpé
							else {
								System.out.println(ingredient.getNom() + " a déja été découpé");
							}
						}
						// sinon cette ingredient n'est pas découbale
						else {
							System.out.println(ingredient.getNom() + " n'est pas découpable");
						}
						System.out.println("transformé : " + ingredient.getNom() + " : " + ingredient.getTransformer());
					} else {
						System.out.println("Il y a déjà quelque chose dans ce materiel");
					}
				} else {
					System.out.println("l'ingredient n'est pas découpable");
				}
			} catch (Exception e2) {
				System.out.println("seul les ingredients peuvent etre découpés petit malin ;)");
			}
		}

	}

	public void cuir(MouseEvent e) {
		if (container == null) {
			checkSiIngredientPresentDansMateriel(materielPlaqueDeCuisson);
			if (CuissonEnCoursSteak != null) {
				CuissonEnCoursSteak.cancel();
				CuissonEnCoursSteak.reset();
				cuissonProgress.setProgress(0.0);
			}
		} else {
			Ingredient ingredient = ((Ingredient) container);
			if (((Ingredient) container).isSteak() == true) {
				if (((Ingredient) container).getEtat() == Etat.CRU) {
					try {
						materielPlaqueDeCuisson.ajouterObjet(ingredient);
						// containerDansCuisson.setImage(new
						// Image(getClass().getResourceAsStream("../image/friteuse.png")));
						viderContainer();
						cuissonProgression(ingredient, cuissonProgress, 10);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

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
			System.out.println("ingredient contenu " + materielFriteuse.objetsContenus.size());
			if (checkSiIngredientPresentDansMateriel(materielFriteuse)) {
				containerDansFriteuse.setImage(new Image(getClass().getResourceAsStream("../image/friteuse.png")));
			}
		} else {
			Ingredient a = ((Ingredient) container);
			if (a.getNom().toString().equals("PATATE") & a.getTransformer()) {
				materielFriteuse.ajouterObjet(a);
				containerDansFriteuse
						.setImage(new Image(getClass().getResourceAsStream("../image/friteuse_cuisson.png")));
				viderContainer();
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
				System.out.println("seul les patates coupé peuvent être fries");
			}
		}
	}

	public void assembler(MouseEvent event) {
		if (container == null) {
			System.out.println("selectionner un ingredient");
			mettreDansContainer(((Assiette) materielAssemblage.objetsContenus.get(0)));
			emplacementAssiette.setImage(null);

		} else if (container instanceof Assiette) {
			materielAssemblage.ajouterObjet(container);
			viderContainer();
			emplacementAssiette.setImage(new Image(getClass().getResourceAsStream("../image/assiette.png")));
			System.out.println("assiette ajouté");
		} else if (container instanceof Ingredient) {
			if (materielAssemblage.objetsContenus.size() == 0) {
				System.out.println("il faut mettre une assiette propre d abord");
			} else {
				Assiette a = (Assiette) materielAssemblage.objetsContenus.get(0);
				a.ajouterObjet(container);
				viderContainer();
				System.out.println("ingredient ajouté à assiette :");
				for (int i = 0; i < a.objetsContenus.size(); i++) {
					System.out.print(((Ingredient) a.objetsContenus.get(i)).getNom() + " , " + "transformé ="
							+ ((Ingredient) a.objetsContenus.get(i)).getTransformer() + " , état ="
							+ ((Ingredient) a.objetsContenus.get(i)).getEtat() + " ; ");
				}
			}
		} else {
			System.out.println("ca c'est rien y a un probleme dans assembler");
		}
	}

	public boolean checkSiIngredientPresentDansMateriel(Materiel m) {
		if (m.objetsContenus.isEmpty()) {
			System.out.println("veuillez selectionner un ingredient");
			return false;
		}
		// sinon, container = ingredient contenu dans le materiel de decoupe
		else {
			System.out.println("contenu du materiel avant " + m.objetsContenus.size());
//			this.container = m.objetsContenus.get(0);
			mettreDansContainer(m.objetsContenus.get(0));
			m.retirerObjet(this.container);
			System.out.println("contenu du materiel apres " + m.objetsContenus.size());
			System.out.println("ingredient ajouté à container");
			return true;
		}
	}

	public void jeter() {
		viderContainer();
	}

	public int compteur(Nom n) {
		return Main.niveau1.getGardeManger().getCompteurs().get(n);
	}

	public void mettreDansContainer(Object o) {
		if (o instanceof Ingredient) {
			container = ((Ingredient) o);
			containerView
					.setImage(new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
			Nom nomIngredient = ((Ingredient) container).getNom();
			switch (nomIngredient) {
			case PATATE:
				compteurPATATE.setText(String.valueOf(compteur(Nom.PATATE)));
				break;
			case FROMAGE:
				compteurFROMAGE.setText(String.valueOf(compteur(Nom.FROMAGE)));
				break;
			case PAIN:
				compteurPAIN.setText(String.valueOf(compteur(Nom.PAIN)));
				break;
			case OIGNON:
				compteurOIGNON.setText(String.valueOf(compteur(Nom.OIGNON)));
				break;
			case SALADE:
				compteurSALADE.setText(String.valueOf(compteur(Nom.SALADE)));
				break;
			case STEAK_DE_BOEUF:
				compteurSTEAK_DE_BOEUF.setText(String.valueOf(compteur(Nom.STEAK_DE_BOEUF)));
				break;
			case STEAK_DE_POULET:
				compteurSTEAK_DE_POULET.setText(String.valueOf(compteur(Nom.STEAK_DE_POULET)));
				break;
			case STEAK_DE_SOJA:
				compteurSTEAK_DE_SOJA.setText(String.valueOf(compteur(Nom.STEAK_DE_SOJA)));
				break;
			case TOMATE:
				compteurTOMATE.setText(String.valueOf(compteur(Nom.TOMATE)));
				break;
			}
		}
		if (o instanceof Assiette) {
			container = ((Assiette) o);
			compteurAssitette.setText(String.valueOf(Main.niveau1.getCuisine().getAssiettes().size()));
			containerView.setImage(new Image(getClass().getResourceAsStream("../image/assiette.png")));
		}

		System.out.println("container = " + container.getClass());
	}

	public void viderContainer() {
		container = null;
		containerView.setImage(null);
	}

	public void cuissonProgression(Ingredient ingredient, ProgressBar progress, double temps)
			throws InterruptedException {

		Service<Void> CuissonMateriel = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {

						for (int i = 0; i < temps; i++) {
							if (isCancelled()) {
								break;
							}
							cuissonProgress.setProgress(cuissonProgress.getProgress() + (1.0 / temps));
							cuissonProgress.setStyle("-fx-accent: green;");
							Thread.sleep(1000);
						}
						System.out.println("Votre steak est cuit");
						ingredient.setEtat(Etat.CUIT);
						cuissonProgress.setProgress(0.0);
						for (int i = 0; i < 10 / 2; i++) {
							if (isCancelled()) {
								break;
							}
							cuissonProgress.setProgress(cuissonProgress.getProgress() + (1.0 / temps) * 2.0);
							cuissonProgress.setStyle("-fx-accent: orange;");
							Thread.sleep(1000);
						}
						ingredient.setEtat(Etat.BRULE);
						cuissonProgress.setProgress(1);
						cuissonProgress.setStyle("-fx-accent: red;");
						System.out.println("Votre steak est brulé");
						return null;
					}
				};
			}
		};
		CuissonEnCoursSteak = CuissonMateriel;
		CuissonMateriel.start();
	}

//		cuissonProgress.setProgress(0.2);
//		cuissonProgress.setStyle("-fx-accent: green;");
//		Thread.sleep(2000);
//		cuissonProgress.setProgress(0.4);
//		cuissonProgress.setStyle("-fx-accent: green;");
//		Thread.sleep(2000);
//		cuissonProgress.setProgress(0.6);
//		cuissonProgress.setStyle("-fx-accent: green;");
//		Thread.sleep(2000);
//		cuissonProgress.setProgress(0.8);
//		cuissonProgress.setStyle("-fx-accent: green;");
//		Thread.sleep(2000);
//		cuissonProgress.setProgress(1.0);
//		cuissonProgress.setStyle("-fx-accent: green;");
//		ingredient.setEtat(Etat.CUIT);
//		System.out.println("Votre viande est cuite, récupérez le avant qu'il soit cramé !");
//		Thread.sleep(3000);
//		cuissonProgress.setProgress(0.3);
//		cuissonProgress.setStyle("-fx-accent: orange;");
//		Thread.sleep(2000);
//		cuissonProgress.setProgress(0.6);
//		cuissonProgress.setStyle("-fx-accent: orange;");
//		Thread.sleep(2000);
//		cuissonProgress.setProgress(1.0);
//		cuissonProgress.setStyle("-fx-accent: orange;");
//		Thread.sleep(2000);
//		cuissonProgress.setProgress(1.0);
//		cuissonProgress.setStyle("-fx-accent: red;");
//		ingredient.setEtat(Etat.BRULE);
//		System.out.println("Votre viande est complétement carbonisé !");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		// mickael : récupere tous l'adresse de tous les materiels du niveau pour le
		// controlleur
		for (Materiel i : Main.niveau1.getMateriel().keySet()) {
			if (i instanceof Decoupe) {
				materielDecoupe = i;
//				System.out.println("ajouté");
			}
			if (i instanceof Assemblage) {
				materielAssemblage = i;
//				System.out.println("ajouté");
			}
			if (i instanceof Friteuse) {
				materielFriteuse = i;
//				System.out.println("ajouté");
			}
			if (i instanceof LaveVaisselle) {
				materielLaveVaisselle = i;
//				System.out.println("ajouté");
			}
			if (i instanceof PlaqueCuisson) {
				materielPlaqueDeCuisson = i;
//				System.out.println("ajouté");
			}
			if (i instanceof Poubelle) {
				materielPoubelle = i;
//				System.out.println("ajouté");
			}

		}

		compteurPATATE.setText(String.valueOf(compteur(Nom.PATATE)));
		compteurFROMAGE.setText(String.valueOf(compteur(Nom.FROMAGE)));
		compteurPAIN.setText(String.valueOf(compteur(Nom.PAIN)));
		compteurOIGNON.setText(String.valueOf(compteur(Nom.OIGNON)));
		compteurSALADE.setText(String.valueOf(compteur(Nom.SALADE)));
		compteurSTEAK_DE_BOEUF.setText(String.valueOf(compteur(Nom.STEAK_DE_BOEUF)));
		compteurSTEAK_DE_POULET.setText(String.valueOf(compteur(Nom.STEAK_DE_POULET)));
		compteurSTEAK_DE_SOJA.setText(String.valueOf(compteur(Nom.STEAK_DE_SOJA)));
		compteurTOMATE.setText(String.valueOf(compteur(Nom.TOMATE)));

		compteurAssitette.setText(String.valueOf(Main.niveau1.getCuisine().getAssiettes().size()));

	}
}
