import java.util.List;
import java.util.ArrayList;

class Utilisateur {
    public String nom;
    public int numeroIdentification;
    public List<Livre> livresEmpruntes;

    public Utilisateur(String nom, int numeroIdentification) {
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public void setNumeroIdentification(int numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public List<Livre> getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public void emprunterLivre(Livre livre) {
        livresEmpruntes.add(livre);
    }

    public void retournerLivre(Livre livre) {
        livresEmpruntes.remove(livre);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", numeroIdentification=" + numeroIdentification +
                ", livresEmpruntes=" + livresEmpruntes +
                '}';
    }
}
