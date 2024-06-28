package classes;

public class Operateur {
    private int id;
    private String nom;
    private String prenom;
    private String specialisation;
    private String telephone;
    private int clientId;

    // Constructeur
    public Operateur(int id, String nom, String prenom, String specialisation, String telephone, int clientId) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialisation = specialisation;
        this.telephone = telephone;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
