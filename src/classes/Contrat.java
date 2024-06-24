import java.util.Date;

public class Contrat {
    private Integer id;
    private Integer clientId;
    private Date dateDebut;
    private Date dateFin;
    private String termes;
    private Double montant;

    // Constructeur
    public Contrat(Integer id, Integer clientId, Date dateDebut, Date dateFin, String termes, Double montant) {
        this.id = id;
        this.clientId = clientId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.termes = termes;
        this.montant = montant;
    }

    // Getters et setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getTermes() {
        return termes;
    }

    public void setTermes(String termes) {
        this.termes = termes;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
