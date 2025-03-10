import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 */
public class Compagnie {
  /**
  * DÃ©claration des attributs 
  */
  public String nom;
  public Vector<Acteur> listeActeur = new Vector<Acteur>();
  public Vector<Piece> listePiece = new Vector<Piece>();

  /**
   * DÃ©claration des constructeurs
   */
  public Compagnie(String n) {
    nom = n;
  }

  /**
  * MÃ©thode pour ajouter un acteur Ã  la compagnie
  */
  public void ajoutActeur(Acteur a){
    listeActeur.add(a);
  }

  /**
  * MÃ©thode pour ajouter une piÃ¨ce Ã  la compagnie
  */
  public void ajoutPiece(Piece p){
    listePiece.add(p);
  }

  /**
  * MÃ©thode pour gÃ©nÃ©rer un id unique par acteur
  */
  public int genid(Vector<Acteur> listeActeur) { 
    Random rand = new Random();
    int new_id = rand.nextInt(9999) + 1;
    for (int i = 0; i < listeActeur.size(); i++) {
      if(listeActeur.get(i).id == new_id)
        new_id = rand.nextInt(9999) + 1;
    } 
    return new_id;
  }

  /**
  * MÃ©thode pour gÃ©nÃ©rer un id unique par rÃ©pÃ©tition
  */
  public int genid_r(Vector<Repetition> listeRep) { 
    Random rand = new Random();
    int new_id = rand.nextInt(9999) + 1;
    for (int i = 0; i < listeRep.size(); i++) {
      if(listeRep.get(i).id_rep == new_id)
        new_id = rand.nextInt(9999) + 1;
    } 
    return new_id;
  }

  /**
  * MÃ©thode pour rÃ©cupÃ©rer une piÃ¨ce en fonction de son titre
  */
  public Piece getPieceByTitle(String title) {
      for (Piece p : listePiece) {
          if (p.titre != null && p.titre.equals(title)) {
              return p;
          }
      }
      return null;
  }


  /**
  * MÃ©thode pour rÃ©cupÃ©rer un acte en fonction de son numÃ©ro d'ordre dans la piÃ¨ce
  */
  public Acte getActeByNum (int num, Piece p){
    for (int i = 0; i < p.listeActe.size(); i++) {
      if (num == p.listeActe.get(i).numero)
      {return p.listeActe.get(i); }
    }
    return null;
  }

  /**
  * MÃ©thode pour rÃ©cupÃ©rer une scÃ¨ne en fonction de son numÃ©ro d'ordre dans un acte
  */
  public Scene getSceneByNum (int num, Acte a){
    for (int i = 0; i < a.listeScenes.size(); i++) {
      if (num == a.listeScenes.get(i).num)
        return a.listeScenes.get(i); 
    }
    return null;
  }

  /**
  * MÃ©thode pour rÃ©cupÃ©rer l'id d'un acteur en fonction de son rÃ´le
  */
  public Integer getActorIdByRole (Role r){
    for (int i = 0; i < listeActeur.size(); i++){
      if (listeActeur.get(i).interpretations.contains(r)) {
        return listeActeur.get(i).id;
      }    
    }
    return null;
  }

  /**
  * MÃ©thode pour rÃ©cupÃ©rer un acteur par son id
  */
  public Acteur getActeurById (int a){
    for (int i = 0; i < listeActeur.size(); i++){
      if (a == listeActeur.get(i).id) {
        return listeActeur.get(i);    
      }
    }
    return null;
  }

  /**
  * MÃ©thode pour rÃ©cupÃ©rer un role par son nom
  */
  public Role getRoleByName(String name, Piece piece) {
      if (name == null || piece == null || piece.listeRole == null) {
          return null;
      }
      for (int i = 0; i < piece.listeRole.size(); i++) {
          if (name.equals(piece.listeRole.get(i).nom)) {
              return piece.listeRole.get(i);
          }
      }
      return null;
  }


  /**
  * MÃ©thode pour avoir les acteurs par leur noms
  */

  public Vector<Acteur> getActeurByName (String nom){
    Vector<Acteur> listeAct = new Vector<Acteur>();
    for (int i = 0; i < listeActeur.size(); i++){
      if (nom.equals(listeActeur.get(i).nom)) {
        listeAct.add(listeActeur.get(i)); 
      }   
    }
    return listeActeur;
  }

  /**
  * MÃ©thode pour ajouter des rÃ´les Ã  l'acteur
  */
  public void ajouter_role(int a, String p, String r) {
    Acteur act = getActeurById(a);
    Piece piece = getPieceByTitle(p);
    Role role = getRoleByName(r, piece);
    int indice = piece.listeRole.indexOf(role);
    act.interpretations.add(piece.listeRole.get(indice));
    role.joue = act;
  }  

  /**
  * MÃ©thode pour supprimer des scÃ¨nes a un acte
  */
  public void removeSceneActe(Piece p, Acte a, Scene s){
    if (p.listeActe.contains(a) && a.listeScenes.contains(s)) {
      int y = p.listeActe.indexOf(a);
      int i = a.listeScenes.indexOf(s);
      p.listeActe.get(y).listeScenes.remove(a.listeScenes.get(i));
    }
    else {
      System.out.println("L'acte ou la scÃ¨ne renseignÃ©e n'existe pas");
    }
  }

