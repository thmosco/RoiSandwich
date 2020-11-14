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

    public void ajouterObjet (Object objet) throws IllegalAccessException {
        if (this.objetsContenus.size() == this.capaciteMax) {
            throw new IllegalAccessException("plein");
        }
        this.objetsContenus.add(objet) ;
        System.out.println(objet.toString() + " ajouté");
    }
}