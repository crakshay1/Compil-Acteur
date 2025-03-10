import java.io.*;
import java.util.*;
import java.time.*;

/**
 * 
 */
public class Repetition {
    /**
     * Déclaration des attributs 
     */
    public String jour_de_la_semaine;
    public Vector<LocalDate> dates = new Vector<LocalDate>();
    public Vector<Scene> listeScenes=new Vector<Scene>();
    public Piece piece;
    public Vector<Acteur> listeActeurs = new Vector<Acteur>();
    public int id_rep;


    /**
    *Méthode pour choisir les jours de repetition en fonction des disponibilités des acteurs
    */
    // Le jour n'est pas imposé parmi les constructeurs, on choisit donc le jour le plus favorable pour tous
    public String choixjour(Vector<Acteur> liste_a, Vector<Scene> liste_s, Piece p){
      // Création de vecteurs des jours (chaque jour contient les id des acteurs qui y sont présents)
      Vector<Integer> lundi = new Vector<Integer>(); 
      Vector<Integer> mardi = new Vector<Integer>();
      Vector<Integer> mercredi = new Vector<Integer>();
      Vector<Integer> jeudi = new Vector<Integer>();
      Vector<Integer> vendredi = new Vector<Integer>();
      Vector<Integer> samedi = new Vector<Integer>();
      Vector<Integer> dimanche = new Vector<Integer>();
      for (int i = 0; i < liste_a.size(); i++) {
        if (liste_a.get(i).presences.contains("lundi"))
          lundi.add(liste_a.get(i).id);
        if (liste_a.get(i).presences.contains("mardi"))
          mardi.add(liste_a.get(i).id);
        if (liste_a.get(i).presences.contains("mercredi"))
          mercredi.add(liste_a.get(i).id);
        if (liste_a.get(i).presences.contains("jeudi"))
          jeudi.add(liste_a.get(i).id);
        if (liste_a.get(i).presences.contains("vendredi"))
          vendredi.add(liste_a.get(i).id);
        if (liste_a.get(i).presences.contains("samedi"))
          samedi.add(liste_a.get(i).id);
        if (liste_a.get(i).presences.contains("dimanche"))
          dimanche.add(liste_a.get(i).id);
        }
  
      // Création du vecteur stockant les vecteurs de chaque jour de la semaine
      Vector<Vector<Integer>> jours = new Vector<Vector<Integer>>(7);
      jours.add(lundi);
      jours.add(mardi);
      jours.add(mercredi);
      jours.add(jeudi);
      jours.add(vendredi);
      jours.add(samedi);
      jours.add(dimanche);
  
      // Si on a autant de monde tous les jours
      if (lundi.size() == mardi.size() && mardi.size() == mercredi.size() && mercredi.size() == jeudi.size() && jeudi.size() == vendredi.size() && vendredi.size() == samedi.size() && samedi.size() == dimanche.size()) {
        Random rand = new Random();
        int new_jour = rand.nextInt(7);
        Vector<Integer> jour_choisi = jours.get(new_jour);
      }
  
      // Ici on ne retient que le jour ayant le plus de monde
      int max = 0;
      int index_max = -1;
      for (int i = 0; i < jours.size(); i++) {
          Vector<Integer> jour_d = jours.get(i);
          if (jour_d.size() > max) {
              max = jour_d.size();
              index_max = i;
          }
      }
  
      // Pour voir le jour en question
      String jour_j = "";
      if (index_max == 0) { jour_j = "lundi";}
      if (index_max == 1) { jour_j = "mardi";}
      if (index_max == 2) { jour_j = "mercredi";}
      if (index_max == 3) { jour_j = "jeudi";}
      if (index_max == 4) { jour_j = "vendredi";}
      if (index_max == 5) { jour_j = "samedi";}
      if (index_max == 6) { jour_j = "dimanche";}
  
      // On essaye de voir quels acteurs jouent dans quelle(s) scène(s)
      Vector<Integer> liste_act_present = new Vector<Integer>();
      for (int scene = 0; scene < liste_s.size(); scene++) {
        for(int role = 0; role < liste_s.get(scene).texte.listeRole.size(); role++) {
            liste_act_present.add(p.compagnie.getActorIdByRole(liste_s.get(scene).texte.listeRole.get(role)));
          }
        // On maintient le jour mais on enlève les scènes incapables d'être jouées
        if (!liste_act_present.containsAll(jours.get(index_max))) {
          liste_s.remove(scene);
          }
        liste_act_present.clear();
        }
      if (liste_s.isEmpty()) {
        System.out.println("Malheureusement aucun créneau n'a pu être décidé en raison des indisponibilités des acteurs.");
      }
      else {
        System.out.println("Une répétition a été ajoutée !");
      }
      return jour_j;
      }
  
