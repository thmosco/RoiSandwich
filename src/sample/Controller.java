package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import classes.cuisine.Ingredient;
import classes.cuisine.Ingredient.Nom;

//test
public class Controller implements Initializable {
	@FXML
	Button buttonSalade;
	
	  public void salade(ActionEvent buttonSalade) {
      	Ingredient salade = new Ingredient(Nom.SALADE);
      	System.out.print(salade.getTransformer());
      }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
