import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOUtils {
    // Variables globales de connexion
    final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String LOGIN = "prof";
    final static String PASS = "isgeic2019";

    public DatabaseDAO() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
        }
    }

    public class AdministrateurDAO {
        public int ajouter(Administrateur administrateur) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO administrateur (id, nom, prenom, email, telephone) VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, administrateur.getId());
                ps.setString(2, administrateur.getNom());
                ps.setString(3, administrateur.getPrenom());
                ps.setString(4, administrateur.getEmail());
                ps.setString(5, administrateur.getTelephone());

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
/*
        public Administrateur getAdministrateur(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Administrateur retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM administrateur WHERE id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new Administrateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<Administrateur> getListeAdministrateurs() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Administrateur> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM administrateur");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new Administrateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }
    

    public class ResponsableMaintenanceDAO {
        public int ajouter(ResponsableMaintenance responsable) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO responsable_maintenance (id, nom, prenom, email, telephone) VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, responsable.getId());
                ps.setString(2, responsable.getNom());
                ps.setString(3, responsable.getPrenom());
                ps.setString(4, responsable.getEmail());
                ps.setString(5, responsable.getTelephone());

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public ResponsableMaintenance getResponsableMaintenance(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            ResponsableMaintenance retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM responsable_maintenance WHERE id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new ResponsableMaintenance(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<ResponsableMaintenance> getListeResponsablesMaintenance() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<ResponsableMaintenance> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM responsable_maintenance");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new ResponsableMaintenance(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }
    
    public class MaintenanceDAO {
        public int ajouter(Maintenance maintenance) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO maintenance (id, type, details, date_creation) VALUES (?, ?, ?, ?)");
                ps.setInt(1, maintenance.getId());
                ps.setString(2, maintenance.getType());
                ps.setString(3, maintenance.getDetails());
                ps.setDate(4, new java.sql.Date(maintenance.getDateCreation().getTime()));

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public Maintenance getMaintenance(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Maintenance retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM maintenance WHERE id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new Maintenance(rs.getInt("id"), rs.getString("type"), rs.getString("details"),
                            rs.getDate("date_creation"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<Maintenance> getListeMaintenances() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Maintenance> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM maintenance");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new Maintenance(rs.getInt("id"), rs.getString("type"), rs.getString("details"),
                            rs.getDate("date_creation")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }

    public class OperateurDAO {
        public int ajouter(Operateur operateur) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO operateur (nom, identifiant, specialisation) VALUES (?, ?, ?)");
                ps.setString(1, operateur.getNom());
                ps.setString(2, operateur.getIdentifiant());
                ps.setString(3, operateur.getSpecialisation());

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public Operateur getOperateur(String identifiant) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Operateur retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM operateur WHERE identifiant = ?");
                ps.setString(1, identifiant);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new Operateur(rs.getString("nom"), rs.getString("identifiant"), rs.getString("specialisation"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<Operateur> getListeOperateurs() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Operateur> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM operateur");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new Operateur(rs.getString("nom"), rs.getString("identifiant"), rs.getString("specialisation")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }

    public class DevisDAO {
        public int ajouter(Devis devis) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO devis (id, client_id, date_devis, montant) VALUES (?, ?, ?, ?)");
                ps.setInt(1, devis.getId());
                ps.setInt(2, devis.getClientId());
                ps.setDate(3, new java.sql.Date(devis.getDateDevis().getTime()));
                ps.setDouble(4, devis.getMontant());

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public Devis getDevis(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Devis retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM devis WHERE id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new Devis(rs.getInt("id"), rs.getInt("client_id"), rs.getDate("date_devis"), rs.getDouble("montant"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<Devis> getListeDevis() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Devis> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM devis");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new Devis(rs.getInt("id"), rs.getInt("client_id"), rs.getDate("date_devis"), rs.getDouble("montant")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }

    public class CompteRenduDAO {
        public int ajouter(CompteRendu compteRendu) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO compte_rendu (id, maintenance_id, date_creation, contenu) VALUES (?, ?, ?, ?)");
                ps.setInt(1, compteRendu.getId());
                ps.setInt(2, compteRendu.getMaintenanceId());
                ps.setDate(3, new java.sql.Date(compteRendu.getDateCreation().getTime()));
                ps.setString(4, compteRendu.getContenu());

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public CompteRendu getCompteRendu(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            CompteRendu retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM compte_rendu WHERE id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new CompteRendu(rs.getInt("id"), rs.getInt("maintenance_id"), rs.getDate("date_creation"), rs.getString("contenu"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<CompteRendu> getListeCompteRendus() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<CompteRendu> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM compte_rendu");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new CompteRendu(rs.getInt("id"), rs.getInt("maintenance_id"), rs.getDate("date_creation"), rs.getString("contenu")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }

    public class ReportingDAO {
        public int ajouter(Reporting reporting) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO reporting (id, type, details, date_creation) VALUES (?, ?, ?, ?)");
                ps.setInt(1, reporting.getId());
                ps.setString(2, reporting.getType());
                ps.setString(3, reporting.getDetails());
                ps.setDate(4, new java.sql.Date(reporting.getDateCreation().getTime()));

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public Reporting getReporting(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Reporting retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM reporting WHERE id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new Reporting(rs.getInt("id"), rs.getString("type"), rs.getString("details"),
                            rs.getDate("date_creation"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<Reporting> getListeReportings() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Reporting> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM reporting");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new Reporting(rs.getInt("id"), rs.getString("type"), rs.getString("details"),
                            rs.getDate("date_creation")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }

    public class ContratDAO {
        public int ajouter(Contrat contrat) {
            Connection con = null;
            PreparedStatement ps = null;
            int retour = 0;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("INSERT INTO contrat (id, client_id, date_contrat, details) VALUES (?, ?, ?, ?)");
                ps.setInt(1, contrat.getId());
                ps.setInt(2, contrat.getClientId());
                ps.setDate(3, new java.sql.Date(contrat.getDateContrat().getTime()));
                ps.setString(4, contrat.getDetails());

                retour = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public Contrat getContrat(int id) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Contrat retour = null;

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM contrat WHERE id = ?");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    retour = new Contrat(rs.getInt("id"), rs.getInt("client_id"), rs.getDate("date_contrat"), rs.getString("details"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }

        public List<Contrat> getListeContrats() {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Contrat> retour = new ArrayList<>();

            try {
                con = DriverManager.getConnection(URL, LOGIN, PASS);
                ps = con.prepareStatement("SELECT * FROM contrat");
                rs = ps.executeQuery();
                while (rs.next()) {
                    retour.add(new Contrat(rs.getInt("id"), rs.getInt("client_id"), rs.getDate("date_contrat"), rs.getString("details")));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception ignore) {}
                try { if (ps != null) ps.close(); } catch (Exception ignore) {}
                try { if (con != null) con.close(); } catch (Exception ignore) {}
            }
            return retour;
        }
    }

}
*/