package sample;


import classes.Niveau;
import classes.cuisine.Ingredient;
import classes.cuisine.Ingredient.Nom;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	Niveau niveau = new Niveau(1);
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("./niveau1.fxml"));
		primaryStage.setTitle("RoiSandwich");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        }

}
