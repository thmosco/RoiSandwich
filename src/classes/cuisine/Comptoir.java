package classes.cuisine;

import classes.cuisine.materiel.Assiette;
import java.util.HashMap;

/**
 * Comptoir qui accueille jusqu'à 3 clients et leur commande
 * @version 2.0
 * @author Maïa DA SILVA
 */
public class Comptoir {

    // Variables de classes

    /**
     * liste représentant le comptoir
     */
    private HashMap<Client, Assiette> comptoir ;

    /**
     * Constructeur
     */
    public Comptoir () {
        this.comptoir = new HashMap<Client,Assiette>() ;
    }

    /**
     * Ajouter un client au comptoir, par définition il n'est pas servit lorsqu'il arrive
     * @param client
     */
    public void addClient (Client client) {
        if (this.comptoir.size() == 3) {
            //exception
        }
        this.comptoir.put(client,null) ;
    }

}
