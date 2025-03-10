import java.io.*;
import java.util.*;

/**
 * 
 */
public class Acte {
    /**
    * Déclaration des attributs
    */

    public int numero;
    public Piece piece;
    public Vector<Scene> listeScenes = new Vector<Scene>();

    /**
     * Déclaration des constructeurs
     */

    public Acte(int n, Piece p, Vector<Scene> liste_s) {
      numero = n;
      piece = p;
      listeScenes = liste_s;
    }

    public Acte(int n, Piece p){
      numero = n;
      piece = p;
    }

} 