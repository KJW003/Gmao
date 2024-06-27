package classes;
public class ResponsableMaintenance {
    private int id;
    private String nom;
    private String identifiant;
    private String specialisation;
    private int clientId;

    // Constructeur
    public ResponsableMaintenance(int id, String nom, String identifiant, String specialisation, int clientId) {
        this.id = id;
        this.nom = nom;
        this.identifiant = identifiant;
        this.specialisation = specialisation;
        this.clientId = clientId;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
