public class ResponsableMaintenance {
    private String nom;
    private String identifiant;

    // Constructeur
    public ResponsableMaintenance(String nom, String identifiant) {
        this.nom = nom;
        this.identifiant = identifiant;
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
}
