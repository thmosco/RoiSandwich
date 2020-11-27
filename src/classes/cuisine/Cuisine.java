package classes.cuisine;
import classes.Niveau;
import classes.cuisine.materiel.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Commentaire de documentation de la classe
 * @version 1.0
 * @author Maïa DA SILVA
 */
public class Cuisine {

    // Variables de classe

    /**
     * liste des assiettes disponibles dans la cuisine
     */
    private ArrayList assiettes ;
    /**
     * liste des planches à découper disponibles dans la cuisine
     */
    private ArrayList planchesDecoupe ;
    /**
     * station d'assemblage disponible dans la cuisine
     */
    private Assemblage assemblage;
    /**
     * lave vaisselle disponible dans la cuisine
     */
    private LaveVaisselle laveVaisselle ;
    /**
     * liste des friteuses à découper disponibles dans la cuisine
     */
    private ArrayList friteuses ;
    /**
     * liste des plaques de cuisson à découper disponibles dans la cuisine
     */
    private ArrayList plaquesCuisson ;
    /**
     * poubelle disponible dans la cuisine
     */
    private Poubelle poubelle ;

    /**
     * Constructeur
     * @param niveau
     */
    public Cuisine (Niveau niveau) {
        // Création des assiettes dans la quantité indiquée par le niveau
        this.assiettes = new ArrayList<Assiette>() ;
        for (int i = 0 ; i < niveau.getNbAssietteMax() ; i++) {
           this.assiettes.add(new Assiette()) ;
        }
        // Création des outils
        Iterator iterator = niveau.getMateriel().keySet().iterator() ;
        while (iterator.hasNext()) {
            // Création des planches à découper dans la quantité indiquée par le niveau
            if (iterator.next() instanceof Decoupe) {
                this.planchesDecoupe = new ArrayList<Decoupe>() ;
                for (int i = 0 ; i < niveau.getMateriel().get(iterator.next()); i++) {
                    this.planchesDecoupe.add(new Decoupe()) ;
                }
            // Création de la station d'assemblage et définition de sa capacité max d'accueil (selon le niveau)
            } else if (iterator.next() instanceof Assemblage) {
                this.assemblage = new Assemblage(niveau.getMateriel().get(iterator.next())) ;
            // Création du lave vaisselle et définition de sa capacité max d'accueil (selon le niveau)
            } else if (iterator.next() instanceof LaveVaisselle) {
                this.laveVaisselle = new LaveVaisselle(niveau.getMateriel().get(iterator.next())) ;
            // Création des friteuses dans la quantité indiquée par le niveau
            } else if (iterator.next() instanceof Friteuse) {
                this.friteuses = new ArrayList<Friteuse>();
                for (int i = 0; i < niveau.getMateriel().get(iterator.next()); i++) {
                    this.friteuses.add(new Friteuse());
                }
            // Création des plaques de cuisson dans la quantité indiquée par le niveau
            } else if (iterator.next() instanceof PlaqueCuisson) {
                this.plaquesCuisson = new ArrayList<PlaqueCuisson>();
                for (int i = 0; i < niveau.getMateriel().get(iterator.next()); i++) {
                    this.plaquesCuisson.add(new PlaqueCuisson());
                }
            // Création de la poubelle
            } else if (iterator.next() instanceof Poubelle) {
                this.poubelle = new Poubelle() ;
            }
        }
    }
}
