import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevisDAO {

    public DevisDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Devis devis) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO devis (idMaintenance, details, montant) VALUES (?, ?, ?)")) {
            ps.setInt(1, devis.getIdMaintenance());
            ps.setString(2, devis.getDetails());
            ps.setDouble(3, devis.getMontant());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Devis getDevis(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM devis WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Devis(rs.getInt("id"), rs.getInt("idMaintenance"), rs.getString("details"), rs.getDouble("montant"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Devis> getListeDevis() {
        List<Devis> devisList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM devis");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                devisList.add(new Devis(rs.getInt("id"), rs.getInt("idMaintenance"), rs.getString("details"), rs.getDouble("montant")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devisList;
    }

    public int mettreAJour(Devis devis) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE devis SET idMaintenance = ?, details = ?, montant = ? WHERE id = ?")) {
            ps.setInt(1, devis.getIdMaintenance());
            ps.setString(2, devis.getDetails());
            ps.setDouble(3, devis.getMontant());
            ps.setInt(4, devis.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM devis WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Devis> getDevisForMaintenance(int idMaintenance) {
        List<Devis> devisList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM devis WHERE idMaintenance = ?")) {
            ps.setInt(1, idMaintenance);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    devisList.add(new Devis(rs.getInt("id"), rs.getInt("idMaintenance"), rs.getString("details"), rs.getDouble("montant")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devisList;
    }
}
