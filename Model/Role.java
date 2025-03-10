import java.io.*;

import java.util.*;

/**
 * 
 */
public class Role {
    /**
     * Déclaration des attributs 
     */
    public String nom;
    public Acteur joue;
    public Piece piece;
    public Vector<Texte> listeReplique = new Vector<Texte>(); 
  
    /**
     * Déclaration des constructeurs
     */
    public Role(String name, Acteur interprete, Piece p, Vector<Texte> listeRepliques) {
      nom = name;
      joue = interprete;
      piece = p;
      listeReplique = listeRepliques;
    }
  
    public Role(String name, Piece p, Vector<Texte> listeRepliques) {
      nom = name;
      joue = null;
      piece = p;
      listeReplique = listeRepliques;
    }

    public Role(String name, Piece p){
      nom = name;
      joue = null;
      piece = p;
    }

    public Role(String name, Acteur a, Piece p){
      nom = name;
      joue = a;
      piece = p;
    }
  
}