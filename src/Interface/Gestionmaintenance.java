package Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gestionmaintenance {

    JFrame frame;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Gestionmaintenance window = new Gestionmaintenance();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public Gestionmaintenance() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.activeCaption);
        frame.setBounds(100, 100, 952, 643);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 938, 63);
        panel.setBackground(new Color(255, 255, 255));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("GMAO");
        lblNewLabel.setBounds(433, 11, 69, 41);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        panel.add(lblNewLabel);

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 179, 142));
        panel_1.setBounds(-1, 61, 939, 58);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton_1 = new JButton("Créer une demande de maintenance");
        btnNewButton_1.setBackground(new Color(132, 193, 255));
        btnNewButton_1.setBounds(252, 0, 209, 58);
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panel_1.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Affecter un opérateur");
        btnNewButton_1_1.setBackground(new Color(132, 193, 255));
        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_1_1.setBounds(490, 0, 209, 58);
        panel_1.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Créer un devis");
        btnNewButton_1_2.setBackground(new Color(132, 193, 255));
        btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_1_2.setBounds(720, 0, 209, 58);
        panel_1.add(btnNewButton_1_2);
        
                JLabel lblNewLabel_2 = new JLabel("Gestion de Maintenance");
                lblNewLabel_2.setBounds(10, 11, 227, 37);
                panel_1.add(lblNewLabel_2);
                lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 19));

        btnNewButton_1.addActionListener(e -> {
            clearPanel(panel_2);

            // Composants pour créer une demande de maintenance
            JLabel lblTypeMaintenance = new JLabel("Type de maintenance:");
            lblTypeMaintenance.setBounds(50, 50, 150, 20);
            panel_2.add(lblTypeMaintenance);

            JTextField textFieldTypeMaintenance = new JTextField();
            textFieldTypeMaintenance.setBounds(210, 50, 200, 20);
            panel_2.add(textFieldTypeMaintenance);

            JLabel lblIdMaintenance = new JLabel("Id de la maintenance:");
            lblIdMaintenance.setBounds(50, 100, 150, 20);
            panel_2.add(lblIdMaintenance);

            JTextField textFieldIdMaintenance = new JTextField();
            textFieldIdMaintenance.setBounds(210, 100, 200, 20);
            panel_2.add(textFieldIdMaintenance);

            JLabel lblDescription = new JLabel("Description:");
            lblDescription.setBounds(50, 150, 150, 20);
            panel_2.add(lblDescription);

            JTextField textFieldDescription = new JTextField();
            textFieldDescription.setBounds(210, 150, 200, 20);
            panel_2.add(textFieldDescription);

            JLabel lblStatut = new JLabel("Statut:");
            lblStatut.setBounds(50, 200, 150, 20);
            panel_2.add(lblStatut);

            JTextField textFieldStatut = new JTextField();
            textFieldStatut.setBounds(210, 200, 200, 20);
            panel_2.add(textFieldStatut);

            // Boutons Enregistrer et Annuler
            JButton btnEnregistrer = new JButton("Enregistrer");
            btnEnregistrer.setBounds(150, 300, 120, 30);
            panel_2.add(btnEnregistrer);

            JButton btnAnnuler = new JButton("Annuler");
            btnAnnuler.setBounds(280, 300, 120, 30);
            panel_2.add(btnAnnuler);

            // ActionListener pour le bouton Enregistrer
            btnEnregistrer.addActionListener(event -> {
                String typeMaintenance = textFieldTypeMaintenance.getText().trim();
                String idMaintenance = textFieldIdMaintenance.getText().trim();
                String description = textFieldDescription.getText().trim();
                String statut = textFieldStatut.getText().trim();

                // Vérification des champs non vides
                if (typeMaintenance.isEmpty() || idMaintenance.isEmpty() || description.isEmpty() || statut.isEmpty()) {
                    highlightEmptyFields(textFieldTypeMaintenance, textFieldIdMaintenance, textFieldDescription, textFieldStatut);
                    JOptionPane.showMessageDialog(frame, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Ajouter ou mettre à jour la demande de maintenance ici (simulation)
                System.out.println("Type de maintenance : " + typeMaintenance);
                System.out.println("Id de la maintenance : " + idMaintenance);
                System.out.println("Description : " + description);
                System.out.println("Statut : " + statut);

                // Afficher la liste des demandes de maintenance (simulation)
                addDemandeMaintenanceToList(typeMaintenance, idMaintenance, description, statut);
                clearPanel(panel_2);
            });
        });

        btnNewButton_1_1.addActionListener(e -> {
            clearPanel(panel_2);

            // Composants pour affecter un opérateur
            JLabel lblIdOperateur = new JLabel("Id opérateur:");
            lblIdOperateur.setBounds(50, 50, 150, 20);
            panel_2.add(lblIdOperateur);

            JTextField textFieldIdOperateur = new JTextField();
            textFieldIdOperateur.setBounds(210, 50, 200, 20);
            panel_2.add(textFieldIdOperateur);

            JLabel lblNom = new JLabel("Nom:");
            lblNom.setBounds(50, 100, 150, 20);
            panel_2.add(lblNom);

            JTextField textFieldNom = new JTextField();
            textFieldNom.setBounds(210, 100, 200, 20);
            panel_2.add(textFieldNom);

            JLabel lblPrenom = new JLabel("Prénom:");
            lblPrenom.setBounds(50, 150, 150, 20);
            panel_2.add(lblPrenom);

            JTextField textFieldPrenom = new JTextField();
            textFieldPrenom.setBounds(210, 150, 200, 20);
            panel_2.add(textFieldPrenom);

            JLabel lblCompetence = new JLabel("Compétence:");
            lblCompetence.setBounds(50, 200, 150, 20);
            panel_2.add(lblCompetence);

            JTextField textFieldCompetence = new JTextField();
            textFieldCompetence.setBounds(210, 200, 200, 20);
            panel_2.add(textFieldCompetence);

            JLabel lblTel = new JLabel("Téléphone:");
            lblTel.setBounds(50, 250, 150, 20);
            panel_2.add(lblTel);

            JTextField textFieldTel = new JTextField();
            textFieldTel.setBounds(210, 250, 200, 20);
            panel_2.add(textFieldTel);

            // Bouton Affecter
            JButton btnAffecter = new JButton("Affecter");
            btnAffecter.setBounds(150, 300, 120, 30);
            panel_2.add(btnAffecter);

            btnAffecter.addActionListener(event -> {
                String idOperateur = textFieldIdOperateur.getText().trim();
                String nom = textFieldNom.getText().trim();
                String prenom = textFieldPrenom.getText().trim();
                String competence = textFieldCompetence.getText().trim();
                String tel = textFieldTel.getText().trim();

                // Vérification des champs non vides
                if (idOperateur.isEmpty() || nom.isEmpty() || prenom.isEmpty() || competence.isEmpty() || tel.isEmpty()) {
                    highlightEmptyFields(textFieldIdOperateur, textFieldNom, textFieldPrenom, textFieldCompetence, textFieldTel);
                    JOptionPane.showMessageDialog(frame, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Affecter l'opérateur ici (simulation)
                System.out.println("Id opérateur : " + idOperateur);
                System.out.println("Nom : " + nom);
                System.out.println("Prénom : " + prenom);
                System.out.println("Compétence : " + competence);
                System.out.println("Téléphone : " + tel);

                // Afficher la liste des opérateurs (simulation)
                addOperateurToList(idOperateur, nom, prenom, competence, tel);
                clearPanel(panel_2);
            });
        });

        btnNewButton_1_2.addActionListener(e -> {
            clearPanel(panel_2);

            // Composants pour créer un devis
            JLabel lblIdDevis = new JLabel("Id du devis:");
            lblIdDevis.setBounds(50, 50, 150, 20);
            panel_2.add(lblIdDevis);

            JTextField textFieldIdDevis = new JTextField();
            textFieldIdDevis.setBounds(210, 50, 200, 20);
            panel_2.add(textFieldIdDevis);

            JLabel lblDescriptionDevis = new JLabel("Description:");
            lblDescriptionDevis.setBounds(50, 100, 150, 20);
            panel_2.add(lblDescriptionDevis);

            JTextField textFieldDescriptionDevis = new JTextField();
            textFieldDescriptionDevis.setBounds(210, 100, 200, 20);
            panel_2.add(textFieldDescriptionDevis);

            JLabel lblStatutDevis = new JLabel("Statut:");
            lblStatutDevis.setBounds(50, 150, 150, 20);
            panel_2.add(lblStatutDevis);

            JTextField textFieldStatutDevis = new JTextField();
            textFieldStatutDevis.setBounds(210, 150, 200, 20);
            panel_2.add(textFieldStatutDevis);

            JLabel lblMontant = new JLabel("Montant:");
            lblMontant.setBounds(50, 200, 150, 20);
            panel_2.add(lblMontant);

            JTextField textFieldMontant = new JTextField();
            textFieldMontant.setBounds(210, 200, 200, 20);
            panel_2.add(textFieldMontant);

            // Boutons Enregistrer et Annuler
            JButton btnEnregistrerDevis = new JButton("Enregistrer");
            btnEnregistrerDevis.setBounds(150, 250, 120, 30);
            panel_2.add(btnEnregistrerDevis);

            JButton btnAnnulerDevis = new JButton("Annuler");
            btnAnnulerDevis.setBounds(280, 250, 120, 30);
            panel_2.add(btnAnnulerDevis);

            // ActionListener pour le bouton Enregistrer
            btnEnregistrerDevis.addActionListener(event -> {
                String idDevis = textFieldIdDevis.getText().trim();
                String descriptionDevis = textFieldDescriptionDevis.getText().trim();
                String statutDevis = textFieldStatutDevis.getText().trim();
                String montantDevis = textFieldMontant.getText().trim();

                // Vérification des champs non vides
                if (idDevis.isEmpty() || descriptionDevis.isEmpty() || statutDevis.isEmpty() || montantDevis.isEmpty()) {
                    highlightEmptyFields(textFieldIdDevis, textFieldDescriptionDevis, textFieldStatutDevis, textFieldMontant);
                    JOptionPane.showMessageDialog(frame, "Tous les champs doivent être remplis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Ajouter ou mettre à jour le devis ici (simulation)
                System.out.println("Id du devis : " + idDevis);
                System.out.println("Description : " + descriptionDevis);
                System.out.println("Statut : " + statutDevis);
                System.out.println("Montant : " + montantDevis);

                // Afficher la liste des devis (simulation)
                addDevisToList(idDevis, descriptionDevis, statutDevis);
                clearPanel(panel_2);
            });
        });

        panel_2 = new JPanel();
        panel_2.setBackground(new Color(240, 240, 240));
        panel_2.setBounds(249, 119, 689, 488);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 128, 64));
        panel_3.setBounds(0, 119, 251, 488);
        frame.getContentPane().add(panel_3);
        panel_3.setLayout(null);
        
                JButton btnNewButton = new JButton("Deconnexion");
                btnNewButton.setBounds(10, 440, 156, 21);
                panel_3.add(btnNewButton);
                btnNewButton.setBackground(new Color(255, 255, 255));
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        utilisateur test23 = new utilisateur();
                        test23.main(null);
                    }
                });
                btnNewButton.setForeground(new Color(0, 0, 0));
                btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
    }

    // Méthode pour vider un panel
    private void clearPanel(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    // Méthode pour mettre en surbrillance les champs vides
    private void highlightEmptyFields(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                field.setBackground(Color.PINK);
            } else {
                field.setBackground(Color.WHITE);
            }
        }
    }

    // Méthode pour ajouter une demande de maintenance à la liste (simulation)
    private void addDemandeMaintenanceToList(String type, String id, String description, String statut) {
        JLabel label = new JLabel("Type: " + type + ", ID: " + id + ", Description: " + description + ", Statut: " + statut);
        label.setBounds(10, panelListeOperateurs.getComponentCount() * 30, 500, 20);
        panelListeOperateurs.add(label);
        panelListeOperateurs.revalidate();
        panelListeOperateurs.repaint();
    }

    // Méthode pour ajouter un opérateur à la liste (simulation)
    private void addOperateurToList(String id, String nom, String prenom, String competence, String tel) {
        JLabel label = new JLabel("ID: " + id + ", Nom: " + nom + ", Prénom: " + prenom + ", Compétence: " + competence + ", Téléphone: " + tel);
        label.setBounds(10, panelListeOperateurs.getComponentCount() * 30, 600, 20);
        panelListeOperateurs.add(label);
        panelListeOperateurs.revalidate();
        panelListeOperateurs.repaint();
    }

    // Méthode pour ajouter un devis à la liste (simulation)
    private void addDevisToList(String id, String description, String statut) {
        JLabel label = new JLabel("ID: " + id + ", Description: " + description + ", Statut: " + statut);
        label.setBounds(10, panelListeDevis.getComponentCount() * 30, 500, 20);
        panelListeDevis.add(label);
        panelListeDevis.revalidate();
        panelListeDevis.repaint();
    }
}