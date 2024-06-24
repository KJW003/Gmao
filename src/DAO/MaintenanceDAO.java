import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO {

    public MaintenanceDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Maintenance maintenance) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO maintenance (id, type, details, dateCreation) VALUES (?, ?, ?, ?)")) {
            ps.setInt(1, maintenance.getId());
            ps.setString(2, maintenance.getType());
            ps.setString(3, maintenance.getDetails());
            ps.setDate(4, new java.sql.Date(maintenance.getDateCreation().getTime()));
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Maintenance getMaintenance(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM maintenance WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Maintenance(rs.getInt("id"), rs.getString("type"), rs.getString("details"), rs.getDate("dateCreation"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Maintenance> getListeMaintenances() {
        List<Maintenance> maintenances = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM maintenance");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                maintenances.add(new Maintenance(rs.getInt("id"), rs.getString("type"), rs.getString("details"), rs.getDate("dateCreation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenances;
    }

    public int mettreAJour(Maintenance maintenance) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE maintenance SET type = ?, details = ?, dateCreation = ? WHERE id = ?")) {
            ps.setString(1, maintenance.getType());
            ps.setString(2, maintenance.getDetails());
            ps.setDate(3, new java.sql.Date(maintenance.getDateCreation().getTime()));
            ps.setInt(4, maintenance.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM maintenance WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}