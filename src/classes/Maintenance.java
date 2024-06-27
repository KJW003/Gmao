import java.util.Date;

public class Maintenance {
    private int id;
    private String type;
    private String details;
    private Date dateCreation;
    private int operateurId;
    private int clientId;
    private int responsableMaintenanceId;

    // Constructeur
    public Maintenance(int id, String type, String details, Date dateCreation, int operateurId, int clientId, int responsableMaintenanceId) {
        this.id = id;
        this.type = type;
        this.details = details;
        this.dateCreation = dateCreation;
        this.operateurId = operateurId;
        this.clientId = clientId;
        this.responsableMaintenanceId = responsableMaintenanceId;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getOperateurId() {
        return operateurId;
    }

    public void setOperateurId(int operateurId) {
        this.operateurId = operateurId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getResponsableMaintenanceId() {
        return responsableMaintenanceId;
    }

    public void setResponsableMaintenanceId(int responsableMaintenanceId) {
        this.responsableMaintenanceId = responsableMaintenanceId;
    }
}
