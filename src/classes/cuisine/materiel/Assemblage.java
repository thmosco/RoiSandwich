package classes.cuisine.materiel;

/**
 * Classe enfant de matériel, station recevant les assiettes afin d'assembler les commandes
 * @version 1.0
 * @author Maïa DA SILVA
 */
public class Assemblage extends Materiel {

    /**
     * Constructeur
     * @param capaciteMax
     */
    public Assemblage(int capaciteMax) {
        super(capaciteMax, 10);
    }

    // Méthodes

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe Matériel
     * Permet d'ajouter une assiette sur la station d'assemblage
     * @param assiette
     * @return true si l'assiette a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Assiette assiette) throws IllegalAccessException {
        return super.ajouterObjet(assiette) ;
    }

}
