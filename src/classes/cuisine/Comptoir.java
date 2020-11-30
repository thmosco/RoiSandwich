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

    // Méthodes

    /**
     * Ajouter un client au comptoir, par définition il n'est pas servit lorsqu'il arrive
     * @param client
     * @return true si le client a bien été ajouté
     */
    public boolean ajouterClient(Client client) {
        if (this.comptoir.size() >= 3) {
            //exception
            return false ;
        }
        this.comptoir.put(client,null) ;
        return true ;
    }

    /**
     * Permet de servir une assiette à un client du comptoir
     * @param client
     * @param assiette
     * @return true si le client a été servit
     */
    public boolean servirClient (Client client, Assiette assiette) {
        if (this.comptoir.get(client) != null ) {
            // client déjà servit
            return false ;
        }
        this.comptoir.replace(client,assiette) ;
        return true ;
    }

    /**
     * Retirer un client du comptoir
     * @param client
     * @return true si le client a bien été retirer
     */
    public boolean retirerClient (Client client) {
        this.comptoir.remove(client);
        return true ;
    }

}
