package Interface;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Gestionoperateur {

    JFrame frame;
    private JPanel panel_1;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gestionoperateur window = new Gestionoperateur();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Gestionoperateur() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.activeCaption);
        frame.getContentPane().setLayout(null);
        frame.setBounds(100, 100, 948, 621);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 934, 35);
        panel.setBackground(new Color(255, 255, 255));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("GMAO");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lblNewLabel.setBounds(413, 10, 85, 22);
        panel.add(lblNewLabel);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(255, 179, 142));
        panel_1_1.setBounds(0, 33, 934, 67);
        frame.getContentPane().add(panel_1_1);
        
                JButton btnNewButton_1 = new JButton(" reporting journalier");
                btnNewButton_1.setBounds(245, 0, 208, 65);
                panel_1_1.add(btnNewButton_1);
                btnNewButton_1.setBackground(new Color(132, 193, 255));
                btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
                
                        JButton btnNewButton_1_1 = new JButton("reporting hebdomadaire");
                        btnNewButton_1_1.setBounds(478, 0, 213, 65);
                        panel_1_1.add(btnNewButton_1_1);
                        btnNewButton_1_1.setBackground(new Color(132, 193, 255));
                        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
                        
                                JButton btnNewButton_1_1_1 = new JButton("reporting mensuel");
                                btnNewButton_1_1_1.setBounds(711, 0, 213, 65);
                                panel_1_1.add(btnNewButton_1_1_1);
                                btnNewButton_1_1_1.setBackground(new Color(132, 193, 255));
                                btnNewButton_1_1_1.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        openRapportMensuelDialog();
                                    }
                                });
                                btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
                                
                                        JLabel lblNewLabel_2 = new JLabel("Reporting");
                                        lblNewLabel_2.setBounds(69, 11, 117, 45);
                                        panel_1_1.add(lblNewLabel_2);
                                        lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 22));
                        
                                btnNewButton_1_1.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        openRapportHebdomadaireDialog();
                                    }
                                });
                
                        btnNewButton_1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                openRapportQuotidienDialog();
                            }
                        });

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 128, 64));
        panel_3.setBounds(0, 33, 246, 551);
        frame.getContentPane().add(panel_3);
        panel_3.setLayout(null);
        
                JButton btnNewButton = new JButton("Deconnexion");
                btnNewButton.setBounds(10, 519, 156, 21);
                panel_3.add(btnNewButton);
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        // Ici, j'ai supposé que Nomutilisateur est une classe existante pour la déconnexion.
                        // Vous devez ajuster cette partie en fonction de votre propre logique de déconnexion.
                        // test25.main(null); n'est pas recommandé ici, veuillez le remplacer par votre logique de déconnexion.
                        utilisateur test25 = new utilisateur();
                        test25.main(null);
                    }
                });
                btnNewButton.setForeground(new Color(0, 0, 0));
                btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

        panel_1 = new JPanel();
        panel_1.setBounds(245, 98, 689, 486);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
    }

    private void openRapportQuotidienDialog() {
        clearPanel(panel_1);

        JLabel lblTitre = new JLabel("Reporting quotidien");
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitre.setForeground(Color.GREEN);
        lblTitre.setBounds(10, 10, 464, 30);
        panel_1.add(lblTitre);

        JLabel lblUtilisateur = new JLabel("Utilisateur:");
        lblUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblUtilisateur.setBounds(50, 60, 100, 20);
        panel_1.add(lblUtilisateur);

        JTextField textFieldUtilisateur = new JTextField();
        textFieldUtilisateur.setBounds(160, 60, 300, 20);
        panel_1.add(textFieldUtilisateur);
        textFieldUtilisateur.setColumns(10);

        JLabel lblDetails = new JLabel("Détails des maintenances:");
        lblDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblDetails.setBounds(50, 100, 200, 20);
        panel_1.add(lblDetails);

        JTextField textFieldDetails = new JTextField();
        textFieldDetails.setBounds(160, 130, 300, 20);
        panel_1.add(textFieldDetails);
        textFieldDetails.setColumns(10);

        JLabel lblStatistiques = new JLabel("Statistiques:");
        lblStatistiques.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblStatistiques.setBounds(50, 170, 100, 20);
        panel_1.add(lblStatistiques);

        JTextField textFieldStatistiques = new JTextField();
        textFieldStatistiques.setBounds(160, 170, 300, 20);
        panel_1.add(textFieldStatistiques);
        textFieldStatistiques.setColumns(10);

        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String utilisateur = textFieldUtilisateur.getText().trim();
                String details = textFieldDetails.getText().trim();
                String statistiques = textFieldStatistiques.getText().trim();

                if (utilisateur.isEmpty() || details.isEmpty() || statistiques.isEmpty()) {
                    JLabel lblErreur = new JLabel("Tous les champs doivent être remplis !");
                    lblErreur.setForeground(Color.RED);
                    lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
                    lblErreur.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    lblErreur.setBounds(10, 30, 264, 30);
                    panel_1.add(lblErreur);
                } else {
                    afficherInformationsEnregistrees(utilisateur, details, statistiques);
                }
            }
        });
        btnEnregistrer.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnEnregistrer.setBounds(100, 250, 120, 30);
        panel_1.add(btnEnregistrer);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearPanel(panel_1);
            }
        });
        btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnAnnuler.setBounds(250, 250, 120, 30);
        panel_1.add(btnAnnuler);

        frame.revalidate();
        frame.repaint();
    }

    private void openRapportHebdomadaireDialog() {
        clearPanel(panel_1);

        JLabel lblTitre = new JLabel("Reporting hebdomadaire");
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitre.setForeground(Color.GREEN);
        lblTitre.setBounds(10, 10, 464, 30);
        panel_1.add(lblTitre);

        JLabel lblUtilisateur = new JLabel("Utilisateur:");
        lblUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblUtilisateur.setBounds(50, 60, 100, 20);
        panel_1.add(lblUtilisateur);

        JTextField textFieldUtilisateur = new JTextField();
        textFieldUtilisateur.setBounds(160, 60, 300, 20);
        panel_1.add(textFieldUtilisateur);
        textFieldUtilisateur.setColumns(10);

        JLabel lblDetails = new JLabel("Détails des maintenances:");
        lblDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblDetails.setBounds(50, 100, 200, 20);
        panel_1.add(lblDetails);

        JTextField textFieldDetails = new JTextField();
        textFieldDetails.setBounds(160, 130, 300, 20);
        panel_1.add(textFieldDetails);
        textFieldDetails.setColumns(10);

        JLabel lblStatistiques = new JLabel("Statistiques:");
        lblStatistiques.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblStatistiques.setBounds(50, 170, 100, 20);
        panel_1.add(lblStatistiques);

        JTextField textFieldStatistiques = new JTextField();
        textFieldStatistiques.setBounds(160, 170, 300, 20);
        panel_1.add(textFieldStatistiques);
        textFieldStatistiques.setColumns(10);

        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String utilisateur = textFieldUtilisateur.getText().trim();
                String details = textFieldDetails.getText().trim();
                String statistiques = textFieldStatistiques.getText().trim();

                if (utilisateur.isEmpty() || details.isEmpty() || statistiques.isEmpty()) {
                    JLabel lblErreur = new JLabel("Tous les champs doivent être remplis !");
                    lblErreur.setForeground(Color.RED);
                    lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
                    lblErreur.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    lblErreur.setBounds(10, 30, 264, 30);
                    panel_1.add(lblErreur);
                } else {
                    afficherInformationsEnregistrees(utilisateur, details, statistiques);
                }
            }
        });
        btnEnregistrer.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnEnregistrer.setBounds(100, 250, 120, 30);
        panel_1.add(btnEnregistrer);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearPanel(panel_1);
            }
        });
        btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnAnnuler.setBounds(250, 250, 120, 30);
        panel_1.add(btnAnnuler);

        frame.revalidate();
        frame.repaint();
    }

    private void openRapportMensuelDialog() {
        clearPanel(panel_1);

        JLabel lblTitre = new JLabel("Reporting mensuel");
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitre.setForeground(Color.GREEN);
        lblTitre.setBounds(10, 10, 464, 30);
        panel_1.add(lblTitre);

        JLabel lblUtilisateur = new JLabel("Utilisateur:");
        lblUtilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblUtilisateur.setBounds(50, 60, 100, 20);
        panel_1.add(lblUtilisateur);

        JTextField textFieldUtilisateur = new JTextField();
        textFieldUtilisateur.setBounds(160, 60, 300, 20);
        panel_1.add(textFieldUtilisateur);
        textFieldUtilisateur.setColumns(10);

        JLabel lblDetails = new JLabel("Détails des maintenances:");
        lblDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblDetails.setBounds(50, 100, 200, 20);
        panel_1.add(lblDetails);

        JTextField textFieldDetails = new JTextField();
        textFieldDetails.setBounds(160, 130, 300, 20);
        panel_1.add(textFieldDetails);
        textFieldDetails.setColumns(10);

        JLabel lblStatistiques = new JLabel("Statistiques:");
        lblStatistiques.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblStatistiques.setBounds(50, 170, 100, 20);
        panel_1.add(lblStatistiques);

        JTextField textFieldStatistiques = new JTextField();
        textFieldStatistiques.setBounds(160, 170, 300, 20);
        panel_1.add(textFieldStatistiques);
        textFieldStatistiques.setColumns(10);

        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String utilisateur = textFieldUtilisateur.getText().trim();
                String details = textFieldDetails.getText().trim();
                String statistiques = textFieldStatistiques.getText().trim();

                if (utilisateur.isEmpty() || details.isEmpty() || statistiques.isEmpty()) {
                    JLabel lblErreur = new JLabel("Tous les champs doivent être remplis !");
                    lblErreur.setForeground(Color.RED);
                    lblErreur.setHorizontalAlignment(SwingConstants.CENTER);
                    lblErreur.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    lblErreur.setBounds(10, 30, 264, 30);
                    panel_1.add(lblErreur);
                } else {
                    afficherInformationsEnregistrees(utilisateur, details, statistiques);
                }
            }
        });
        btnEnregistrer.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnEnregistrer.setBounds(100, 250, 120, 30);
        panel_1.add(btnEnregistrer);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearPanel(panel_1);
            }
        });
        btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnAnnuler.setBounds(250, 250, 120, 30);
        panel_1.add(btnAnnuler);

        frame.revalidate();
        frame.repaint();
    }

    private void afficherInformationsEnregistrees(String utilisateur, String details, String statistiques) {
        // Méthode pour traiter les informations enregistrées, par exemple, les afficher dans la console.
        System.out.println("Utilisateur: " + utilisateur);
        System.out.println("Détails des maintenances: " + details);
        System.out.println("Statistiques: " + statistiques);
    }

    private void clearPanel(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }
}
