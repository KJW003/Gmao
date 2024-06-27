package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import classes.Client;

public class ClientDAO {

    public ClientDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Client client) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO client (nom, numeroIFU, RCCM, adresse, codeAPE) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, client.getNom());
            ps.setString(2, client.getNumeroIFU());
            ps.setString(3, client.getRCCM());
            ps.setString(4, client.getAdresse());
            ps.setString(5, client.getCodeAPE());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Client getClient(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroIFU"), rs.getString("RCCM"), rs.getString("adresse"), rs.getString("codeAPE"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Client> getListeClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM client");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("numeroIFU"), rs.getString("RCCM"), rs.getString("adresse"), rs.getString("codeAPE")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public int mettreAJour(Client client) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE client SET nom = ?, numeroIFU = ?, RCCM = ?, adresse = ?, codeAPE = ? WHERE id = ?")) {
            ps.setString(1, client.getNom());
            ps.setString(2, client.getNumeroIFU());
            ps.setString(3, client.getRCCM());
            ps.setString(4, client.getAdresse());
            ps.setString(5, client.getCodeAPE());
            ps.setInt(6, client.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM client WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
