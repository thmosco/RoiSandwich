package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
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
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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
	private ImageView emplacementAssemblagePain;

	@FXML
	private ImageView emplacementAssemblageFromage;

	@FXML
	private ImageView emplacementAssemblageOignon;

	@FXML
	private ImageView emplacementAssemblageTomate;

	@FXML
	private ImageView emplacementAssemblageSalade;

	@FXML
	private ImageView emplacementAssemblagePatate;

	@FXML
	private ImageView emplacementAssemblageSteak;

	@FXML
	ImageView stock1;
	@FXML
	ImageView stock2;
	@FXML
	ImageView stock3;

	@FXML
	ImageView client1;
	@FXML
	ProgressBar client1Progress;
	Service<Void> client1EnCours;

	@FXML
	ImageView client2;
	@FXML
	ProgressBar client2Progress;
	Service<Void> client2EnCours;

	@FXML
	ImageView client3;
	@FXML
	ProgressBar client3Progress;
	Service<Void> client3EnCours;

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

	@FXML
	Label tempsEnCours;


	public void donnerAssietteClient(MouseEvent e) throws IllegalAccessException {
		if ((container != null) && (container instanceof Assiette)) {
			ImageView i = (ImageView) e.getSource();
			switch (i.getId()) {
			case "client1":
				System.out.println("tu as choisis le client 1");
				emplacementAssietteClient1.setImage(new Image(getClass().getResourceAsStream(((Assiette) container).getImgAssiette())));
//				Main.niveau1.getComptoir().ajouterClient(client1EnCours);
				client1EnCours.cancel();
				client1EnCours.reset();
				client1Progress.setProgress(0.0);
				if (Main.niveau1.getClients().get(0).verifierPlat((Assiette) container)) {
					Main.niveau1.setScoreArgent(100, 100);
					System.out.println("score augmenté");
				}
				client1EnCours = null;
				viderContainer();
				break;
			case "client2":
				System.out.println("tu as choisis le client 2");
				emplacementAssietteClient2.setImage(new Image(getClass().getResourceAsStream(((Assiette) container).getImgAssiette())));
				client2EnCours.cancel();
				client2EnCours.reset();
				client2Progress.setProgress(0.0);
				// faire un un tableau de variable dans la niveau pour voir les clients à table
//				if(Main.niveau1.getClients().get(0).verifierPlat((Assiette)container)) {
//					Main.niveau1.setScoreArgent(100, 100);
//					System.out.println("score augmenté");
//				}				
				client2EnCours = null;
				viderContainer();
				break;
			case "client3":
				System.out.println("tu as choisis le client 3");
				emplacementAssietteClient3.setImage(new Image(getClass().getResourceAsStream(((Assiette) container).getImgAssiette())));
				client3EnCours.cancel();
				client3EnCours.reset();
				client3Progress.setProgress(0.0);
				client3EnCours = null;
				viderContainer();
				break;
			}
		}
		else {
			
		}
	}

	public void prendreAssiettePropre(MouseEvent e) {
		if (container == null) {
//			Object image = e.getSource();
			Object c = Main.niveau1.getCuisine().retirerAssietteDeLaCuisine();
			mettreDansContainer(c);
		} else {
			System.out.println("container non vide");
		}
	}

	@FXML
	public void prendreIngredient(MouseEvent e) {
		if (materielAssemblage.objetsContenus.size() == 0) {
			System.out.println("attention, il n'y a pas d'assiette dans l'assemblage");
		} else {
			if (container == null) {
				Object image = e.getSource();
				String idImage = ((Node) image).getId();
				Object c = Main.niveau1.getGardeManger().prendreIngredient(Nom.valueOf(idImage));
				mettreDansContainer(c);
			} else {
				System.out.println("Vous avez déjà quelque chose dans votre main");
			}

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
			if (materielAssemblage.objetsContenus.size() != 0) {
				System.out.println("selectionner un ingredient");
				mettreDansContainer(((Assiette) materielAssemblage.objetsContenus.get(0)));
				materielAssemblage.objetsContenus.remove(0);
				emplacementAssiette.setImage(null);
				emplacementAssemblagePatate.setImage(null);
				emplacementAssemblageFromage.setImage(null);
				emplacementAssemblagePain.setImage(null);
				emplacementAssemblageOignon.setImage(null);
				emplacementAssemblageSalade.setImage(null);
				emplacementAssemblageSteak.setImage(null);
				emplacementAssemblageTomate.setImage(null);
			}
		} else if (container instanceof Assiette) {
			materielAssemblage.ajouterObjet(container);
			emplacementAssiette
					.setImage(new Image(getClass().getResourceAsStream(((Assiette) container).getImgAssiette())));
			viderContainer();
			System.out.println("assiette ajouté");
		} else if (container instanceof Ingredient) {
			Assiette assiette = (Assiette) materielAssemblage.objetsContenus.get(0);
			assiette.ajouterObjet((Ingredient) container);
			switch (((Ingredient) container).getNom()) {
			case PATATE:
				emplacementAssemblagePatate.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case FROMAGE:
				emplacementAssemblageFromage.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case PAIN:
				emplacementAssemblagePain.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case OIGNON:
				emplacementAssemblageOignon.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case SALADE:
				emplacementAssemblageSalade.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case STEAK_DE_BOEUF:
				emplacementAssemblageSteak.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case STEAK_DE_POULET:
				emplacementAssemblageSteak.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case STEAK_DE_SOJA:
				emplacementAssemblageSteak.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			case TOMATE:
				emplacementAssemblageTomate.setImage(
						new Image(getClass().getResourceAsStream(((Ingredient) container).getImgIngredient())));
				break;
			}
			System.out.println("ingredient ajouté à assiette :");
			for (int i = 0; i < assiette.objetsContenus.size(); i++) {
				System.out.print(((Ingredient) assiette.objetsContenus.get(i)).getNom() + " , " + "transformé ="
						+ ((Ingredient) assiette.objetsContenus.get(i)).getTransformer() + " , état ="
						+ ((Ingredient) assiette.objetsContenus.get(i)).getEtat() + " ; ");
			}
			viderContainer();
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
			containerView.setImage(new Image(getClass().getResourceAsStream(((Assiette) container).getImgAssiette())));
		}
	}

	public void viderContainer() {
		container = null;
		containerView.setImage(null);
	}



	public class tempsDuJeu extends TimerTask {

		private int temps = 180;
		// permet de ne pas envoyer tout les clients en même temps
		private int attenteEntreClient = 0;

		private int nbrClientEnvoye = 0;

		private ArrayList<Client> clientDuNiveau = Main.niveau1.getClients();

		private boolean enCours = true;

		public void setAttenteClient(int attente) {
			this.attenteEntreClient = attente;
			System.out.println(clientDuNiveau.size());
		}

		@Override
		public void run() {
			while (enCours) {
				
				for(int i = 0; i<clientDuNiveau.size();i++) {
					System.out.println("client du Niveau = " + clientDuNiveau.get(i).getCommande().getNom());
				}
				

				if (temps == 0 || nbrClientEnvoye == clientDuNiveau.size()) {
					this.enCours = false;
					System.out.println("Fin Du Niveau");
				}

				if (client1EnCours == null && attenteEntreClient == 0) {
					try {
						client1EnCours = envoyerUnClient(clientDuNiveau.get(nbrClientEnvoye), client1Progress);
						setAttenteClient(10);
						nbrClientEnvoye++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (client2EnCours == null && attenteEntreClient == 0) {
					try {
						client2EnCours = envoyerUnClient(clientDuNiveau.get(nbrClientEnvoye), client2Progress);
						setAttenteClient(10);
						nbrClientEnvoye++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (client3EnCours == null && attenteEntreClient == 0) {
					try {
						client3EnCours = envoyerUnClient(clientDuNiveau.get(nbrClientEnvoye), client3Progress);
						setAttenteClient(10);
						nbrClientEnvoye++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				String time = String.valueOf(temps);
				temps--;
				attenteEntreClient--;

				Platform.runLater(() -> {
					tempsEnCours.setText(time);
				});
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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

	public Service<Void> envoyerUnClient(Client client, ProgressBar progressClient) throws InterruptedException {

		Service<Void> ArriverClient = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {

						double temps = client.getTmpsAttente();

						progressClient.setProgress(1.0);
						progressClient.setStyle("-fx-accent: green;");
						for (double i = temps; i > 1; i--) {
							if (isCancelled()) {
								break;
							}
							progressClient.setProgress(progressClient.getProgress() - (1.0 / temps));
							Thread.sleep(1000);
							if (i < temps * 0.4) {
								progressClient.setStyle("-fx-accent: orange;");
							}
							if (i < temps * 0.2) {
								progressClient.setStyle("-fx-accent: red;");
							}
						}
						System.out.println("Le client est parti");
						return null;
					}
				};
			}
		};
		ArriverClient.start();
		return ArriverClient;
	}

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

		Timer timer = new Timer(true);
		timer.schedule(new tempsDuJeu(), 0, 1000);

	}
}