package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Joueur {

    private int argent ;
    private HashMap<Integer,Integer> scores ;

    public Joueur () {
        this.argent = 0 ;
        this.scores = new HashMap<Integer,Integer>() ;
    }

    public int getArgent() {
        return argent;
    }

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

    public void setArgent (int montant) {
        this.argent += montant ;
    }

    public void setScores (int niveau, int score) {
        this.scores.put(niveau,score) ;
    }
}
