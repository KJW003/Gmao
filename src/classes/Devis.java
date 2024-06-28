package classes;

public class Devis {
    private int id;
    private String description;
    private double montant;
    private String validite;

    // Constructeur
    public Devis(int id, String description, double montant, String validite) {
        this.id = id;
        this.montant = montant;
        this.description = description;
        this.validite = validite;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValidite() {
        return validite;
    }

    public void setValidite(String validite) {
        this.validite = validite;
    }
}