    /**
    *Méthode pour imposer les jours de repetition en fonction des disponibilités des acteurs
    */
    // Le jour est au préalable imposé dans les constructeurs, il faut donc juste enlever les scènes injouables.
    public Vector<Scene> choix_rep_scene(String jour, Vector<Acteur> liste_a, Vector<Scene> liste_s, Piece p) {
      Vector<Integer> jour_choisi = new Vector<Integer>();
      for (int i = 0; i < liste_a.size(); i++) {
        if (liste_a.get(i).presences.contains(jour))
          jour_choisi.add(liste_a.get(i).id);
      // On essaye de voir quels acteurs jouent dans quelle(s) scène(s)
      Vector<Integer> liste_act_present = new Vector<Integer>();
      for (int scene = 0; scene < liste_s.size(); scene++) {
        for(int role = 0; role < liste_s.get(scene).texte.listeRole.size(); role++) {
            liste_act_present.add(p.compagnie.getActorIdByRole(liste_s.get(scene).texte.listeRole.get(role)));
          }
        // On enlève les scènes incapables d'être jouées
        if (!liste_act_present.containsAll(jour_choisi)) {
          liste_s.remove(scene);
          }
        liste_act_present.clear();
        }
      }
      if (liste_s.isEmpty()) {
        System.out.println("Aucune scène ne peut être jouée le jour choisi, veuillez vérifier les disponibilités de vos acteurs.");
      }
      else {
        System.out.println("Une répétition a été ajoutée!");
      }
      return liste_s;
    }

    /**
    *Méthode pour fixer les dates de répétitions à chaque occurence des jours séléctionnés.
    */
    public Vector<LocalDate> fixer_dates(String jour, Vector<Scene> liste_s, Piece p) {
      if (liste_s.isEmpty()) {
        return null;
      } 
      else {
        int an = p.annee; // Année de référence
        DayOfWeek day = null;

        // On récupère les jours de la semaine sous leur vrai format
        if (jour.equals("lundi")) { day = DayOfWeek.MONDAY; }
        if (jour.equals("mardi")) { day = DayOfWeek.TUESDAY; }
        if (jour.equals("mercredi")) { day = DayOfWeek.WEDNESDAY; }
        if (jour.equals("jeudi")) { day = DayOfWeek.THURSDAY; }
        if (jour.equals("vendredi")) { day = DayOfWeek.FRIDAY; }
        if (jour.equals("samedi")) { day = DayOfWeek.SATURDAY; }
        if (jour.equals("dimanche")) { day = DayOfWeek.SUNDAY; }

        // On crée un vecteur de dates qui contiendra celles de chaque occurrence du jour séléctionné
        Vector<LocalDate> dates = new Vector<>();
        LocalDate debut_annee = LocalDate.of(an, 1, 1); // Date de départ : 1er janvier
        LocalDate fin_annee = LocalDate.of(an, 12, 31); // Date de fin : 31 décembre

        // On parcourt chaque jour de l'année, si le jour est le jour séléctionné, on ajoute la date correspondante à notre vecteur
        for (LocalDate i = debut_annee; !i.isAfter(fin_annee); i = i.plusDays(1)) {
            if (i.getDayOfWeek() == day) {
                dates.add(i);
            }
        }
        return dates;
      }
    }
      


    /**
     * Déclaration des constructeurs
     */
    public Repetition(Vector<Scene> liste_s, Piece p, Vector<Acteur> liste_a ) {
      jour_de_la_semaine = choixjour(liste_a,liste_s,p);
      dates = fixer_dates(jour_de_la_semaine,liste_s,p);
      listeScenes = liste_s;
      piece = p;
      id_rep = p.compagnie.genid_r(p.listeRepet);
    }
  
    public Repetition(String d, Vector<Scene> liste_s, Piece p, Vector<Acteur> liste_a ) {
      jour_de_la_semaine = d;
      listeScenes = choix_rep_scene(jour_de_la_semaine,liste_a,liste_s,p);
      dates = fixer_dates(jour_de_la_semaine, listeScenes, p);
      piece = p;
      id_rep = p.compagnie.genid_r(p.listeRepet);
    }
}