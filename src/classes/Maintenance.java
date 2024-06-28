package classes;

public class Maintenance {
    private int id;
    private String type;
    private String details;
    private String description;
    private int clientId;
    private int responsableMaintenanceId;

    // Constructeur
    public Maintenance(int id, String type, String details, String description, int clientId, int responsableMaintenanceId) {
        this.id = id;
        this.type = type;
        this.details = details;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
