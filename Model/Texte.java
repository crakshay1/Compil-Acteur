import java.io.*;
import java.util.*;

/**
 * 
 */
public class Texte {
    /**
     * Déclaration des attributs
     */
    public Vector<String> listeReplique = new Vector<String>();
    public Scene scene;
    public Vector<Role> listeRole = new Vector<Role>();

    /**
     * Déclaration des constructeurs
     */
    public Texte(String rep, Scene s, Role role){
      listeReplique.add(rep);
      if (!listeRole.contains(s.acte.piece.compagnie.getRoleByName(role.nom, s.acte.piece))){
        listeRole.add(role);
        role.listeReplique.add(this);
      } else {
        role.listeReplique.add(this);
      }
    }
    public Texte(Vector<String> rep, Scene s) {
      listeReplique = rep;
      scene = s;
    }
}