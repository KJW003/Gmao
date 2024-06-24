import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContratDAO {

    public ContratDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Contrat contrat) {
        String query = "INSERT INTO contrat (clientId, dateDebut, dateFin, termes, montant) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, contrat.getClientId());
            ps.setDate(2, new java.sql.Date(contrat.getDateDebut().getTime()));
            ps.setDate(3, new java.sql.Date(contrat.getDateFin().getTime()));
            ps.setString(4, contrat.getTermes());
            ps.setDouble(5, contrat.getMontant());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Contrat getContrat(int id) {
        String query = "SELECT * FROM contrat WHERE id = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Contrat(
                            rs.getInt("id"),
                            rs.getInt("clientId"),
                            rs.getDate("dateDebut"),
                            rs.getDate("dateFin"),
                            rs.getString("termes"),
                            rs.getDouble("montant")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contrat> getListeContrats() {
        List<Contrat> contrats = new ArrayList<>();
        String query = "SELECT * FROM contrat";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                contrats.add(new Contrat(
                        rs.getInt("id"),
                        rs.getInt("clientId"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        rs.getString("termes"),
                        rs.getDouble("montant")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrats;
    }

    public int mettreAJour(Contrat contrat) {
        String query = "UPDATE contrat SET clientId = ?, dateDebut = ?, dateFin = ?, termes = ?, montant = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, contrat.getClientId());
            ps.setDate(2, new java.sql.Date(contrat.getDateDebut().getTime()));
            ps.setDate(3, new java.sql.Date(contrat.getDateFin().getTime()));
            ps.setString(4, contrat.getTermes());
            ps.setDouble(5, contrat.getMontant());
            ps.setInt(6, contrat.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        String query = "DELETE FROM contrat WHERE id = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Contrat> getContratsForClient(int clientId) {
        List<Contrat> contrats = new ArrayList<>();
        String query = "SELECT * FROM contrat WHERE clientId = ?";
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, clientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    contrats.add(new Contrat(
                            rs.getInt("id"),
                            rs.getInt("clientId"),
                            rs.getDate("dateDebut"),
                            rs.getDate("dateFin"),
                            rs.getString("termes"),
                            rs.getDouble("montant")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrats;
    }
}
