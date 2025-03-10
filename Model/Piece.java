
import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Piece {
    /**
    * Déclaration des attributs
    */
    public String titre;
    public String auteur;
    public int annee;
    public Vector<Repetition> listeRepet = new Vector<Repetition>();
    public Vector<Role> listeRole = new Vector<Role>();
    public Vector<Acte> listeActe = new Vector<Acte>();
    public Compagnie compagnie;

    /**
     * Déclarations des constructeurs
     */
    public Piece(String title, String writer, int year, Vector<Repetition> liste_rep, Vector<Role> liste_roles, Vector<Acte> liste_a, Compagnie c) {
      titre = title;
      auteur = writer;
      annee = year;
      listeRepet = liste_rep;
      listeRole = liste_roles;
      listeActe = liste_a;
      compagnie = c;
    }

    public Piece(String title, String writer, int year, Compagnie c) {
      titre = title;
      auteur = writer;
      annee = year;
      compagnie = c;
    }
}