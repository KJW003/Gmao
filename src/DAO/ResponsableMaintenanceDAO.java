package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.ResponsableMaintenance;

public class ResponsableMaintenanceDAO {

    public ResponsableMaintenanceDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public int ajouter(ResponsableMaintenance responsable) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("INSERT INTO responsableMaintenance (nom, identifiant, specialisation, clientId) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, responsable.getNom());
            ps.setString(2, responsable.getIdentifiant());
            ps.setString(3, responsable.getSpecialisation());
            ps.setInt(4, responsable.getClientId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ResponsableMaintenance getResponsableMaintenance(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM responsableMaintenance WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ResponsableMaintenance(rs.getInt("id"), rs.getString("nom"), rs.getString("identifiant"), rs.getString("specialisation"), rs.getInt("clientId"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ResponsableMaintenance> getListeResponsablesMaintenance() {
        List<ResponsableMaintenance> responsables = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("SELECT * FROM responsableMaintenance");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                responsables.add(new ResponsableMaintenance(rs.getInt("id"), rs.getString("nom"), rs.getString("identifiant"), rs.getString("specialisation"), rs.getInt("clientId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return responsables;
    }

    public int mettreAJour(ResponsableMaintenance responsable) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("UPDATE responsableMaintenance SET nom = ?, identifiant = ?, specialisation = ?, clientId = ? WHERE id = ?")) {
            ps.setString(1, responsable.getNom());
            ps.setString(2, responsable.getIdentifiant());
            ps.setString(3, responsable.getSpecialisation());
            ps.setInt(4, responsable.getClientId());
            ps.setInt(5, responsable.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int supprimer(int id) {
        try (Connection con = DriverManager.getConnection(DAOUtils.URL, DAOUtils.LOGIN, DAOUtils.PASS);
             PreparedStatement ps = con.prepareStatement("DELETE FROM responsableMaintenance WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
