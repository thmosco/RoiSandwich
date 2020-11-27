package classes.cuisine.materiel;

/**
 * Classe enfant de matériel, station recevant les assiettes afin d'assembler les commandes
 * @version 1.0
 * @author Maïa DA SILVA
 */
public class Assemblage extends Materiel {

    // Constructeur 
    public Assemblage(int capaciteMax) {
        super(capaciteMax, 10);
    }

    public boolean ajouterObjet (Assiette assiette) throws IllegalAccessException {
        return super.ajouterObjet(assiette) ;
    }

}
