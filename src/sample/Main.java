package sample;


import classes.Niveau;
import classes.cuisine.Ingredient;
import classes.cuisine.Ingredient.Nom;

import classes.cuisine.materiel.Decoupe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static Niveau niveau1;

    @Override
    public void start(Stage primaryStage) throws Exception{

//    	Parent root = FXMLLoader.load(getClass().getResource("niveau1.fxml"));
    	Parent root = FXMLLoader.load(getClass().getResource("vueNiveau1.fxml"));
    	
    	niveau1 = new Niveau(1);
		primaryStage.setTitle("RoiSandwich");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        }

}



