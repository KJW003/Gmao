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
             PreparedStatement ps = con.prepareStatement("INSERT INTO devis (montant, dateCreation, validite) VALUES (?, ?, ?)")) {
            ps.setDouble(1, devis.getMontant());
            ps.setDate(2, new java.sql.Date(devis.getDateCreation().getTime()));
            ps.setBoolean(3, devis.isValidite());
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
                    return new Devis(rs.getInt("id"), rs.getDouble("montant"), rs.getDate("dateCreation"), rs.getBoolean("validite"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Devis> getListeDevis() {
        List<Devis> devis = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM devis");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                devis.add(new Devis(rs.getInt("id"), rs.getDouble("montant"), rs.getDate("dateCreation"), rs.getBoolean("validite")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devis;
    }

    public int mettreAJour(Devis devis) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE devis SET montant = ?, dateCreation = ?, validite = ? WHERE id = ?")) {
            ps.setDouble(1, devis.getMontant());
            ps.setDate(2, new java.sql.Date(devis.getDateCreation().getTime()));
            ps.setBoolean(3, devis.isValidite());
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
}
