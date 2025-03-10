
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Scene {
    /**
     * Déclaration des attributs
     */
    public int num;
    public Vector<Repetition> listeRepet = new Vector<Repetition>();
    public Acte acte;
    public Texte texte;
  
    /**
     * Déclarations des constructeurs
     */
  
    public Scene(int numero, Acte a, Texte t) {
      num = numero;
      acte = a;
      texte = t;
    }

    public Scene(int numero, Texte t){
      num = numero;
      acte = null;
      texte = t;
    }
    public Scene(int numero, Acte a){
          num = numero;
          acte = a;
          texte = null;
    }

}