package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import classes.cuisine.Ingredient;
import classes.cuisine.Ingredient.Nom;

//test
public class Controller implements Initializable {
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
	
	  public void salade(MouseEvent event) {
      	Ingredient salade = new Ingredient(Nom.SALADE);
      	System.out.print(salade.getTransformer());
      }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
