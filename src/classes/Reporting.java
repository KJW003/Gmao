import java.util.Date;

public class Reporting {
    private Integer id;
    private Date dateDebut;
    private Date dateFin;
    private String type;
    private String rapport;

    // Constructeur
    public Reporting(Integer id, Date dateDebut, Date dateFin, String type, String rapport) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.rapport = rapport;
    }

    // Getters et setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }
}
