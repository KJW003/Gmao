import java.util.Date;

public class Maintenance {
    private Integer id;
    private String type;
    private String details;
    private Date dateCreation;

    // Constructeur
    public Maintenance(Integer id, String type, String details, Date dateCreation) {
        this.id = id;
        this.type = type;
        this.details = details;
        this.dateCreation = dateCreation;
    }

    // Getters et setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
