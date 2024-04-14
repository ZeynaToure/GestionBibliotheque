
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliotheque {
    public List<Livre> listeLivres;
    public Map<Utilisateur, List<Livre>> empruntsUtilisateurs;

    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateurs = new HashMap<>();
    }

    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        listeLivres.remove(livre);
    }

    public List<Livre> rechercherLivresParTitre(String titre) {
        List<Livre> resultats = new ArrayList<>();
        for (Livre livre : listeLivres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                resultats.add(livre);
            }
        }
        return resultats;
    }

    public List<Livre> rechercherLivresParAuteur(String auteur) {
        List<Livre> resultats = new ArrayList<>();
        for (Livre livre : listeLivres) {
            if (livre.getAuteur().equalsIgnoreCase(auteur)) {
                resultats.add(livre);
            }
        }
        return resultats;
    }
    public Livre rechercherLivreParISBN(String ISBN) {
        for (Livre livre : listeLivres) {
            if (livre.getISBN().equalsIgnoreCase(ISBN)) {
                return livre;
            }
        }
        return null; // Retourne null si aucun livre avec cet ISBN n'est trouvé
    }
   

    public void enregistrerEmprunt(Utilisateur utilisateur, Livre livre) {
        List<Livre> emprunts = empruntsUtilisateurs.getOrDefault(utilisateur, new ArrayList<>());
        emprunts.add(livre);
        empruntsUtilisateurs.put(utilisateur, emprunts);
    }

    public void enregistrerRetour(Utilisateur utilisateur, Livre livre) {
        List<Livre> emprunts = empruntsUtilisateurs.getOrDefault(utilisateur, new ArrayList<>());
        emprunts.remove(livre);
        empruntsUtilisateurs.put(utilisateur, emprunts);
    }

    public boolean verifierEligibilite(Utilisateur utilisateur) {
        // On suppose que l'éligibilité est basée sur le fait qu'il y ait ou non des emprunts actifs
        return empruntsUtilisateurs.containsKey(utilisateur);
    }

    public void afficherStatistiques() {
        System.out.println("Nombre total de livres: " + listeLivres.size());
        int totalEmprunts = 0;
        for (List<Livre> emprunts : empruntsUtilisateurs.values()) {
            totalEmprunts += emprunts.size();
        }
        System.out.println("Nombre total d'exemplaires empruntés: " + totalEmprunts);
    }





}