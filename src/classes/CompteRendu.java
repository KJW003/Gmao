import java.util.Date;

public class CompteRendu {
    private int id;
    private String details;
    private Date date;
    private boolean validite;
    private int maintenanceId;

    public CompteRendu(int id, String details, Date date, boolean validite, int maintenanceId) {
        this.id = id;
        this.details = details;
        this.date = date;
        this.validite = validite;
        this.maintenanceId = maintenanceId;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isValidite() {
        return validite;
    }

    public void setValidite(boolean validite) {
        this.validite = validite;
    }

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }
}
