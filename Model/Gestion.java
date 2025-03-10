import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Gestion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Compagnie compagnie = null;

        while (compagnie == null) {
            System.out.println("Bienvenue");
            System.out.println("Avant de commencer, veuillez entrer le nom de la compagnie :");
            compagnie = new Compagnie(scanner.nextLine());
        }

        String choice = "0";
        while (choice != "5") {
            Boolean breakWhile = false;
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("------- Menu Principal -------");
            System.out.println("1. Fonctionnalités liées aux acteurs");
            System.out.println("2. Fonctionnalités liées aux pièces de théâtre");
            System.out.println("3. Fonctionnalités liées aux rôles");
            System.out.println("4. Fonctionnalités liées aux répétitions");
            System.out.println("5. Quitter");
            System.out.println(" ");
            System.out.print("Sélectionnez votre choix: ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    String choix = "0";
                    while (choix != "6") {
                        Boolean breakWhile2 = false;
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("------- Menu: Acteur -------");
                        System.out.println("1. Ajouter un acteur");
                        System.out.println("2. Supprimer un acteur");
                        System.out.println("3. Afficher les informations d'un acteur grâce à son nom");
                        System.out.println("4. Afficher les informations d'un acteur grâce à son id");
                        System.out.println("5. Ajouter un jour de présence");
                        System.out.println("6. Supprimer un jour de présence");
                        System.out.println("7. Quitter");
                        System.out.println(" ");
                        System.out.print("Sélectionnez votre choix: ");
                        choix = scanner.next();

                        switch (choix) {
                            case "1":
                                // Ajouter un acteur
                                Scanner scanner2 = new Scanner(System.in);
                                System.out.println("Entrez le nom de l'acteur: ");
                                String nomActeur = scanner2.nextLine();
                                Acteur nouvelActeur = new Acteur(nomActeur, compagnie);
                                compagnie.listeActeur.add(nouvelActeur);
                                System.out.println("L'acteur " + nomActeur + " a été ajouté avec succès!");
                                breakWhile2 = true;
                                break;

                            case "2":
                                // Supprimer un acteur
                                Scanner scanner22 = new Scanner(System.in);
                                System.out.println("Entrez l'id de l'acteur: ");
                                int nouvelActeur2 = scanner22.nextInt();
                                Acteur a = compagnie.getActeurById(nouvelActeur2);
                                if (a!= null) {
                                    System.out.println("L'acteur " + a.nom + " a été retiré avec succès!");
                                    compagnie.listeActeur.remove(a);
                                }
                                else {
                                    System.out.println("L'acteur n'existe pas.");
                                }
                                breakWhile2 = true;
                                break;
                                
                            case "3":
                                // afficher les informations d'un acteur par son nom
                                Scanner scanner3 = new Scanner(System.in);
                                System.out.println("Entrez le nom de l'acteur : ");
                                String nomActeurRecherche = scanner3.nextLine();
                                Vector<Acteur> acteursTrouves = compagnie.getActeurByName(nomActeurRecherche);
                                if (acteursTrouves.isEmpty()) {
                                    System.out.println("Aucun acteur trouvé avec le nom " + nomActeurRecherche);
                                } else {
                                    for (Acteur act : acteursTrouves) {
                                        System.out.println("Informations de l'acteur:");
                                        System.out.println("Nom: " + act.nom);
                                        System.out.println("Id: " + act.id);
                                        System.out.println("Compagnie: " + act.compagnie.nom);
                                        System.out.println("Rôles:");
                                        act.afficheRole();
                                        System.out.println("Présence:");
                                        act.affichePresence();
                                    }
                                }
                                breakWhile2 = true;
                                break;
                                
                            case "4":
                                // afficher les informations d'un acteur par son id
                                System.out.println("Entrez l'id de l'acteur : ");
                                int idActeurRecherche = scanner.nextInt();
                                Acteur acteurTrouve = compagnie.getActeurById(idActeurRecherche);
                                if (acteurTrouve == null){
                                    System.out.println("Aucun acteur trouvé avec l'id " + idActeurRecherche);
                                } else {
                                    System.out.println("Informations de l'acteur:");
                                    System.out.println("Nom: " + acteurTrouve.nom);
                                    System.out.println("Id: " + acteurTrouve.id);
                                    System.out.println("Compagnie: " + acteurTrouve.compagnie.nom);
                                    System.out.println("Rôles:");
                                    acteurTrouve.afficheRole();
                                    System.out.println("Présence:");
                                    acteurTrouve.affichePresence();
                                }
                                breakWhile2 = true;
                                break;
                                
                            case "5":
                                // ajouter une présence
                                System.out.print("Entrez l'ID de l'acteur : ");
                                int idActeur = scanner.nextInt();
                                compagnie.addJour(idActeur);
                                System.out.println("Une présence a été ajoutée");
                                breakWhile2 = true;
                                break;

                            case "6":
                                // supprimer une présence
                                System.out.print("Entrez l'ID de l'acteur : ");
                                int idActeurSuppr = scanner.nextInt();
                                compagnie.removeJour(idActeurSuppr);
                                System.out.println("Une présence a été supprimée");
                                breakWhile2 = true;
                                break;

                            case "7":
                                // quitter
                                System.out.println("Retour au menu principal");
                                breakWhile2 = true;
                                break;
                                
                            default:
                                System.out.println("Choix invalide. Veuillez réessayer.");
                                breakWhile2 = true;
                                break;
                            }
                        if (breakWhile2) {break;}
                    }
                    break;
                
                case "2":
                    // Ajouter fonctionnalité pièce de théâtre
                    String choix2 = "0";
                    while (choix2 != "8"){
                        Boolean breakWhile3 = false;
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("------- Menu: Pièce de théâtre -------");
                        System.out.println("1. Ajouter une pièce de théâtre");
                        System.out.println("2. Supprimer une pièce de théâtre");
                        System.out.println("3. Afficher les pièces de théâtre de la compagnie");
                        System.out.println("4. Afficher les informations d'une pièce de théâtre");
                        System.out.println("5. Ajouter une scène");
                        System.out.println("6. Supprimer une scène");
                        System.out.println("7. Ajouter un acte");
                        System.out.println("8. Supprimer un acte");
                        System.out.println("9. Afficher les scènes d'une pièce de théâtre");
                        System.out.println("10. Quitter");
                        System.out.println(" ");
                        System.out.print("Sélectionnez votre choix: ");
                        choix2 = scanner.next();

                        switch (choix2){
                            case "1":
                                // Ajouter une pièce de théâtre
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner4 = new Scanner(System.in);
                                String titre = scanner4.nextLine();
                                System.out.print("Entrez l'auteur de la pièce : ");
                                Scanner scanner5 = new Scanner(System.in);
                                String auteur = scanner5.nextLine();
                                System.out.print("Entrez l'année d'interprétation de la pièce : ");
                                int annee = scanner.nextInt();
                                System.out.println("Entrez le fichier texte de la pièce (Spécifiez le chemin) : ");
                                Scanner scanner6 = new Scanner(System.in);
                                String chemin = scanner6.nextLine();
                                File texte_p = new File(chemin);
                                Piece p = new Piece(titre, auteur, annee, compagnie);
                                compagnie.traitementTexte(texte_p,p);
                                compagnie.listePiece.add(p);
                                System.out.println(" ");
                                System.out.println("La pièce de théâtre a été ajoutée avec succès!");
                                breakWhile3 = true;
                                break;

                            case "2":
                                // Supprimer une pièce de théâtre
                                System.out.print("Entrez le titre de la pièce à supprimer : ");
                                Scanner scanner45 = new Scanner(System.in);
                                String titre_p_s = scanner45.nextLine();
                                Piece p_s = compagnie.getPieceByTitle(titre_p_s);
                                if (p_s == null) {
                                    System.out.println("La pièce de théâtre renseignée n'existe pas");
                                }
                                else {
                                    compagnie.listePiece.remove(p_s);
                                    System.out.println("La pièce de théâtre a été supprimée avec succès!");
                                }
                                breakWhile3 = true;
                                break;
                                
                            case "3":
                                // Afficher les pièces de théâtre de la compagnie
                                System.out.println("Voici la liste des pièces de théâtre de la compagnie :");
                                for (Piece p_a : compagnie.listePiece) {
                                    System.out.println("- " + p_a.titre + " de " + p_a.auteur);
                                }
                                breakWhile3 = true;
                                break;
                                
                            case "4":
                                // Afficher les informations d'une pièce de théâtre
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner7 = new Scanner(System.in);
                                String titreRecherche = scanner7.nextLine();
                                Piece piece_trouvee = compagnie.getPieceByTitle(titreRecherche);
                                if (piece_trouvee == null) {
                                    System.out.println("Aucune pièce trouvée avec le titre " + titreRecherche);
                                }
                                else {
                                    System.out.println("Informations de la pièce de théâtre:");
                                    System.out.println("Titre: " + piece_trouvee.titre);
                                    System.out.println("Auteur: " + piece_trouvee.auteur);
                                    System.out.println("Année d'interprétation: " + piece_trouvee.annee);
                                }
                                breakWhile3 = true;
                                break;

                            case "5":
                                // Ajouter une scène
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner8 = new Scanner(System.in);
                                String titre_piece = scanner8.nextLine();
                                System.out.print("Entrez le numéro de l'acte dans la pièce: ");
                                int titreActe = scanner.nextInt();
                                System.out.print("Entrez le numéro de la scène : ");
                                int ordreScene = scanner.nextInt();
                                Piece pi = compagnie.getPieceByTitle(titre_piece);
                                if (pi == null) {System.out.println("La pièce de théâtre n'existe pas");}
                                else
                                {
                                    Acte a = compagnie.getActeByNum(titreActe, pi);
                                    if (a == null) {a = new Acte(titreActe, pi); pi.listeActe.add(a);}
                                    Scene s = new Scene(ordreScene, a);
                                    a.listeScenes.add(s);
                                    System.out.println("La scène a été ajoutée avec succès!");
                                    System.out.println("Souhaitez-vous y ajouter du texte? (O/N)");
                                    Scanner scanner89 = new Scanner(System.in);
                                    String choix_texte = scanner89.nextLine();
                                    if (choix_texte.equalsIgnoreCase("O"))
                                    {
                                        System.out.println("Entrez le texte de la scène : ");
                                        Scanner scanner99 = new Scanner(System.in);
                                        String texte_scene = scanner99.nextLine();
                                        String[] lignes = texte_scene.split("\n");
                                        Vector<String> listeRepliques = new Vector<String>();
                                        for (String ligne : lignes) {
                                            listeRepliques.add(ligne);
                                        }
                                        Texte t = new Texte(listeRepliques, s);
                                        s.texte = t;
                                    }
                                }

                                breakWhile3 = true;
                                break;

                            case "6":
                                // Supprimer une scène
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner9 = new Scanner(System.in);
                                String titre_p = scanner9.nextLine();
                                System.out.print("Entrez le numéro de l'acte dans laquelle se trouve la scène: ");
                                int titre_a = scanner.nextInt();
                                System.out.print("Entrez le numéro de la scène : ");
                                int ordre_s = scanner.nextInt();
                                Piece p_suppr = compagnie.getPieceByTitle(titre_p);
                                Acte a_suppr = compagnie.getActeByNum(titre_a, p_suppr);
                                Scene s_suppr = compagnie.getSceneByNum(ordre_s, a_suppr);
                                compagnie.removeSceneActe(p_suppr, a_suppr, s_suppr);
                                System.out.println("La scène a été supprimée avec succès!");
                                breakWhile3 = true;
                                break;

                            case "7":
                                // Ajouter un acte
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner10 = new Scanner(System.in);
                                String titre_de_la_piece = scanner10.nextLine();
                                System.out.println("Entrez le numéro de l'acte: ");
                                int titre_acte = scanner.nextInt();
                                Piece piece_ajoute = compagnie.getPieceByTitle(titre_de_la_piece);
                                if (piece_ajoute == null) {System.out.println("Aucune pièce trouvée avec le titre " + titre_de_la_piece);}
                                else {
                                    Acte new_act = new Acte(titre_acte, piece_ajoute);
                                    piece_ajoute.listeActe.add(new_act);
                                    System.out.println("L'acte a été ajouté avec succès!");
                                }
                                breakWhile3 = true;
                                break;

                            case "8":
                                // Supprimer un acte
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner11 = new Scanner(System.in);
                                String titre_piece_suppr = scanner11.nextLine();
                                System.out.println("Entrez le numéro de l'acte : ");
                                int titre_acte_suppr = scanner.nextInt();
                                Piece piece_suppr = compagnie.getPieceByTitle(titre_piece_suppr);
                                Acte acte_suppr = compagnie.getActeByNum(titre_acte_suppr, piece_suppr);
                                if (piece_suppr == null || acte_suppr == null) {System.out.println("Aucune pièce ou acte trouvée");}
                                else
                                {
                                piece_suppr.listeActe.remove(acte_suppr);
                                System.out.println("L'acte a été supprimé avec succès!");
                                }
                                breakWhile3 = true;
                                break;

                            case "9":
                                // Afficher les scènes d'une pièce de théâtre
                                System.out.println("Entrez le titre de la pièce : ");
                                Scanner scanner12 = new Scanner(System.in);
                                String titre_piece_aff = scanner12.nextLine();
                                Piece piece_aff = compagnie.getPieceByTitle(titre_piece_aff);
                                if (piece_aff == null) {System.out.println("Aucune pièce trouvée avec le titre " + titre_piece_aff);}
                                else
                                {
                                    System.out.println("Scènes de la pièce de théâtre :");
                                    for (int i=0; i<piece_aff.listeActe.size(); i++) {
                                        System.out.println(" ");
                                        System.out.println("Acte " + piece_aff.listeActe.get(i).numero + ":");
                                        for (int j=0; j<piece_aff.listeActe.get(i).listeScenes.size(); j++) {
                                            System.out.println("Scène " + piece_aff.listeActe.get(i).listeScenes.get(j).num + ":");
                                            for (String replique : piece_aff.listeActe.get(i).listeScenes.get(j).texte.listeReplique) {
                                                        System.out.println(replique);
                                                    }
                                                }
                                    }
                                }
                                breakWhile3 = true;
                                break;

                            case "10":
                                // Quitter
                                System.out.println("Retour au menu principal");
                                breakWhile3 = true;
                                break;

                            default:
                                System.out.println("Choix invalide. Veuillez réessayer.");
                                breakWhile3 = true;
                                break;
                            }
                            if (breakWhile3) {break;}
                        }
                        break;
                    
                case "3":
                    // Ajouter fonctionnalité rôle
                    String choix3 = "0";
                    while (choix3 != "6"){
                        Boolean breakWhile4 = false;
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("------- Menu: Rôles -------");
                        System.out.println("1. Ajouter un rôle");
                        System.out.println("2. Supprimer un rôle");  
                        System.out.println("3. Afficher les rôles dans une pièce");
                        System.out.println("4. Rechercher un rôle");
                        System.out.println("5. Afficher les rôles joués par un acteur");
                        System.out.println("6. Quitter");
                        System.out.println(" ");
                        System.out.print("Sélectionnez votre choix: ");
                        choix3 = scanner.next();
                        switch (choix3) {
                            case "1":
                                // Ajouter un rôle
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner13 = new Scanner(System.in);
                                String titre_piece = scanner13.nextLine();
                                Piece p = compagnie.getPieceByTitle(titre_piece);
                                if (p == null) {System.out.print("Aucun rôle ne peut être ajouté car la pièce n'existe pas"); break;}
                                else {
                                    System.out.print("Entrez le nom du rôle : ");
                                    Scanner scanner14 = new Scanner(System.in);
                                    String nom_role = scanner14.nextLine();
                                    System.out.print("Voulez-vous assigner ce rôle à un acteur ? (O/N) : ");
                                    Scanner scanner15 = new Scanner(System.in);
                                    String choix_acteur = scanner15.nextLine();
                                    if (choix_acteur.equalsIgnoreCase("O")) {
                                        System.out.print("Entrez le nom de l'acteur : ");
                                        Scanner scanner16 = new Scanner(System.in);
                                        String nom_acteur = scanner16.nextLine();
                                        Vector<Acteur> acteurs = compagnie.getActeurByName(nom_acteur);
                                    if (acteurs.size() > 1) {
                                        for (int i=0; i<acteurs.size(); i++) {
                                            System.out.println(i + ". " + acteurs.get(i).nom + ": " + acteurs.get(i).id);
                                        }
                                        System.out.println("Selectionnez celui à qui vous souhaitez attribuer le rôle : (1 pour le 1er acteur)");
                                        int choix_acteur_attribue = scanner.nextInt();
                                        p.listeRole.add(new Role(nom_role, acteurs.get(choix_acteur_attribue), p));
                                        acteurs.get(choix_acteur_attribue).interpretations.add(new Role(nom_role, acteurs.get(choix_acteur_attribue), p));
                                        }
                                    else {
                                        p.listeRole.add(new Role(nom_role, acteurs.get(0), p));
                                        acteurs.get(0).interpretations.add(new Role(nom_role, acteurs.get(0), p));
                                    }
                                }
                                else {p.listeRole.add(new Role(nom_role, p));}
                                System.out.print(nom_role + " a été ajouté avec succès à la pièce " + titre_piece);
                                }
                                breakWhile4 = true;
                                break;

                            case "2":
                                // Supprimer un rôle
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner17 = new Scanner(System.in);
                                String titre_piece_suppr = scanner17.nextLine();
                                Piece p_suppr = compagnie.getPieceByTitle(titre_piece_suppr);
                                if (p_suppr == null) {System.out.println("Aucun rôle ne peut être supprimé car la pièce n'existe pas"); break;}
                                else {
                                    System.out.print("Entrez le nom du rôle : ");
                                    Scanner scanner18 = new Scanner(System.in);
                                    String nom_role_suppr = scanner18.nextLine();
                                    p_suppr.listeRole.remove(compagnie.getRoleByName(nom_role_suppr, p_suppr));
                                    System.out.print(nom_role_suppr + " a été supprimé avec succès" );
                                }
                                breakWhile4 = true;
                                break;

                            case "3":
                                // Afficher les rôles dans une pièce
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner19 = new Scanner(System.in);
                                String titre_piece_aff = scanner19.nextLine();
                                Piece p_aff = compagnie.getPieceByTitle(titre_piece_aff);
                                if (p_aff == null) {System.out.println("Aucun rôle ne peut être affiché car la pièce n'existe pas"); break;}
                                else { for (Role role : p_aff.listeRole) {System.out.println(role.nom);} }
                                breakWhile4 = true;
                                break;

                            case "4":
                                // Rechercher un rôle
                                System.out.println("Entrez le nom du rôle : ");
                                Scanner scanner20 = new Scanner(System.in);
                                String nom_role_recherche = scanner20.nextLine();
                                System.out.println("Entrez le titre de la pièce : ");
                                Scanner scanner21 = new Scanner(System.in);
                                String titre_piece_recherche = scanner21.nextLine();
                                Piece p_recherche = compagnie.getPieceByTitle(titre_piece_recherche);
                                Role role_recherche = compagnie.getRoleByName(nom_role_recherche,p_recherche);
                                if (role_recherche == null) {System.out.println("Aucun rôle n'a été trouvé");}
                                else {
                                    System.out.println("Nom du rôle : " + role_recherche.nom);
                                    if (role_recherche.joue != null) {System.out.println("Acteur : " + role_recherche.joue.nom);}
                                    System.out.println("Pièce : " + role_recherche.piece.titre);
                                    System.out.println("Texte : ");
                                    for (Texte t :  role_recherche.listeReplique) {
                                        for(String s : t.listeReplique) {
                                            System.out.println(role_recherche.nom + " : " + s);
                                        }
                                    }
                                }
                                breakWhile4 = true;
                                break;

                            case "5":
                                // Afficher les rôles joués par un acteur
                                System.out.print("Entrez le nom de l'acteur : ");
                                Scanner scanner22 = new Scanner(System.in);
                                String nom_acteur_aff = scanner22.nextLine();
                                Vector<Acteur> acteurs_aff = compagnie.getActeurByName(nom_acteur_aff);
                                if (acteurs_aff.size() == 0) {
                                    System.out.println("Aucun acteur n'a été trouvé");
                                }
                                else if (acteurs_aff.size() > 1) {
                                    for (int i = 0; i< acteurs_aff.size(); i++) {
                                        System.out.println(i + ". " + acteurs_aff.get(i).nom + ": " + acteurs_aff.get(i).id);
                                    }
                                    System.out.println("Selectionnez celui dont vous voulez voir les interprétations : (Tapez 1 pour le 1er acteur)" ); 
                                    int choix_acteur_aff = scanner.nextInt();
                                    for (Role role : acteurs_aff.get(choix_acteur_aff).interpretations) {
                                        System.out.println(role.nom);
                                    }
                                }
                                else {
                                      for (Role role : acteurs_aff.get(0).interpretations) {
                                          System.out.println(role.nom);
                                      }
                                }
                                breakWhile4 = true;
                                break;

                            case "6":
                                // Quitter
                                System.out.println("Retour au menu principal");
                                breakWhile4 = true;
                                break;

                            default:
                                System.out.println("Choix invalide. Veuillez réessayer.");
                                breakWhile4 = true;
                                break;
                            }
                        if (breakWhile4) {break;}
                    }
                    break;
                    
                case "4":
                    // Ajouter fonctionnalités répétitions
                    String choix4 = "0";
                    while (choix4 != "9"){
                        Boolean breakWhile5 = false;
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("------- Menu: Répétitions -------");
                        System.out.println("1. Ajouter une répétition");
                        System.out.println("2. Supprimer une répétition");  
                        System.out.println("3. Ajouter des scènes à une répétition");
                        System.out.println("4. Supprimer des scènes d'une répétition");
                        System.out.println("5. Ajouter des acteurs à une répétition");
                        System.out.println("6. Supprimer des acteurs d'une répétition");
                        System.out.println("7. Afficher les informations d'une répétition");
                        System.out.println("8. Afficher le planning pour un mois spécifique");
                        System.out.println("9. Quitter");
                        System.out.println(" ");
                        System.out.print("Sélectionnez votre choix: ");
                        choix4 = scanner.next();

                        switch (choix4) {
                            case "1":
                                // Ajouter une répétition
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner66 = new Scanner(System.in);
                                String titre_piece = scanner66.nextLine();
                                Piece piece_rep = compagnie.getPieceByTitle(titre_piece);

                                if (piece_rep == null) {
                                    System.out.println("Aucune répétition ne peut être placée car la pièce n'existe pas.");
                                    
                                } else {
                                    Vector<Scene> liste_scenes_r = new Vector<Scene>();
                                    Vector<Acteur> liste_A = new Vector<Acteur>();
                                    System.out.println("Voulez-vous ajouter des acteurs à la répétition ?");
                                    String choix_q = "O";
                                    while (!choix_q.equalsIgnoreCase("N")) {
                                        System.out.println("Entrez l'ID de l'acteur :");
                                        int id_acteur = scanner.nextInt();
                                        Acteur acteur_r = compagnie.getActeurById(id_acteur);
                                        if (acteur_r != null) {
                                            liste_A.add(acteur_r);
                                        }
                                        System.out.println("Voulez-vous ajouter un autre acteur ? (O/N)");
                                        choix_q = scanner66.nextLine();
                                    }

                                    System.out.println("Souhaitez-vous répéter pendant un jour de la semaine spécifiquement? (O/N) : ");
                                    String choix_jour = scanner66.nextLine();
                                    if (choix_jour.equalsIgnoreCase("O")) {
                                        System.out.print("Entrez le jour de la semaine lorsque vous voulez répéter: ");
                                        String jour_semaine = scanner66.nextLine();

                                        if (jour_semaine.equalsIgnoreCase("Lundi") || jour_semaine.equalsIgnoreCase("Mardi") ||
                                            jour_semaine.equalsIgnoreCase("Mercredi") || jour_semaine.equalsIgnoreCase("Jeudi") ||
                                            jour_semaine.equalsIgnoreCase("Vendredi") || jour_semaine.equalsIgnoreCase("Samedi") ||
                                            jour_semaine.equalsIgnoreCase("Dimanche")) {

                                            Repetition rep = new Repetition(jour_semaine.toLowerCase(), liste_scenes_r, piece_rep, liste_A);
                                            piece_rep.listeRepet.add(rep);

                                        } else {
                                            System.out.println("Jour de la semaine invalide. Répétition non ajoutée.");
                                        }
                                    } else {
                                        Repetition rep2 = new Repetition(liste_scenes_r, piece_rep, liste_A);
                                        piece_rep.listeRepet.add(rep2);
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "2":
                                // Supprimer une répétition
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner26 = new Scanner(System.in);
                                String titre_piece_suppr = scanner26.nextLine();
                                Piece p_suppr = compagnie.getPieceByTitle(titre_piece_suppr);
                                if (p_suppr == null) {System.out.println("Aucune répétition ne peut être supprimée car la pièce n'existe pas"); break;}
                                else {
                                    System.out.print("Entrez le jour de la répétition : ");
                                    Scanner scanner27 = new Scanner(System.in);
                                    String nom_rep_suppr = scanner27.nextLine();
                                    for (int i=0; i<p_suppr.listeRepet.size(); i++) {
                                        if (p_suppr.listeRepet.get(i).jour_de_la_semaine.equalsIgnoreCase(nom_rep_suppr)) {
                                            System.out.print("Voici la répétition " + p_suppr.listeRepet.get(i).id_rep);
                                            System.out.println("Voulez-vous vraiment supprimer cette répétition? (O/N) : ");
                                            Scanner scanner28 = new Scanner(System.in);
                                            String choix_suppr = scanner28.nextLine();
                                            if (choix_suppr.equalsIgnoreCase("O")) {
                                                p_suppr.listeRepet.remove(i);
                                                System.out.print(nom_rep_suppr + " a été supprimé avec succès" );
                                            }
                                        }
                                        else {
                                            System.out.println("Aucune répétition n'a été trouvée");
                                            break;
                                        }
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "3":
                                // Ajouter des scènes à la répétition
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner29 = new Scanner(System.in);
                                String piece_add = scanner29.nextLine();
                                Piece p_add1 = compagnie.getPieceByTitle(piece_add);
                                if (p_add1 == null) {System.out.println("Aucune répétition ne peut être ajoutée car la pièce n'existe pas"); break;}
                                else {
                                    System.out.print("Entrez le jour de la répétition : ");
                                    Scanner scanner30 = new Scanner(System.in);
                                    String nom_rep= scanner30.nextLine();
                                    for (int i=0; i<p_add1.listeRepet.size(); i++) {
                                        if (p_add1.listeRepet.get(i).jour_de_la_semaine.equalsIgnoreCase(nom_rep)) {
                                            System.out.print("Voici la répétition " + p_add1.listeRepet.get(i).id_rep);
                                            System.out.println("Voulez-vous vraiment ajouter des scènes de cette répétition? (O/N) : ");
                                            String choix_add = scanner.next();
                                            if (choix_add.equalsIgnoreCase("O")) {
                                                System.out.print("Voici une liste des actes de la pièce : ");
                                                for (int j = 0; j < p_add1.listeActe.size(); j++) {
                                                    System.out.print("Souhaitez-vous répéter l'acte" + j+1 + "? (O/N) : ");
                                                    String choix_acte = scanner.next();
                                                    if (choix_acte.equalsIgnoreCase("O")) {
                                                        for (int k=0; k<p_add1.listeActe.get(j).listeScenes.size(); k++) {
                                                            System.out.println("Scène " + p_add1.listeActe.get(j).listeScenes.get(k).num);
                                                            System.out.println("Voulez-vous répéter cette scène ? (O/N) :");
                                                            String choix_rep = scanner.next();
                                                            if (choix_rep.equalsIgnoreCase("O")){p_add1.listeRepet.get(i).listeScenes.add(p_add1.listeActe.get(j).listeScenes.get(k));}}
                                                    }
                                                }
                                            }
                                        }
                                        else 
                                        {
                                            System.out.println("Aucune répétition n'a été trouvée");
                                            break;
                                        }
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "4":
                                // Supprimer des scènes d'une répétition
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner31 = new Scanner(System.in);
                                String titre_piecesuppr = scanner31.nextLine();
                                Piece p_supp = compagnie.getPieceByTitle(titre_piecesuppr);
                                if (p_supp == null) {System.out.println("Aucune répétition ne peut être supprimée car la pièce n'existe pas"); break;}
                                else {
                                    System.out.print("Entrez le jour de la répétition : ");
                                    Scanner scanner32 = new Scanner(System.in);
                                    String nom_rep_suppr = scanner32.nextLine();
                                    for (int i=0; i<p_supp.listeRepet.size(); i++) {
                                        if (p_supp.listeRepet.get(i).jour_de_la_semaine.equalsIgnoreCase(nom_rep_suppr)) {
                                            System.out.print("Voici la répétition " + p_supp.listeRepet.get(i).id_rep);
                                            System.out.println("Voulez-vous vraiment supprimer des scènes de cette répétition? (O/N) : ");
                                            String choix_suppr = scanner.next();
                                            if (choix_suppr.equalsIgnoreCase("O")) {
                                                for (int j=0;j<p_supp.listeRepet.get(i).listeScenes.size(); j++) {
                                                    System.out.println(p_supp.listeRepet.get(i).listeScenes.get(j).num);
                                                    System.out.println("Voulez-vous vraiment supprimer cette scène? (O/N) : ");
                                                    String choix_suppr_sc = scanner.next();
                                                    if (choix_suppr_sc.equalsIgnoreCase("O")) {
                                                        p_supp.listeRepet.get(i).listeScenes.remove(j);
                                                        System.out.print("La scène a été supprimée avec succès" );
                                                    }
                                                }
                                            }
                                        }
                                        else 
                                        {
                                            System.out.println("Aucune répétition n'a été trouvée");
                                            break;
                                        }
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "5":
                                // Ajouter des acteurs à une répétition
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner33 = new Scanner(System.in);
                                String titre_piece_add = scanner33.nextLine();
                                Piece p_add = compagnie.getPieceByTitle(titre_piece_add);
                                if (p_add == null) {System.out.println("Aucune répétition ne peut être modifée car la pièce n'existe pas"); break;}
                                else {
                                    System.out.print("Entrez le jour de la répétition : ");
                                    Scanner scanner34 = new Scanner(System.in);
                                    String nom_rep_s= scanner34.nextLine();
                                    for (int i=0; i<p_add.listeRepet.size(); i++) {
                                        if (p_add.listeRepet.get(i).jour_de_la_semaine.equalsIgnoreCase(nom_rep_s)) {
                                            System.out.print("Voici la répétition " + p_add.listeRepet.get(i).id_rep);
                                            System.out.println("Voulez-vous vraiment ajouter des acteurs à cette répétition? (O/N) : ");
                                            String choix_suppr = scanner.next();
                                            if (choix_suppr.equalsIgnoreCase("O")) {
                                                System.out.print("Combien d'acteurs voulez-vous ajouter? : ");
                                                int nb_acteurs = scanner.nextInt();
                                                for (int j=0; j<nb_acteurs; j++) {
                                                    System.out.print("Entrez l'id de l'acteur : ");
                                                    int id_acteur = scanner.nextInt();
                                                    Acteur a = compagnie.getActeurById(id_acteur);
                                                    if (a != null) { p_add.listeRepet.get(i).listeActeurs.add(a);}
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("Aucune répétition n'a été trouvée");
                                            break;
                                        }
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "6":
                                // Supprimer des acteurs d'une répétition
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner35 = new Scanner(System.in);
                                String titre_piecesupp = scanner35.nextLine();
                                Piece p_sup = compagnie.getPieceByTitle(titre_piecesupp);
                                if (p_sup == null) {System.out.println("Aucune répétition ne peut être supprimée car la pièce n'existe pas"); break; }
                                else {
                                    System.out.print("Entrez le jour de la répétition : ");
                                    Scanner scanner36 = new Scanner(System.in);
                                    String nom_rep_suppr = scanner36.nextLine();
                                    for (int i=0; i<p_sup.listeRepet.size(); i++) {
                                        if (p_sup.listeRepet.get(i).jour_de_la_semaine.equalsIgnoreCase(nom_rep_suppr)) {
                                            System.out.print("Voici la répétition " + p_sup.listeRepet.get(i).id_rep);
                                            System.out.println("Voulez-vous vraiment supprimer des acteurs de cette répétition? (O/N) : ");
                                            String choix_suppr = scanner.next();
                                            if (choix_suppr.equalsIgnoreCase("O")) {
                                                for (int j=0;j<p_sup.listeRepet.get(i).listeActeurs.size(); j++) {
                                                    System.out.println(p_sup.listeRepet.get(i).listeActeurs.get(j).nom);
                                                    System.out.println("Voulez-vous vraiment supprimer cet acteur? (O/N) : ");
                                                    String choix_suppr_act = scanner.next();
                                                    if (choix_suppr_act.equalsIgnoreCase("O")) {
                                                        p_sup.listeRepet.get(i).listeActeurs.remove(j);
                                                        System.out.print("L'acteur a été supprimé avec succès" );
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("Aucune répétition n'a été trouvée");
                                            break;
                                        }
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "7":
                                // Afficher les informations d'une répétition
                                System.out.print("Entrez le titre de la pièce : ");
                                Scanner scanner37 = new Scanner(System.in);
                                String titre_piece_aff = scanner37.nextLine();
                                Piece p_aff = compagnie.getPieceByTitle(titre_piece_aff);
                                if (p_aff == null) {System.out.println("Aucune répétition ne peut être affichée car la pièce n'existe pas"); break; }
                                else {
                                    System.out.print("Entrez le jour de la répétition : ");
                                    Scanner scanner38 = new Scanner(System.in);
                                    String nom_rep_aff = scanner38.nextLine();
                                    for (int i=0; i<p_aff.listeRepet.size(); i++) {
                                        if (p_aff.listeRepet.get(i).jour_de_la_semaine.equalsIgnoreCase(nom_rep_aff)) {
                                            System.out.print("Voici la répétition " + p_aff.listeRepet.get(i).id_rep);
                                            System.out.println("Voulez-vous vraiment afficher les informations de cette répétition? (O/N) : ");
                                            String choix_aff = scanner.next(); 
                                            if (choix_aff.equalsIgnoreCase("O")) {
                                                System.out.println("Jour de la semaine : " + p_aff.listeRepet.get(i).jour_de_la_semaine);
                                                System.out.println("Pièce : " + p_aff.listeRepet.get(i).piece);
                                                System.out.println("Scènes : ");
                                                for (Scene scene : p_aff.listeRepet.get(i).listeScenes) {
                                                    System.out.println("Acte - " + scene.acte.numero + " : Scène - " + scene.num);
                                                }
                                                System.out.println("Acteurs : ");
                                                for (Acteur acteur : p_aff.listeRepet.get(i).listeActeurs) {
                                                    System.out.println("Nom - " + acteur.nom + " / ID - " + acteur.id);
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("Aucune répétition n'a été trouvée");
                                            break;
                                        }
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "8":
                                // Afficher le planning 
                                System.out.println("Entrez le titre de la pièce : ");
                                Scanner scanner39 = new Scanner(System.in);
                                String titre_piece_plan = scanner39.nextLine();
                                Piece p_plan = compagnie.getPieceByTitle(titre_piece_plan);
                                if (p_plan == null) {System.out.println("Aucune planning de répétition ne peut être affichée car la pièce n'existe pas"); break; }
                                else {
                                    System.out.print("Entrez le mois de la répétition (Par exemple pour le mois de mai, on écrit 5) : ");
                                    int mois_rep = scanner.nextInt();
                                    if (mois_rep >= 1 && mois_rep <= 12) {
                                        LocalDate startDate = LocalDate.of(p_plan.annee, mois_rep, 1);
                                        int nb_j = startDate.lengthOfMonth();
                                        Locale locale = Locale.FRENCH;
                                        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE - dd/MM/yyyy");
                                         System.out.println("Planning du mois de " + startDate.getMonth().getDisplayName(java.time.format.TextStyle.FULL, locale) + " " + p_plan.annee + ":");
                                        for (int jour = 1; jour <= nb_j; jour++) {
                                            LocalDate date = LocalDate.of(p_plan.annee, mois_rep, jour);
                                            String rep_en_tout = "";
                                            for (Repetition rep : p_plan.listeRepet) {
                                                if (rep.dates.contains(date)) {
                                                    rep_en_tout += "Répétition " + rep.id_rep + " - ";
                                                }
                                            System.out.println(date.format(format) + " : " + rep_en_tout );
                                            }
                                        }
                                    }
                                    else 
                                    {
                                        System.out.println("Le mois que vous avez entré n'est pas valide ou est sous format incorrect. Veuillez réessayer.");
                                        break;
                                    }
                                }
                                breakWhile5 = true;
                                break;

                            case "9":
                                // Quitter le programme
                                System.out.println("Retour au menu principal");
                                breakWhile5 = true;
                                break;

                            default:
                                System.out.println("Choix invalide, veuillez réessayer");
                                breakWhile5 = true;
                                break;
                            }
                            if (breakWhile5) {
                                break;
                            }
                        }
                    break;
                    
                case "5":
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Merci d'avoir utilisé le programme. Au revoir!");
                    breakWhile = true;
                    break;

                default:
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
                }
    
                if (breakWhile) {
                    break;
                }
            } 
        }
    }