  /**
  * MÃ©thode pour ajouter les jours de la semaine oÃ¹ les acteurs sont disponibles
  */
  public void addJour(int a) {
      Acteur acteur = getActeurById(a);
      String[] jours = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
      System.out.println("Voici tous les jours de la semaine.");
      for (int i = 0; i < jours.length; i++) {
          System.out.println(i + ". " + jours[i]);
      }
      Scanner scanner = new Scanner(System.in);
      String choice = "_";
      while (!choice.equalsIgnoreCase("N")) {
          System.out.println("Voulez-vous ajouter un jour ? (O/N)");
          choice = scanner.next();
          if (choice.equalsIgnoreCase("N")) {
              break;
          } else if (choice.equalsIgnoreCase("O")) {
              System.out.println("Quel jour voulez-vous ajouter ? (Taper le numÃ©ro)");
              int jour = scanner.nextInt();
              if (jour >= 0 && jour < jours.length) {
                  acteur.presences.add(jours[jour]);
              } else {
                  System.out.println("NumÃ©ro de jour invalide. Veuillez rÃ©essayer.");
              }
          } else {
              System.out.println("Choix invalide. Veuillez taper O pour Oui ou N pour Non.");
          }
      }
  }

  /**
  * MÃ©thode pour enlever les jours de la semaine oÃ¹ les acteurs sont disponibles
  */
  public void removeJour(int a) {
    Acteur acteur = getActeurById(a);
    Scanner scanner = new Scanner(System.in);
    String choice = "_";
    while (!choice.equalsIgnoreCase("N")) {
      if (!acteur.presences.isEmpty()) {
        System.out.println("Voici tous les jours de la semaine lorsque l'acteur est disponible.");
        for (int i = 0; i < acteur.presences.size(); i++) {
          System.out.println(i + ". " + acteur.presences.get(i)); 
        }
        System.out.println("Voulez-vous retirer un jour ? (O/N)");
        choice = scanner.next();
        if (choice.equalsIgnoreCase("N")) {
              break;
        } else if (choice.equalsIgnoreCase("O")) {
            System.out.println("Quel jour voulez-vous retirer ? (Taper le numÃ©ro)");
            int jour = scanner.nextInt();
            if (acteur.presences.contains(acteur.presences.get(jour))) {
              acteur.presences.remove(acteur.presences.get(jour));
            } else {
              System.out.println("NumÃ©ro de jour invalide. Veuillez rÃ©essayer.");
            }
          } else {
              System.out.println("Choix invalide. Veuillez taper O pour Oui ou N pour Non.");
          }
      }
      else {
        System.out.println("Cet acteur ne joue pas.");
      }
    }
  }


    /**
     * MÃ©thode permettant de traiter le texte de thÃ©Ã¢tre rentrÃ© et intÃ¨gre toutes les informations de
     de celui-ci dans notre programme.
     */

  public void traitementTexte(File fichier, Piece piece) {
      Scanner scanner = null;
      try {
          scanner = new Scanner(fichier);
          String acteCourant = "";
          String sceneCourante = "";
          Acte acteEnCours = null;
          Scene sceneEnCours = null;

          while (scanner.hasNextLine()) {
              String ligne = scanner.nextLine();
              if (ligne.matches("^Acte [0-9]+$")) {
                  acteCourant = ligne.substring(5); 
                  int numeroActe = Integer.parseInt(acteCourant);
                  acteEnCours = new Acte(numeroActe, piece);
                  piece.listeActe.add(acteEnCours);
              } else if (ligne.matches("^Scene [0-9]+$")) {
                  sceneCourante = ligne.substring(6); 
                  int numeroScene = Integer.parseInt(sceneCourante);
                  sceneEnCours = new Scene(numeroScene, acteEnCours);
                  acteEnCours.listeScenes.add(sceneEnCours);
              } else if (ligne.matches("^[A-Z][A-Z]* :+[ *[A-Za-z.,!?;:'-]* *]*$")) {
                  if (sceneEnCours != null) {
                      String[] parts = ligne.split(":", 2);
                      String role = parts[0].trim();
                      String texte = parts[1].trim();
                      Role roleCourant = getRoleByName(role, piece);
                      if (roleCourant == null) {
                        Role roleNouveau = new Role(role, piece);
                        Texte Replique = new Texte(texte, sceneEnCours, roleNouveau);
                          //roleCourant = new Role(role, piece);
                          //piece.listeRole.add(roleCourant);
                      }
                        //sceneEnCours = new Scene(sceneEnCours.num, acteEnCours, texteReplique);
                      else {
                        Texte texteReplique = new Texte(texte, sceneEnCours, roleCourant);
                      }
                    Vector<String> full_texte = new Vector<String>();
                    full_texte.add(texte);
                    Texte fullReplique = new Texte(full_texte, sceneEnCours);
                    sceneEnCours.texte = fullReplique;
                  }
              }
          }
      } catch (FileNotFoundException e) {
          System.out.println("Le chemin du fichier est mauvais");
          e.printStackTrace();
      } finally {
          if (scanner != null) {
              scanner.close();
          }
      }
  }
}


