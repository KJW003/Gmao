import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResponsableMaintenanceDAO {

    public ResponsableMaintenanceDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(ResponsableMaintenance responsable) {
        String query = "INSERT INTO responsableMaintenance (nom, identifiant, specialisation) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, responsable.getNom());
            ps.setString(2, responsable.getIdentifiant());
            ps.setString(3, responsable.getSpecialisation());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResponsableMaintenance getResponsableMaintenance(int id) {
        String query = "SELECT * FROM responsableMaintenance WHERE id = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ResponsableMaintenance(
                            rs.getString("nom"),
                            rs.getString("identifiant"),
                            rs.getString("specialisation")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ResponsableMaintenance> getListeResponsablesMaintenance() {
        List<ResponsableMaintenance> responsables = new ArrayList<>();
        String query = "SELECT * FROM responsableMaintenance";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                responsables.add(new ResponsableMaintenance(
                        rs.getString("nom"),
                        rs.getString("identifiant"),
                        rs.getString("specialisation")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsables;
    }

    public int mettreAJour(ResponsableMaintenance responsable) {
        String query = "UPDATE responsableMaintenance SET nom = ?, identifiant = ?, specialisation = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, responsable.getNom());
            ps.setString(2, responsable.getIdentifiant());
            ps.setString(3, responsable.getSpecialisation());
            ps.setInt(4, responsable.getId()); // Assurez-vous que la méthode getId() est ajoutée
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        String query = "DELETE FROM responsableMaintenance WHERE id = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<ResponsableMaintenance> getResponsablesParSpecialisation(String specialisation) {
        List<ResponsableMaintenance> responsables = new ArrayList<>();
        String query = "SELECT * FROM responsableMaintenance WHERE specialisation = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, specialisation);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    responsables.add(new ResponsableMaintenance(
                            rs.getString("nom"),
                            rs.getString("identifiant"),
                            rs.getString("specialisation")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsables;
    }
}
