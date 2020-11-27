package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.sun.prism.paint.Color;

import classes.Niveau;
import classes.cuisine.Ingredient;
import classes.cuisine.Ingredient.Nom;
import classes.cuisine.materiel.Decoupe;

//test
public class Controller implements Initializable {

//	private static HashMap<Label, Ingredient> container = new HashMap<Label, Ingredient>();
	private static String container;
	private Decoupe decoupe = new Decoupe();
	private Ingredient pomme_De_Terre = new Ingredient(Nom.POMME_DE_TERRE);

	
	@FXML
	Label plancheADecoupe;
	@FXML
	Label cuisson;
	@FXML
	Label assemblage;
	@FXML
	Label evier;
	@FXML
	Label patate;

	@FXML
	public void clickIngredient(MouseEvent e) {

		if (e.getSource() == patate) {
			if (patate.getStyle().equals("-fx-background-color: blue;")) {
				patate.setStyle("-fx-background-color: yellow");
				container = e.getSource().toString();
//				container.clear();
				System.out.println("container = " + container);
				System.out.println("container vide");
			} else {
				patate.setStyle("-fx-background-color: blue;");
				container = "";
//				container.put((Label) e.getSource(),pomme_De_Terre);
				System.out.println("container = " + container);
				System.out.println("ajouté à containter ");
			}
		}
	}

	@FXML
	public void clickMateriel(MouseEvent e) {
		
//		System.out.println("test " + container.get(0));

		if (e.getSource() == plancheADecoupe) {
			System.out.println(plancheADecoupe.getStyle());
			if (plancheADecoupe.getStyle().equals("-fx-background-color: green;")) {

				try {
					plancheADecoupe.setStyle("-fx-background-color: red;");
					patate.setStyle("-fx-background-color: yellow;");

					System.out.println("etat transformé avant " + pomme_De_Terre.getTransformer());
					decoupe.ajouterObjet(pomme_De_Terre);
					System.out.println("ajouté dans planche à découpe");
					System.out.println("etat de l'ingredient =" + pomme_De_Terre.getEtat());
					System.out.println("etat transformé apres " + pomme_De_Terre.getTransformer());
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		if (e.getSource() == cuisson) {
			System.out.println(cuisson.getStyle());
			if (plancheADecoupe.getStyle().equals("-fx-background-color: green;")) {

			}
		}
	}

	@FXML
	public void clickAssemblage(MouseEvent e) {
		if (decoupe.objetsContenus.size() != 1) {

		}

	}

//	@FXML
//	private void HandleDragDetection(MouseEvent e) {
//		Dragboard db = boeuf.startDragAndDrop(TransferMode.ANY);
//
//		ClipboardContent cb = new ClipboardContent();
////		cb.put(Label, boeuf);
//		cb.putString(boeuf.getText());
//
//		db.setContent(cb);
//
//		e.consume();
//	}
//
//	@FXML
//	private void handleTextDragOver(DragEvent e) {
//		if (e.getDragboard().hasString()) {
//			e.acceptTransferModes(TransferMode.ANY);
//		}
//	}
//
//	@FXML
//	private void handleTextDrop(DragEvent e) {
//		String str = e.getDragboard().getString();
//		plancheADecoupe.setText(str);
//
//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
