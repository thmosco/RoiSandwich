package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Commentaire de documentation de la classe
 * @version 1.0
 * @author Maïa DA SILVA
 */
public class Joueur {

    // Variables de classe

    // argent gagné par le joueur au fur et à mesure des parties
    private int argent ;

    // liste associant le niveau (key) et le score obtenu (value)
    private HashMap<Integer,Integer> scores ;

    // Constructeur
    public Joueur () {
        this.argent = 0 ;
        this.scores = new HashMap<Integer,Integer>() ;
    }

    /**
     * @return argent possédé par le joueur
     */
    public int getArgent() {
        return argent;
    }

    /**
     * @param niveau
     * @return liste des scores obtenus pour un niveau donné
     */
    public ArrayList<Integer> getScore(int niveau) {
        ArrayList scoreRecherche = new ArrayList<Integer>() ;
        Iterator iterator = this.scores.keySet().iterator() ;
        int compteur = 0 ;
        while (iterator.hasNext()) {
            if (iterator.next().equals(niveau)) {
                scoreRecherche.add(this.scores.get(iterator.next())) ;
            }
        }
        return scoreRecherche ;
    }

    /**
     * Permet d'ajouter l'argent gagné par le joueur à sa cagnotte
     * @param montant
     */
    public void setArgent (int montant) {
        this.argent += montant ;
    }

    /**
     * Permet d'ajouter un score à la liste des scores obtenus
     * @param niveau
     * @param score
     */
    public void setScores (int niveau, int score) {
        this.scores.put(niveau,score) ;
    }
}
