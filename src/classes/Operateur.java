public class Operateur {
    private int id;
    private int clientId;
    private String nom;
    private String identifiant;
    private String specialisation;

    public Operateur(int id, int clientId, String nom, String identifiant, String specialisation) {
        this.id = id;
        this.clientId = clientId;
        this.nom = nom;
        this.identifiant = identifiant;
        this.specialisation = specialisation;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
}
