public class ResponsableMaintenance {
    private String nom;
    private String identifiant;
    private String specialisation; 

    // Constructeur
    public ResponsableMaintenance(String nom, String identifiant, String specialisation) {
        this.nom = nom;
        this.identifiant = identifiant;
        this.specialisation = specialisation;
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

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
