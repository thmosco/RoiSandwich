package classes;

public class Niveau {

    private int numNiveau ;
    private static final int DUREE = 180000 ;
    private int[] tabScoreArgent ;
    private Client[] clients ;
    private ArrayList<NomRecette> listeRecettes ;
    private HashMap<Materiel,Integer> materiel ;
    private HashMap<Ingredient,Integer> ingredient ;
    private int nbAssietteMax ;

    public Niveau(int numNiveau) {
        this.numNiveau = numNiveau;
        this.tabScoreArgent = new int [2];

        switch (this.numNiveau) {
            case 1 :
                this.nbAssietteMax = null ;
                this.clients = new Client[25] ;

                this.ingredient = null ;

                this.materiel = new HashMap<Materiel,Integer>() ;
                this.materiel.put(new Evier(),1) ;
                this.materiel.put(new Decoupe(),1) ;
                this.materiel.put(new PlaqueCuisson(),1) ;
                this.materiel.put(new Poubelle(),1) ;

                break ;

            case 2 :
                this.nbAssietteMax = 9 ;
                this.clients = new Client[50] ;

                this.ingredient = null ;

                this.materiel = new HashMap<Materiel,Integer>() ;
                this.materiel.put(new Evier(),1) ;
                this.materiel.put(new Decoupe(),1) ;
                this.materiel.put(new PlaqueCuisson(),1) ;
                this.materiel.put(new Poubelle(),1) ;

                break ;

            case 3 :
                this.nbAssietteMax = 6 ;
                this.clients = new Client[75] ;

                this.ingredient = null ;

                this.materiel = new HashMap<Materiel,Integer>() ;
                this.materiel.put(new Evier(),1) ;
                this.materiel.put(new Decoupe(),1) ;
                this.materiel.put(new PlaqueCuisson(),1) ;
                this.materiel.put(new Poubelle(),1) ;
        }
    }

    public void creerClients () {
        for (int i = 0 ; i < this.clients.length ; i++) {
            for (int j = 0 ; i < this.listeRecettes.size() ; j++) {
                this.clients[i] = new Client () ;
            }
        }
    }

    public void setScoreArgent (int score, int argent) {
        this.tabScoreArgent[1] = score ;
        this.tabScoreArgent[2] = argent ;
    }

}
