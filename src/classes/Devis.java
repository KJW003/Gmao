import java.util.Date;

public class Devis {
    private int id;
    private double montant;
    private Date dateCreation;
    private boolean validite;

    // Constructeur
    public Devis(int id, double montant, Date dateCreation, boolean validite) {
        this.id = id;
        this.montant = montant;
        this.dateCreation = dateCreation;
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isValidite() {
        return validite;
    }

    public void setValidite(boolean validite) {
        this.validite = validite;
    }
}
