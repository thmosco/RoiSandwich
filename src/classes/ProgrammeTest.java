package classes;
import classes.cuisine.*;

public class ProgrammeTest {

    public static void main(String[] args) throws IllegalAccessException {
        Assiette assiette = new Assiette(2, 5);
        Assiette assiette2 = new Assiette(2, 5);

        String fritte = "fritte";

        assiette.ajouterIngredient(fritte);
        assiette.ajouterIngredient(fritte);
        assiette.ajouterIngredient(fritte);
        assiette.ajouterIngredient(fritte);
//		assiette.ajouterIngredient(fritte);
//		assiette.ajouterIngredient(fritte);
//
//		Evier evier = new Evier(1, 10);
//
//		evier.ajouterIngredient(assiette);
//		evier.ajouterIngredient(assiette2);

    }
}
