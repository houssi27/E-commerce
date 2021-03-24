
package ss;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logiciel.Facture;
import logiciel.HistAchat;
import logiciel.cmdfourn;
import pres.interfaceProds;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class interfacegestion extends JFrame {

	private JPanel contentPane, panel_4, panel_3;
	private JTable tableau;
	public String[] entetes = { "Nom", "Prenom", "Telephone", "Adresse", "Nom des produits", "Date de livraison" };
	public String[] entetes1 = { "Nom", "Prenom", "Telephone", "Adresse" };
	public Object donnees[][] = new Object[40][6];
	public Object donnees1[][] = new Object[40][6];
	private JTable table;
	public JButton P1, P2, P3, b11, b12, b13, b14;
	public int modifier = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfacegestion frame = new interfacegestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfacegestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 255));
		panel_1.setBounds(0, 0, 871, 92);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(0, 404, 148, 155);
		panel.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setVisible(false);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(147, 201, 724, 358);
		panel.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);

		JButton P1_1 = new JButton("    Ajouter");
		P1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == 1) {
					ajoutclient c3 = new ajoutclient();
					c3.setVisible(true);

				}
				if (modifier == 2) {
					ajoutfour c4 = new ajoutfour();
					c4.setVisible(true);

				}
			}
		});
		P1_1.setBounds(6, 93, 136, 39);
		panel_6.add(P1_1);
		P1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		P1_1.setIcon(new ImageIcon("/Users/fd/Downloads/user (7).png"));
		P1_1.setHorizontalAlignment(SwingConstants.LEADING);

		JButton P3_1 = new JButton("    Modifier");
		P3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modifier == 1) {
					modifierclient c1 = new modifierclient();
					c1.setVisible(true);

				}
				if (modifier == 2) {
					modifierfour c2 = new modifierfour();
					c2.setVisible(true);

				}
			}
		});
		P3_1.setBounds(6, 42, 136, 39);
		panel_6.add(P3_1);
		P3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		P3_1.setIcon(new ImageIcon("/Users/fd/Downloads/user (6).png"));
		P3_1.setHorizontalAlignment(SwingConstants.LEADING);

		JLabel lblG = new JLabel("Magasin de vente en ligne");
		lblG.setForeground(new Color(255, 255, 255));
		lblG.setFont(new Font("Chalkduster", Font.PLAIN, 46));
		lblG.setHorizontalAlignment(SwingConstants.CENTER);
		lblG.setBounds(6, 6, 805, 80);
		panel_1.add(lblG);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null, "Voulez-vous déconnecté ?", "Déconnexion", 1, 1);
				acceuil b = new acceuil();
				b.setVisible(true);
				dispose();
			}
		});
		label.setIcon(new ImageIcon("/Users/fd/Downloads/logout-sign.png"));
		label.setBounds(819, 6, 46, 85);
		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_2.setForeground(Color.WHITE);
		panel_2.setBounds(0, 91, 881, 111);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton b1 = new JButton("");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
				interfaceProds z = new interfaceProds();
				z.setVisible(true);
				dispose();
			}
		});
		b1.setIcon(new ImageIcon("/Users/fd/Downloads/box.png"));
		b1.setBounds(6, 6, 74, 81);
		panel_2.add(b1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 712, 346);
		panel_4.add(scrollPane);

		JButton b2 = new JButton("");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier = 1;
				panel_4.setVisible(false);
				panel_4.setVisible(true);
				panel_6.setVisible(true);
				scrollPane.setViewportView(table);
				Connection connection;
				Statement statement;
				Statement stat;
				connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");
					statement = connection.createStatement();
					statement.setQueryTimeout(30);

					stat = connection.createStatement();
					stat.setQueryTimeout(30);
					String query = null;
					query = "select * from client";
					ResultSet res = stat.executeQuery(query);
					int i = 0;
					while (res.next()) {

						donnees1[i][0] = res.getString("Nom");
						donnees1[i][1] = res.getString("Prenom");
						donnees1[i][2] = res.getString("Telephone");
						donnees1[i][3] = res.getString("Adresse");

						i++;
					}
				} catch (Exception e6) {

				}
			}
		});

		b2.setIcon(new ImageIcon("/Users/fd/Downloads/boy.png"));
		b2.setBounds(95, 6, 74, 81);
		panel_2.add(b2);

		JButton b3 = new JButton("");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier = 2;
				panel_4.setVisible(false);
				panel_4.setVisible(true);
				panel_6.setVisible(true);
				scrollPane.setViewportView(tableau);
				Connection connection;
				Statement statement;
				Statement stat;
				connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");
					statement = connection.createStatement();
					statement.setQueryTimeout(30);

					stat = connection.createStatement();
					stat.setQueryTimeout(30);
					String query = null;
					query = "select * from fournisseur";
					ResultSet res = stat.executeQuery(query);
					int i = 0;
					while (res.next()) {

						donnees[i][0] = res.getString("Nom");
						donnees[i][1] = res.getString("Prenom");
						donnees[i][2] = res.getString("Telephone");
						donnees[i][3] = res.getString("Adresse");
						donnees[i][4] = res.getString("Nom des produits");
						donnees[i][5] = res.getString("Date de livraison");
						i++;
					}
				} catch (Exception e6) {
				}
			}
		});
		b3.setIcon(new ImageIcon("/Users/fd/Downloads/salesman.png"));
		b3.setBounds(181, 6, 74, 81);
		panel_2.add(b3);

		JButton b4 = new JButton("");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		b4.setIcon(new ImageIcon("/Users/fd/Downloads/shopping-bag.png"));
		b4.setBounds(267, 6, 74, 81);
		panel_2.add(b4);

		JButton b5 = new JButton("");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
				HistAchat z1 = new HistAchat();
				z1.setVisible(true);
			}
		});
		b5.setIcon(new ImageIcon("/Users/fd/Downloads/cart.png"));
		b5.setBounds(353, 6, 74, 81);
		panel_2.add(b5);

		JButton b6 = new JButton("");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		b6.setIcon(new ImageIcon("/Users/fd/Downloads/receipt.png"));
		b6.setBounds(439, 6, 74, 81);
		panel_2.add(b6);

		JButton b7 = new JButton("");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
				cmdfourn z2 = new cmdfourn();
				z2.setVisible(true);
			}
		});
		b7.setIcon(new ImageIcon("/Users/fd/Downloads/indent-all.png"));
		b7.setBounds(525, 6, 74, 81);
		panel_2.add(b7);

		JButton b8 = new JButton("");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		b8.setIcon(new ImageIcon("/Users/fd/Downloads/check.png"));
		b8.setBounds(611, 6, 74, 81);
		panel_2.add(b8);

		JLabel lblNewLabel = new JLabel("Produits");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 89, 74, 16);
		panel_2.add(lblNewLabel);

		JLabel lblClients = new JLabel("Clients");
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setBounds(97, 89, 61, 16);
		panel_2.add(lblClients);

		JLabel lblFournisseurs = new JLabel("Fournisseurs");
		lblFournisseurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFournisseurs.setBounds(170, 89, 92, 16);
		panel_2.add(lblFournisseurs);

		JLabel lblVentes = new JLabel("Ventes");
		lblVentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentes.setBounds(267, 89, 61, 16);
		panel_2.add(lblVentes);

		JLabel lblAchats = new JLabel("Achats");
		lblAchats.setHorizontalAlignment(SwingConstants.CENTER);
		lblAchats.setBounds(353, 89, 74, 16);
		panel_2.add(lblAchats);

		JLabel lblPerformas = new JLabel("Performas");
		lblPerformas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerformas.setBounds(439, 89, 74, 16);
		panel_2.add(lblPerformas);

		JLabel lblCommandes = new JLabel("Commandes");
		lblCommandes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommandes.setBounds(517, 89, 92, 16);
		panel_2.add(lblCommandes);

		JLabel lblRglements = new JLabel("Réglements");
		lblRglements.setBounds(611, 89, 74, 16);
		panel_2.add(lblRglements);

		JLabel lblPaiements = new JLabel("Paiements");
		lblPaiements.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaiements.setBounds(703, 89, 74, 16);
		panel_2.add(lblPaiements);

		JButton b9 = new JButton("");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
				Facture z3 = new Facture();
				z3.setVisible(true);
			}
		});
		b9.setIcon(new ImageIcon("/Users/fd/Downloads/change.png"));
		b9.setBounds(703, 6, 74, 81);
		panel_2.add(b9);

		JLabel lblTableauDe = new JLabel("Statistiques");
		lblTableauDe.setBounds(789, 89, 74, 16);
		panel_2.add(lblTableauDe);

		JButton b10 = new JButton("");
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
				statistique z = new statistique();
				z.setVisible(true);
			}
		});
		b10.setIcon(new ImageIcon("/Users/fd/Downloads/pie-chart.png"));
		b10.setBounds(789, 6, 74, 81);
		panel_2.add(b10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 201, 148, 358);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton b11 = new JButton("    Données");
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		b11.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b11.setHorizontalAlignment(SwingConstants.LEADING);
		b11.setIcon(new ImageIcon("/Users/fd/Downloads/folder.png"));
		b11.setBounds(6, 6, 136, 39);
		panel_3.add(b11);

		JButton b12 = new JButton("    Gestion");
		b12.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b12.setHorizontalAlignment(SwingConstants.LEADING);
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		b12.setIcon(new ImageIcon("/Users/fd/Downloads/presentation.png"));
		b12.setBounds(6, 57, 136, 39);
		panel_3.add(b12);

		JButton b13 = new JButton("    Statistiques");
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
				statistique z1 = new statistique();
				z1.setVisible(true);
			}
		});
		b13.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		b13.setHorizontalAlignment(SwingConstants.LEADING);
		b13.setIcon(new ImageIcon("/Users/fd/Downloads/graph (4).png"));
		b13.setBounds(6, 108, 136, 39);
		panel_3.add(b13);

		JButton B14 = new JButton("    Outils");
		B14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
			}
		});
		B14.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		B14.setHorizontalAlignment(SwingConstants.LEADING);
		B14.setIcon(new ImageIcon("/Users/fd/Downloads/settings.png"));
		B14.setBounds(6, 159, 136, 39);
		panel_3.add(B14);

		tableau = new JTable(donnees, entetes);
		tableau.setColumnSelectionAllowed(true);
		tableau.setBorder(UIManager.getBorder("Button.border"));

		table = new JTable(donnees1, entetes1);
		table.setColumnSelectionAllowed(true);
		table.setBorder(UIManager.getBorder("Button.border"));

		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);

		JMenu mnNewMenu = new JMenu("Fichier");
		menuBar.add(mnNewMenu);

		JMenuItem mntmParamtres = new JMenuItem("Paramètres");
		mnNewMenu.add(mntmParamtres);

		JMenuItem mntmNewMenuItem = new JMenuItem("Déconnexion");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceuil b = new acceuil();
		b.setVisible(true);
		dispose();
				
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quitter");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("Outils");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Date et heure");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				JOptionPane.showMessageDialog(null, date, "Heure et date", 1);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Calculatrice");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exercice33 a2 = new exercice33();
				a2.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenu mnApropos = new JMenu("A propos");
		mnApropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnApropos);

		JMenuItem mntmApropos = new JMenuItem("   Developpeurs");
		mntmApropos.setIcon(new ImageIcon("/Users/fd/Downloads/about-us (1).png"));
		mntmApropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_6.setVisible(false);
				panel_4.setVisible(false);
				apropos a2 = new apropos();
				a2.setVisible(true);
			}
		});
		mnApropos.add(mntmApropos);
	}
}
