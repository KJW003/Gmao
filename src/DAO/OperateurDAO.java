package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Operateur;

public class OperateurDAO {

    public OperateurDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(Operateur operateur) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO operateur (nom, prenom, specialisation, telephone, clientId) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, operateur.getNom());
            ps.setString(2, operateur.getPrenom());
            ps.setString(3, operateur.getSpecialisation());
            ps.setString(4, operateur.getTelephone());
            ps.setInt(5, operateur.getClientId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Operateur getOperateur(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM operateur WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Operateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("specialisation"), rs.getString("telephone"), rs.getInt("clientId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Operateur> getListeOperateurs() {
        List<Operateur> operateurs = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM operateur");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                operateurs.add(new Operateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("specialisation"), rs.getString("telephone"), rs.getInt("clientId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operateurs;
    }

    public int mettreAJour(Operateur operateur) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE operateur SET nom = ?, prenom = ?, specialisation = ?, telephone = ?, clientId = ? WHERE id = ?")) {
            ps.setString(1, operateur.getNom());
            ps.setString(2, operateur.getPrenom());
            ps.setString(3, operateur.getSpecialisation());
            ps.setString(4, operateur.getTelephone());
            ps.setInt(5, operateur.getClientId());
            ps.setInt(6, operateur.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM operateur WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
