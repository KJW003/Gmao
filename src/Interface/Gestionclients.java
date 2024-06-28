package Interface;
	import javax.swing.*;

import DAO.ClientDAO;
import classes.Client;

import java.awt.*;
	import java.util.ArrayList;
	import java.util.List;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;

	public class Gestionclients {

	    JFrame frame;
	    private JPanel panel_2;
	    private JPanel panel_1;
	    private JPanel panel_3;

	    // Liste statique de clients pour l'exemple
	    private List<Client> clients ;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	                Gestionclients window = new Gestionclients();
	                window.frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }

	    /**
	     * @wbp.parser.entryPoint
	     */
	    public Gestionclients() {
	        initialize();
	    }

	    private void initialize() {
	    	clients =  ClientDAO.getListeClients();
	        frame = new JFrame();
	        frame.getContentPane().setBackground(SystemColor.activeCaption);
	        frame.setBounds(100, 100, 952, 643);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);

	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 938, 45);
	        panel.setBackground(new Color(255, 255, 255));
	        frame.getContentPane().add(panel);

	        JLabel lblNewLabel = new JLabel("GMAO");
	        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        panel.add(lblNewLabel);

	        panel_1 = new JPanel();
	        panel_1.setBackground(new Color(255, 179, 142));
	        panel_1.setBounds(0, 44, 938, 63);
	        frame.getContentPane().add(panel_1);
	        panel_1.setLayout(null);
	        
	        	        JLabel lblNewLabel_2 = new JLabel("Gestion clients");
	        	        lblNewLabel_2.setBounds(51, 0, 138, 63);
	        	        panel_1.add(lblNewLabel_2);
	        	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        	        
	        	        	        JButton btnNewButton_1 = new JButton("Ajouter client");
	        	        	        btnNewButton_1.setBounds(252, 0, 208, 63);
	        	        	        panel_1.add(btnNewButton_1);
	        	        	        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        	        	        
	        	        	        	        JButton btnNewButton_1_1 = new JButton("Afficher la liste");
	        	        	        	        btnNewButton_1_1.setBounds(488, 0, 208, 63);
	        	        	        	        panel_1.add(btnNewButton_1_1);
	        	        	        	        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        	        	        	        
	        	        	        	        	        JButton btnNewButton_1_2 = new JButton("Supprimer client");
	        	        	        	        	        btnNewButton_1_2.setBounds(720, 0, 208, 62);
	        	        	        	        	        panel_1.add(btnNewButton_1_2);
	        	        	        	        	        btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        	        	        	        
	        	        	        	        	        btnNewButton_1_1.addActionListener(e -> {
	        	        	        	        	            // Supprimer tous les composants actuels de panel_2 (y compris ceux de modification)
	        	        	        	        	            clearModifierClientWindow();
	        	        	        	        
	        	        	        	        	            // Vérifier s'il y a des clients enregistrés
	        	        	        	        	            if (clients.isEmpty()) {
	        	        	        	        	                JLabel lblAucunClient = new JLabel("Aucun client enregistré.");
	        	        	        	        	                lblAucunClient.setBounds(50, 50, 200, 20);
	        	        	        	        	                panel_2.add(lblAucunClient);
	        	        	        	        	            } else {
	        	        	        	        	                // Afficher la liste des clients
	        	        	        	        	                int yOffset = 20;
	        	        	        	        	                for (Client client : clients) {
	        	        	        	        	                    JLabel lblNomSociete = new JLabel("Nom de la société: " + client.getNom());
	        	        	        	        	                    lblNomSociete.setBounds(50, yOffset, 250, 20);
	        	        	        	        	                    panel_2.add(lblNomSociete);
	        	        	        	        
	        	        	        	        	                    JButton btnModifier = new JButton("Modifier");
	        	        	        	        	                    btnModifier.setBounds(350, yOffset, 100, 20);
	        	        	        	        	                    panel_2.add(btnModifier);
	        	        	        	        
	        	        	        	        	                    // ActionListener pour le bouton "Modifier"
	        	        	        	        	                    btnModifier.addActionListener(event -> {
	        	        	        	        	                        // Nettoyer le panel_2 avant de charger les données du client
	        	        	        	        	                        clearModifierClientWindow();
	        	        	        	        	                        
	        	        	        	        	                        //Charger les données du client dans le formulaire de modification
	        	        	        	        	                        JLabel lblIdModif = new JLabel("Id de la société:");
	        	        	        	        	                        lblIdModif.setBounds(50, 50, 150, 20);
	        	        	        	        	                        panel_2.add(lblIdModif);
	        	        	        	        	                        
	        	        	        	        	                        JTextField textFieldidModif = new JTextField(client.getId());
	        	        	        	        	                        textFieldidModif.setBounds(210, 50, 200, 20);
	        	        	        	        	                        panel_2.add(textFieldidModif);
	        	        	        	        	                        
	        	        	        	        	                        JLabel lblNomSocieteModif = new JLabel("Nom de la société:");
	        	        	        	        	                        lblNomSocieteModif.setBounds(50, 50, 150, 20);
	        	        	        	        	                        panel_2.add(lblNomSocieteModif);
	        	        	        	        
	        	        	        	        	                        JTextField textFieldNomSocieteModif = new JTextField(client.getNom());
	        	        	        	        	                        textFieldNomSocieteModif.setBounds(210, 50, 200, 20);
	        	        	        	        	                        panel_2.add(textFieldNomSocieteModif);
	        	        	        	        
	        	        	        	        	                        JLabel lblNumeroIFUModif = new JLabel("Numéro IFU:");
	        	        	        	        	                        lblNumeroIFUModif.setBounds(50, 100, 150, 20);
	        	        	        	        	                        panel_2.add(lblNumeroIFUModif);
	        	        	        	        
	        	        	        	        	                        JTextField textFieldIFUModif = new JTextField(client.getNumeroIFU());
	        	        	        	        	                        textFieldIFUModif.setBounds(210, 100, 200, 20);
	        	        	        	        	                        panel_2.add(textFieldIFUModif);
	        	        	        	        
	        	        	        	        	                        JLabel lblNumeroRCCMModif = new JLabel("Numéro RCCM:");
	        	        	        	        	                        lblNumeroRCCMModif.setBounds(50, 150, 150, 20);
	        	        	        	        	                        panel_2.add(lblNumeroRCCMModif);
	        	        	        	        
	        	        	        	        	                        JTextField textFieldRCCMModif = new JTextField(client.getRCCM());
	        	        	        	        	                        textFieldRCCMModif.setBounds(210, 150, 200, 20);
	        	        	        	        	                        panel_2.add(textFieldRCCMModif);
	        	        	        	        
	        	        	        	        	                        JLabel lblAdresseModif = new JLabel("Adresse de la société:");
	        	        	        	        	                        lblAdresseModif.setBounds(50, 200, 150, 20);
	        	        	        	        	                        panel_2.add(lblAdresseModif);
	        	        	        	        
	        	        	        	        	                        JTextField textFieldAdresseModif = new JTextField(client.getAdresse());
	        	        	        	        	                        textFieldAdresseModif.setBounds(210, 200, 200, 20);
	        	        	        	        	                        panel_2.add(textFieldAdresseModif);
	        	        	        	        
	        	        	        	        	                        JLabel lblCodeAPEModif = new JLabel("Code APE:");
	        	        	        	        	                        lblCodeAPEModif.setBounds(50, 250, 150, 20);
	        	        	        	        	                        panel_2.add(lblCodeAPEModif);
	        	        	        	        
	        	        	        	        	                        JTextField textFieldCodeAPEModif = new JTextField(client.getCodeAPE());
	        	        	        	        	                        textFieldCodeAPEModif.setBounds(210, 250, 200, 20);
	        	        	        	        	                        panel_2.add(textFieldCodeAPEModif);
	        	        	        	        
	        	        	        	        	                        // Boutons Enregistrer et Annuler pour la modification
	        	        	        	        	                        JButton btnEnregistrerModif = new JButton("Enregistrer");
	        	        	        	        	                        btnEnregistrerModif.setBounds(150, 300, 120, 30);
	        	        	        	        	                        panel_2.add(btnEnregistrerModif);
	        	        	        	        
	        	        	        	        	                        JButton btnAnnulerModif = new JButton("Annuler");
	        	        	        	        	                        btnAnnulerModif.setBounds(280, 300, 120, 30);
	        	        	        	        	                        panel_2.add(btnAnnulerModif);
	        	        	        	        
	        	        	        	        	                        // ActionListener pour le bouton Enregistrer (modification)
	        	        	        	        	                        btnEnregistrerModif.addActionListener(e1 -> {
	        	        	        	        	                            // Mettre à jour les valeurs du client
	        	        	        	        	                        	client.setId(Integer.parseInt(textFieldidModif.getText().trim()));
	        	        	        	        	                            client.setNom(textFieldNomSocieteModif.getText().trim());
	        	        	        	        	                            client.setNumeroIFU(textFieldIFUModif.getText().trim());
	        	        	        	        	                            client.setRCCM(textFieldRCCMModif.getText().trim());
	        	        	        	        	                            client.setAdresse(textFieldAdresseModif.getText().trim());
	        	        	        	        	                            client.setCodeAPE(textFieldCodeAPEModif.getText().trim());
	        	        	        	      
	        	        	        	        	                            // Afficher un message de confirmation
	        	        	        	        	                            JOptionPane.showMessageDialog(frame, "Client modifié avec succès!");
	        	        	        	        	                            
	        	        	        	        	                            //modif dans la DAO
	        	        	        	        	        	                ClientDAO monClientDAO = new ClientDAO();
	        	        	        	        	        					int retour = monClientDAO.mettreAJour(client);
	        	        	        	        	        					// affichage du nombre de lignes ajoutées
	        	        	        	        	        					// dans la bdd pour vérification
	        	        	        	        	        					System.out.println("" + retour + " ligne ajoutée ");
	        	        	        	        	        					if (retour == 1)
	        	        	        	        	        						JOptionPane.showMessageDialog(frame, "article ajouté !");
	        	        	        	        	        					else
	        	        	        	        	        						JOptionPane.showMessageDialog(frame, "erreur ajout article",
	        	        	        	        	        								"Erreur", JOptionPane.ERROR_MESSAGE);
	        	        	        	        	        					
	        	        	        	        	                            // Nettoyer le panel_2 après la modification
	        	        	        	        	                            clearModifierClientWindow();
	        	        	        	        	                        });
	        	        	        	        
	        	        	        	        	                        // ActionListener pour le bouton Annuler (modification)
	        	        	        	        	                        btnAnnulerModif.addActionListener(e2 -> {
	        	        	        	        	                            // Nettoyer le panel_2 après l'annulation
	        	        	        	        	                            clearModifierClientWindow();
	        	        	        	        	                        });
	        	        	        	        
	        	        	        	        	                        // Repaint et revalidate pour afficher les nouveaux composants
	        	        	        	        	                        panel_2.repaint();
	        	        	        	        	                        panel_2.revalidate();
	        	        	        	        	                    });
	        	        	        	        
	        	        	        	        	                    yOffset += 40; // Espacement vertical entre chaque client affiché
	        	        	        	        	                }
	        	        	        	        	            }
	        	        	        	        
	        	        	        	        	            // Bouton pour ajouter un nouveau client en bas de la liste
	        	        	        	        	            JButton btnAjouterNouveau = new JButton("Ajouter un nouveau client");
	        	        	        	        	            btnAjouterNouveau.setBounds(50, 400, 200, 30);
	        	        	        	        	            panel_2.add(btnAjouterNouveau);
	        	        	        	        
	        	        	        	        	            // ActionListener pour le bouton "Ajouter un nouveau client"
	        	        	        	        	            btnAjouterNouveau.addActionListener(event -> {
	        	        	        	        	                clearModifierClientWindow(); // Nettoyer le panel_2
	        	        	        	        	                btnNewButton_1.doClick(); // Simuler un clic sur "Ajouter client"
	        	        	        	        	            });
	        	        	        	        
	        	        	        	        	            // Repaint et revalidate pour afficher les nouveaux composants
	        	        	        	        	            panel_2.repaint();
	        	        	        	        	            panel_2.revalidate();
	        	        	        	        	        });
	        	        	        
	        	        	        	        btnNewButton_1.addActionListener(e -> {
	        	        	        	            // Supprimer tous les composants actuels de panel_2 (y compris ceux de modification)
	        	        	        	            clearModifierClientWindow();
	        	        	        
	        	        	        	            // Créer les composants pour ajouter un client
	        	        	        	            JLabel lblId = new JLabel("Id de la société:");
	        	        	        	            lblId.setBounds(50, 50, 150, 20);
	        	        	        	            panel_2.add(lblId);
	        	        	        
	        	        	        	            JTextField textFieldId = new JTextField();
	        	        	        	            textFieldId.setBounds(210, 50, 200, 20);
	        	        	        	            panel_2.add(textFieldId);

	        	        	        	            JLabel lblNomSociete = new JLabel("Nom de la société:");
	        	        	        	            lblNomSociete.setBounds(50, 50, 150, 20);
	        	        	        	            panel_2.add(lblNomSociete);
	        	        	        
	        	        	        	            JTextField textFieldNomSociete = new JTextField();
	        	        	        	            textFieldNomSociete.setBounds(210, 50, 200, 20);
	        	        	        	            panel_2.add(textFieldNomSociete);
	        	        	        
	        	        	        	            JLabel lblNumeroIFU = new JLabel("Numéro IFU:");
	        	        	        	            lblNumeroIFU.setBounds(50, 100, 150, 20);
	        	        	        	            panel_2.add(lblNumeroIFU);
	        	        	        
	        	        	        	            JTextField textFieldIFU = new JTextField();
	        	        	        	            textFieldIFU.setBounds(210, 100, 200, 20);
	        	        	        	            panel_2.add(textFieldIFU);
	        	        	        
	        	        	        	            JLabel lblNumeroRCCM = new JLabel("Numéro RCCM:");
	        	        	        	            lblNumeroRCCM.setBounds(50, 150, 150, 20);
	        	        	        	            panel_2.add(lblNumeroRCCM);
	        	        	        
	        	        	        	            JTextField textFieldRCCM = new JTextField();
	        	        	        	            textFieldRCCM.setBounds(210, 150, 200, 20);
	        	        	        	            panel_2.add(textFieldRCCM);
	        	        	        
	        	        	        	            JLabel lblAdresse = new JLabel("Adresse de la société:");
	        	        	        	            lblAdresse.setBounds(50, 200, 150, 20);
	        	        	        	            panel_2.add(lblAdresse);
	        	        	        
	        	        	        	            JTextField textFieldAdresse = new JTextField();
	        	        	        	            textFieldAdresse.setBounds(210, 200, 200, 20);
	        	        	        	            panel_2.add(textFieldAdresse);
	        	        	        
	        	        	        	            JLabel lblCodeAPE = new JLabel("Code APE:");
	        	        	        	            lblCodeAPE.setBounds(50, 250, 150, 20);
	        	        	        	            panel_2.add(lblCodeAPE);
	        	        	        
	        	        	        	            JTextField textFieldCodeAPE = new JTextField();
	        	        	        	            textFieldCodeAPE.setBounds(210, 250, 200, 20);
	        	        	        	            panel_2.add(textFieldCodeAPE);
	        	        	        
	        	        	        	            // Boutons Enregistrer et Annuler
	        	        	        	            JButton btnEnregistrer = new JButton("Enregistrer");
	        	        	        	            btnEnregistrer.setBounds(150, 300, 120, 30);
	        	        	        	            panel_2.add(btnEnregistrer);
	        	        	        
	        	        	        	            JButton btnAnnuler = new JButton("Annuler");
	        	        	        	            btnAnnuler.setBounds(280, 300, 120, 30);
	        	        	        	            panel_2.add(btnAnnuler);
	        	        	        
	        	        	        	            // ActionListener pour le bouton Enregistrer
	        	        	        	            btnEnregistrer.addActionListener(event -> {
	        	        	        	                // Récupérer les valeurs des champs
	        	        	        	                int ID = Integer.parseInt(textFieldId.getText().trim());
	        	        	        	            	String nomSociete = textFieldNomSociete.getText().trim();
	        	        	        	                String numeroIFU = textFieldIFU.getText().trim();
	        	        	        	                String numeroRCCM = textFieldRCCM.getText().trim();
	        	        	        	                String adresse = textFieldAdresse.getText().trim();
	        	        	        	                String codeAPE = textFieldCodeAPE.getText().trim();
	        	        	        
	        	        	        	                // Créer un nouvel objet Client
	        	        	        	                Client nouveauClient = new Client(ID, nomSociete, numeroIFU, numeroRCCM, adresse, codeAPE);
	        	        	        
	        	        	        	                //Ajout vers la DAO
	        	        	        	                ClientDAO monClientDAO = new ClientDAO();
	        	        	        					int retour = monClientDAO.ajouter(nouveauClient);
	        	        	        					// affichage du nombre de lignes ajoutées
	        	        	        					// dans la bdd pour vérification
	        	        	        					System.out.println("" + retour + " ligne ajoutée ");
	        	        	        					if (retour == 1)
	        	        	        						JOptionPane.showMessageDialog(frame, "article ajouté !");
	        	        	        					else
	        	        	        						JOptionPane.showMessageDialog(frame, "erreur ajout article",
	        	        	        								"Erreur", JOptionPane.ERROR_MESSAGE);
	        	        	        					
	        	        	        	                
	        	        	        	                // Afficher un message de confirmation
	        	        	        	                JOptionPane.showMessageDialog(frame, "Client enregistré avec succès!");
	        	        	        
	        	        	        	                // Nettoyer le panel_2 après l'enregistrement
	        	        	        	                clearModifierClientWindow();
	        	        	        	            });
	        	        	        
	        	        	        	            // Repaint et revalidate pour afficher les nouveaux composants
	        	        	        	            panel_2.repaint();
	        	        	        	            panel_2.revalidate();
	        	        	        	        });

	        panel_2 = new JPanel();
	        panel_2.setBackground(Color.WHITE);
	        panel_2.setBounds(250, 107, 689, 505);
	        frame.getContentPane().add(panel_2);
	        panel_2.setLayout(null);

	        panel_3 = new JPanel();
	        panel_3.setBackground(new Color(255, 128, 64));
	        panel_3.setBounds(0, 105, 250, 499);
	        frame.getContentPane().add(panel_3);
	        panel_3.setLayout(null);
	        
	        	        JButton btnNewButton = new JButton("Deconexion");
	        	        btnNewButton.setBounds(32, 454, 156, 21);
	        	        panel_3.add(btnNewButton);
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

	    private void clearModifierClientWindow() {
	        // Supprimer tous les composants de modification dans panel_2
	        panel_2.removeAll();
	        panel_2.repaint();
	        panel_2.revalidate();
	    }

	    
	}