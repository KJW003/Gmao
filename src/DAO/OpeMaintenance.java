import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceOperateurDAO {

    public MaintenanceOperateurDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(int maintenanceId, int operateurId) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO maintenance_operateur (maintenanceId, operateurId) VALUES (?, ?)")) {
            ps.setInt(1, maintenanceId);
            ps.setInt(2, operateurId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Integer> getOperateursByMaintenance(int maintenanceId) {
        List<Integer> operateurIds = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT operateurId FROM maintenance_operateur WHERE maintenanceId = ?")) {
            ps.setInt(1, maintenanceId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    operateurIds.add(rs.getInt("operateurId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operateurIds;
    }

    public List<Integer> getMaintenancesByOperateur(int operateurId) {
        List<Integer> maintenanceIds = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT maintenanceId FROM maintenance_operateur WHERE operateurId = ?")) {
            ps.setInt(1, operateurId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    maintenanceIds.add(rs.getInt("maintenanceId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenanceIds;
    }

    public int supprimer(int maintenanceId, int operateurId) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM maintenance_operateur WHERE maintenanceId = ? AND operateurId = ?")) {
            ps.setInt(1, maintenanceId);
            ps.setInt(2, operateurId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
