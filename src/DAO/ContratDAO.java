package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Contrat;

public class ContratDAO {

    public ContratDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Contrat contrat) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO contrat (id, description,  dateDebut, dateFin, termes, montant, clientId,) VALUES (?, ?, ?, ?, ?)")) {
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
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM contrat WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Contrat(rs.getInt("id"), rs.getInt("clientId"), rs.getDate("dateDebut"), rs.getDate("dateFin"), rs.getString("termes"), rs.getDouble("montant"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contrat> getListeContrats() {
        List<Contrat> contrats = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM contrat");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                contrats.add(new Contrat(rs.getInt("id"), rs.getInt("clientId"), rs.getDate("dateDebut"), rs.getDate("dateFin"), rs.getString("termes"), rs.getDouble("montant")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrats;
    }

    public int mettreAJour(Contrat contrat) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE contrat SET clientId = ?, dateDebut = ?, dateFin = ?, termes = ?, montant = ? WHERE id = ?")) {
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
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM contrat WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
