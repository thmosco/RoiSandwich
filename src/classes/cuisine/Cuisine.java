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

    /**
     * Constructeur
     * @param niveau
     */
    public Cuisine (Niveau niveau) {
        ArrayList assiettes = new ArrayList<Assiette>() ;
        for (int i = 0 ; i < niveau.getNbAssietteMax() ; i++) {
           //assiettes.add(new Assiette()) ;
        }
        Iterator iterator = niveau.getMateriel().keySet().iterator() ;
        while (iterator.hasNext()) {
            if (iterator.next() instanceof Decoupe) {
                ArrayList decoupes = new ArrayList<Decoupe>() ;
                for (int i = 0 ; i < niveau.getMateriel().get(iterator.next()); i++) {
                    //decoupes.add(new Decoupe()) ;
                }
            } else if (iterator.next() instanceof Evier) {
                ArrayList eviers = new ArrayList<Evier>() ;
                for (int i = 0 ; i < niveau.getMateriel().get(iterator.next()); i++) {
                    //eviers.add(new Evier()) ;
                }
            } else if (iterator.next() instanceof Friteuse) {
                ArrayList friteuses = new ArrayList<Friteuse>();
                for (int i = 0; i < niveau.getMateriel().get(iterator.next()); i++) {
                    //friteuses.add(new Friteuse());
                }
            } else if (iterator.next() instanceof PlaqueCuisson) {
                ArrayList plaques = new ArrayList<PlaqueCuisson>();
                for (int i = 0; i < niveau.getMateriel().get(iterator.next()); i++) {
                    //plaques.add(new PlaqueCuisson());
                }
            } else if (iterator.next() instanceof Poubelle) {
                ArrayList poubelles = new ArrayList<Poubelle>();
                for (int i = 0; i < niveau.getMateriel().get(iterator.next()); i++) {
                    //poubelles.add(new Poubelle());
                }
            }
        }
    }
}
