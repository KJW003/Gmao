import java.util.Date;

public class Devis {
    private Double montant;
    private Date dateCreation;
    private Boolean validite;

    // Constructeur
    public Devis(Double montant, Date dateCreation, Boolean validite) {
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.validite = validite;
    }

    // Getters et setters
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getValidite() {
        return validite;
    }

    public void setValidite(Boolean validite) {
        this.validite = validite;
    }
}
