package Interface;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class utilisateur {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JComboBox<String> comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    utilisateur window = new utilisateur();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public utilisateur() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 182, 108));
        frame.setBounds(100, 100, 455, 422);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(79, 167, 255));
        panel.setBounds(0, 0, 1121, 24);
        frame.getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(181, 255, 181));
        panel_1.setBounds(445, 23, 673, 512);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 58, 674, 454);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Login");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNewLabel_2.setBounds(308, 8, 69, 26);
        panel_2.add(lblNewLabel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 170, 85));
        panel_3.setBounds(0, 37, 673, 417);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Utilisateur:");
        lblNewLabel_3.setBounds(51, 36, 84, 20);
        frame.getContentPane().add(lblNewLabel_3);
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(145, 35, 181, 23);
        frame.getContentPane().add(comboBox);
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        
        JLabel lblNewLabel_4 = new JLabel("Identifiant:");
        lblNewLabel_4.setBounds(36, 144, 129, 20);
        frame.getContentPane().add(lblNewLabel_4);
        lblNewLabel_4.setFont(new Font("Segoe Print", Font.BOLD, 16));
        
        JLabel lblNewLabel_5 = new JLabel("Mot de passe:");
        lblNewLabel_5.setBounds(20, 197, 129, 33);
        frame.getContentPane().add(lblNewLabel_5);
        lblNewLabel_5.setFont(new Font("Segoe Print", Font.BOLD, 16));
        
        JButton btnNewButton = new JButton("login");
        btnNewButton.setBackground(new Color(159, 207, 255));
        btnNewButton.setBounds(162, 275, 155, 44);
        frame.getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String identifiant = textField.getText().trim();
                String motDePasse = textField_1.getText().trim();
                
                if (identifiant.isEmpty() || motDePasse.isEmpty()) {
                    // Afficher un message d'erreur
                    JLabel errorLabel = new JLabel("Impossible de se connecter : identifiant ou mot de passe vide");
                    errorLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
                    errorLabel.setForeground(Color.RED);
                    errorLabel.setBounds(10, 250, 400, 20);
                    panel_3.add(errorLabel);
                    
                    // Rafraîchir l'affichage pour montrer le message
                    panel_3.revalidate();
                    panel_3.repaint();
                } else {
                    // Récupérer le type d'utilisateur sélectionné
                    String selectedUserType = (String) comboBox.getSelectedItem();
                    
                    if (selectedUserType.equals("Administrateur")) {
                        // Ouvrir la nouvelle fenêtre Gestionclients et fermer la fenêtre actuelle
                        openGestionClientsWindow();
                        frame.dispose(); // Ferme la fenêtre actuelle
                    } else if (selectedUserType.equals("Responsable maintenance")) {
                        // Ouvrir la nouvelle fenêtre Gestionmaintenance et fermer la fenêtre actuelle
                        openGestionMaintenanceWindow();
                        frame.dispose(); // Ferme la fenêtre actuelle
                    } else if (selectedUserType.equals("Client") || selectedUserType.equals("Opérateur")) {
                        // Ouvrir la nouvelle fenêtre correspondante et fermer la fenêtre actuelle
                        openSpecificUserWindow(selectedUserType);
                        frame.dispose(); // Ferme la fenêtre actuelle
                    } else {
                        // Type d'utilisateur non géré pour le moment
                        System.out.println("Type d'utilisateur non implémenté");
                    }
                }
            }
        });
        btnNewButton.setFont(new Font("Rockwell", Font.BOLD, 20));
        
        textField = new JTextField();
        textField.setBounds(134, 131, 211, 33);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(134, 197, 211, 33);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        comboBox.addItem("Administrateur");
        comboBox.addItem("Responsable maintenance");
        comboBox.addItem("Client");
        comboBox.addItem("Opérateur");
    }
    
    // Méthode pour ouvrir la fenêtre Gestionclients ou Gestionoperateur
    private void openSpecificUserWindow(String userType) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    if (userType.equals("Client")) {
                        Gestionclients window = new Gestionclients();
                        window.frame.setVisible(true);
                    } else if (userType.equals("Opérateur")) {
                        Gestionoperateur window = new Gestionoperateur();
                        window.frame.setVisible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    // Méthode pour ouvrir la fenêtre Gestionclients
    private void openGestionClientsWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gestionclients window = new Gestionclients();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    // Méthode pour ouvrir la fenêtre Gestionmaintenance
    private void openGestionMaintenanceWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gestionmaintenance window = new Gestionmaintenance();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
