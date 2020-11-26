package classes.cuisine.materiel;

import classes.Recette;

/**
 * Classe enfant de matériel, contient des assiettes sale
 * @version 1.0
 * @author Mickeal PIRRES
 *
 * @version 2.0
 * @author Maïa DA SILVA
 */
public class LaveVaisselle extends Materiel {

    /**
     * Constructeur
     * @param capaciteMax
     */
    public LaveVaisselle(int capaciteMax) {
        super(capaciteMax, 10);
    }

    // Méthodes

    /**
     * @Override méthode ajouterObjet(Objet objet) de la classe Matériel
     * Permet d'ajouter une assiette dans l'evier
     * @param assiette
     * @return true si l'assiette a bien été ajouté
     * @throws IllegalAccessException
     */
    public boolean ajouterObjet (Assiette assiette) throws IllegalAccessException {
        return super.ajouterObjet(assiette);
    }

    /**
     * Permet de nettoyer l'ensemble des objets placés dans le lave vaisselle
     * @return true si la méthode a bien été effectuée
     */
    public boolean nettoyer() {
        Assiette assiette ;
        // Pour chaque assiette, on vide le contenu
        for (int i = 0 ; i < this.objetsContenus.size() ; i++) {
            assiette = (Assiette) this.objetsContenus.get(i) ;
            assiette.objetsContenus.clear() ;
        }
        return true ;
    }
}