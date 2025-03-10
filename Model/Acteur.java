import java.io.*;
import java.util.*;

/**
 * 
 */
public class Acteur {
    /**
    * Déclaration des attributs
    */
  
    public String nom;
    public int id;
    public Vector<String> presences = new Vector<String>();
    public Vector<Role> interpretations = new Vector<Role>();
    public Compagnie compagnie;


    /**
     * Déclaration des constructeurs
     */
  
    public Acteur(String x, int y, Compagnie c) {
      nom = x;
      id = y;
      compagnie = c;
    }

    public Acteur(String x, Compagnie c) {
      nom = x;
      id = c.genid(c.listeActeur);
      compagnie = c;
    }

    /**
    * Méthode pour afficher les rôles d'un acteur
    */
   public void afficheRole(){
     for (int i = 0; i < this.interpretations.size(); i++){
       System.out.println("- " + this.interpretations.get(i).piece.titre + " : " + this.interpretations.get(i).nom + ";");
     }
   }

    /**
    * Méthode pour afficher les présences d'un acteur
    */
    public void affichePresence(){
      for (int i = 0; i < this.presences.size(); i++){
        System.out.println("- " + this.presences.get(i) + ";");
      }
    }
} 