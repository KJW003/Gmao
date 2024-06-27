package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import classes.CompteRendu;

public class CompteRenduDAO {

    public CompteRenduDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(CompteRendu compteRendu) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO compteRendu (details, date, validite, maintenanceId) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, compteRendu.getDetails());
            ps.setDate(2, new java.sql.Date(compteRendu.getDate().getTime()));
            ps.setBoolean(3, compteRendu.isValidite());
            ps.setInt(4, compteRendu.getMaintenanceId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public CompteRendu getCompteRendu(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM compteRendu WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CompteRendu(rs.getInt("id"), rs.getString("details"), rs.getDate("date"), rs.getBoolean("validite"), rs.getInt("maintenanceId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CompteRendu> getListeCompteRendus() {
        List<CompteRendu> compteRendus = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM compteRendu");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                compteRendus.add(new CompteRendu(rs.getInt("id"), rs.getString("details"), rs.getDate("date"), rs.getBoolean("validite"), rs.getInt("maintenanceId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compteRendus;
    }

    public int mettreAJour(CompteRendu compteRendu) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE compteRendu SET details = ?, date = ?, validite = ?, maintenanceId = ? WHERE id = ?")) {
            ps.setString(1, compteRendu.getDetails());
            ps.setDate(2, new java.sql.Date(compteRendu.getDate().getTime()));
            ps.setBoolean(3, compteRendu.isValidite());
            ps.setInt(4, compteRendu.getMaintenanceId());
            ps.setInt(5, compteRendu.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM compteRendu WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
