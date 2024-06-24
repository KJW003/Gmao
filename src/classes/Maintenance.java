import java.util.Date;

public class Maintenance {
    private int id;
    private int clientId;
    private int operateurId;
    private int responsableMaintenanceId;
    private String type;
    private String details;
    private Date dateCreation;

    public Maintenance(int id, int clientId, int operateurId, int responsableMaintenanceId, String type, String details, Date dateCreation) {
        this.id = id;
        this.clientId = clientId;
        this.operateurId = operateurId;
        this.responsableMaintenanceId = responsableMaintenanceId;
        this.type = type;
        this.details = details;
        this.dateCreation = dateCreation;
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

    public int getOperateurId() {
        return operateurId;
    }

    public void setOperateurId(int operateurId) {
        this.operateurId = operateurId;
    }

    public int getResponsableMaintenanceId() {
        return responsableMaintenanceId;
    }

    public void setResponsableMaintenanceId(int responsableMaintenanceId) {
        this.responsableMaintenanceId = responsableMaintenanceId;
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
