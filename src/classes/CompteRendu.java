import java.util.Date;

public class CompteRendu {
    private String details;
    private Date date;
    private Boolean validite;

    // Constructeur
    public CompteRendu(String details, Date date, Boolean validite) {
        this.details = details;
        this.date = date;
        this.validite = validite;
    }

    // Getters et setters
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getValidite() {
        return validite;
    }

    public void setValidite(Boolean validite) {
        this.validite = validite;
    }
}
