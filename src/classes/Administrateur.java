package classes;
public class Administrateur {
    private String nom;
    private String identifiant;
    private String motDePasse;

    // Constructeur
    public Administrateur(String nom, String identifiant, String motDePasse) {
        this.nom = nom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
