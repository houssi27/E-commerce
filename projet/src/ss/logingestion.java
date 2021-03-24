package ss;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class logingestion extends JFrame {

	private JPanel contentPane;
	private JTextField pseudo;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logingestion frame = new logingestion();
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
	public logingestion() {
		setTitle("Connexion gestionnaire");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		pseudo = new JTextField();
		pseudo.setBounds(131, 101, 171, 20);
		panel.add(pseudo);
		pseudo.setColumns(10);

		password = new JPasswordField();
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection;
				Statement statement;
				Statement stat;
				connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");
					statement = connection.createStatement();
					String query = "select * from gestionnaire where Pseudo=? and Password=?";
					PreparedStatement statement1 = connection.prepareStatement(query);
					statement1.setString(1, pseudo.getText());
					statement1.setString(2, password.getText());
					ResultSet rs = statement1.executeQuery();
					int count = 0;
					while (rs.next()) {
						count = count + 1;

					}
					if (count == 1) {
						interfacegestion a = new interfacegestion();
						a.setVisible(true);
						dispose();
					} else if (count > 1) {
						JOptionPane.showMessageDialog(null, "Nom d'utilisateur et Mot de passe sont duplique");
					} else {
						JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou Mot de passe est incorrect");
					}
					statement1.execute();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error");
					System.err.println(e1.getMessage());
				} finally {
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException y) {

						}
					}
				}
			}
		});
		password.setBounds(131, 155, 171, 20);
		panel.add(password);

		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setForeground(new Color(0, 153, 255));
		lblPseudo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPseudo.setBounds(131, 75, 171, 14);
		panel.add(lblPseudo);

		JLabel lblMotDePasse = new JLabel("Mot de Passe");
		lblMotDePasse.setForeground(new Color(0, 153, 255));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBounds(131, 132, 171, 14);
		panel.add(lblMotDePasse);

		JButton b1 = new JButton("Connecter");
		b1.setForeground(new Color(0, 153, 255));
		b1.setBackground(Color.GRAY);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection connection;
				Statement statement;
				Statement stat;
				connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:sqlite:/Users/fd/Downloads/GL1.db");
					statement = connection.createStatement();
					statement.setQueryTimeout(30);

					stat = connection.createStatement();
					stat.setQueryTimeout(30);
					String query = "select * from gestionnaire where Pseudo=? and Password=?";
					PreparedStatement statement1 = connection.prepareStatement(query);
					statement1.setString(1, pseudo.getText());
					statement1.setString(2, password.getText());
					ResultSet rs = statement1.executeQuery();
					int count = 0;
					while (rs.next()) {
						count = count + 1;

					}
					if (count == 1) {
						interfacegestion a = new interfacegestion();
						a.setVisible(true);
						dispose();
					} else if (count > 1) {
						JOptionPane.showMessageDialog(null, "Nom d'utilisateur et Mot de passe sont duplique");
					} else {
						JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou Mot de passe est incorrect");
					}
					statement1.execute();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error");
					System.err.println(e1.getMessage());
				} finally {
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException y) {

						}
					}
				}
			}
		});
		b1.setBounds(131, 195, 171, 23);
		panel.add(b1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 0, 440, 63);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblConnexionAdmin = new JLabel("CONNEXION GESTIONNAIRE");
		lblConnexionAdmin.setForeground(new Color(255, 255, 255));
		lblConnexionAdmin.setFont(new Font("Chalkduster", Font.PLAIN, 20));
		lblConnexionAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexionAdmin.setBounds(67, 6, 313, 51);
		panel_1.add(lblConnexionAdmin);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/fd/Downloads/boss.png"));
		lblNewLabel.setBounds(6, 1, 61, 64);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acceuil a1 = new acceuil();
				a1.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("/Users/fd/Downloads/return-button (1).png"));
		lblNewLabel_2.setBounds(383, 6, 51, 39);
		panel_1.add(lblNewLabel_2);

		JLabel lblRetour = new JLabel("Retour");
		lblRetour.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblRetour.setForeground(new Color(255, 255, 255));
		lblRetour.setBounds(383, 44, 51, 19);
		panel_1.add(lblRetour);

		JLabel lblNewLabel_1 = new JLabel("Mot de passe oublié ?");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("http://www.gmail.com").toURI());
				} catch (Exception e1) {
				}
			}

		});
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(51, 153, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(131, 230, 171, 16);
		panel.add(lblNewLabel_1);
	}
}
