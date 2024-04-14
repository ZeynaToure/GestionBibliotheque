
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque();

        // Interface utilisateur
        System.out.println("Bienvenue dans le système de gestion de bibliothèque!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Rechercher un livre par titre");
            System.out.println("4. Rechercher un livre par auteur");
            System.out.println("5. Quitter");

            System.out.print("\nChoisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Pour consommer le saut de ligne

            switch (choix) {
                case 1:
                    ajouterLivre(bibliotheque, scanner);
                    break;
                case 2:
                    supprimerLivre(bibliotheque, scanner);
                    break;
                case 3:
                    rechercherParTitre(bibliotheque, scanner);
                    break;
                case 4:
                    rechercherParAuteur(bibliotheque, scanner);
                    break;
                case 5:
                    System.out.println("Merci d'avoir utilisé notre système. Au revoir!");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }
    }

    public static void ajouterLivre(Bibliotheque bibliotheque, Scanner scanner) {
        System.out.println("\nAjout d'un nouveau livre:");
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Année de publication: ");
        int anneePublication = scanner.nextInt();
        scanner.nextLine();  // Pour consommer le saut de ligne
        System.out.print("ISBN: ");
        String ISBN = scanner.nextLine();

        Livre livre = new Livre(titre, auteur, anneePublication, ISBN);
        bibliotheque.ajouterLivre(livre);
        System.out.println("Livre ajouté avec succès!");
    }

    public static void supprimerLivre(Bibliotheque bibliotheque, Scanner scanner) {
        System.out.println("\nSuppression d'un livre:");
        System.out.print("ISBN du livre à supprimer: ");
        String ISBN = scanner.nextLine();

        Livre livreTrouve = bibliotheque.rechercherLivreParISBN(ISBN);
        if (livreTrouve == null) {
            System.out.println("Aucun livre trouvé avec cet ISBN.");
        } else {
            System.out.println("Livre trouvé:");
            System.out.println(livreTrouve);
        
            System.out.print("Entrez l'indice du livre à supprimer: ");
            int indice = scanner.nextInt();
            scanner.nextLine();  // Pour consommer le saut de ligne

            // Vous pouvez maintenant supprimer le livre trouvé
            bibliotheque.supprimerLivre(livreTrouve);
            System.out.println("Livre supprimé avec succès!");
        }
    }

    public static void rechercherParTitre(Bibliotheque bibliotheque, Scanner scanner) {
        System.out.println("\nRecherche de livre par titre:");
        System.out.print("Titre du livre: ");
        String titre = scanner.nextLine();

        List<Livre> livreTrouve = bibliotheque.rechercherLivresParTitre(titre);
        afficherLivreTrouve(livreTrouve);
    }

    public static void rechercherParAuteur(Bibliotheque bibliotheque, Scanner scanner) {
        System.out.println("\nRecherche de livre par auteur:");
        System.out.print("Nom de l'auteur: ");
        String auteur = scanner.nextLine();

        List<Livre> livreTrouve = bibliotheque.rechercherLivresParAuteur(auteur);
        afficherLivreTrouve(livreTrouve);
    }

    public static void afficherLivreTrouve(List<Livre> livreTrouve) {
        if (livreTrouve.isEmpty()) {
            System.out.println("Aucun livre trouvé avec ces critères de recherche.");
            return;
        }

        System.out.println("Livres trouvés:");
        for (int i = 0; i < livreTrouve.size(); i++) {
            System.out.println(i + ". " + livreTrouve.get(i));
        }
    }
}