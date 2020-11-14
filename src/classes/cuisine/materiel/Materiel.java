package classes.cuisine.materiel;

import java.util.ArrayList;

public class Materiel {

    private int capaciteMax ;
    private int tempsExecution;
    private ArrayList objetsContenus;

    public Materiel(int capaciteMax, int tempsExecution) {
        this.capaciteMax = capaciteMax ;
        this.tempsExecution = tempsExecution;
        objetsContenus = new ArrayList();
    }

    /**
     * Permet de placer un objet dans un matériel
     * @param objet
     * @throws IllegalAccessException
     * @version 2.0
     */
    public void ajouterObjet (Object objet) throws IllegalAccessException {
        if (this.objetsContenus.size() == this.capaciteMax) {
            throw new IllegalAccessException("plein");
        }
        this.objetsContenus.add(objet) ;
        System.out.println(objet.toString() + " ajouté");
    }
}