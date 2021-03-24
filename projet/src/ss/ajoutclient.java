package ss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class ajoutclient extends JFrame {
	private JPanel contentPane;
	private JTextField pseudo;
	private JTextField nom;
	private JTextField prenom;
	private JTextField email;
	private JTextField telephone;
	private JPasswordField password;
	private JTextField adresse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutclient frame = new ajoutclient();
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
	public ajoutclient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/fd/Downloads/user (1).png"));
		setTitle("Ajouter client");
		setBounds(100, 100, 660, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(6, 6, 634, 69);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("AJOUTER CLIENT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Chalkduster", Font.PLAIN, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 622, 57);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/fd/Downloads/user (5).png"));
		lblNewLabel_1.setBounds(6, 86, 182, 255);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Pseudo");
		lblNewLabel_2.setForeground(new Color(0, 153, 255));
		lblNewLabel_2.setBounds(200, 92, 61, 16);
		panel.add(lblNewLabel_2);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 153, 255));
		lblPassword.setBounds(200, 133, 61, 16);
		panel.add(lblPassword);

		JLabel label_1 = new JLabel("Nom");
		label_1.setForeground(new Color(0, 153, 255));
		label_1.setBounds(200, 171, 61, 16);
		panel.add(label_1);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(new Color(0, 153, 255));
		lblPrenom.setBounds(200, 204, 61, 16);
		panel.add(lblPrenom);

		JLabel lblAdresse = new JLabel("Email");
		lblAdresse.setForeground(new Color(0, 153, 255));
		lblAdresse.setBounds(200, 242, 61, 16);
		panel.add(lblAdresse);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setForeground(new Color(0, 153, 255));
		lblTelephone.setBounds(200, 284, 75, 16);
		panel.add(lblTelephone);

		JLabel lblEmail = new JLabel("Adresse");
		lblEmail.setForeground(new Color(0, 153, 255));
		lblEmail.setBounds(200, 324, 61, 16);
		panel.add(lblEmail);

		pseudo = new JTextField();
		pseudo.setBounds(386, 87, 130, 26);
		panel.add(pseudo);
		pseudo.setColumns(10);

		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(386, 166, 130, 26);
		panel.add(nom);

		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(386, 199, 130, 26);
		panel.add(prenom);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(386, 237, 130, 26);
		panel.add(email);

		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(386, 279, 130, 26);
		panel.add(telephone);

		password = new JPasswordField();
		password.setBounds(386, 128, 130, 26);
		panel.add(password);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(306, 357, -72, 42);
		panel.add(btnNewButton);

		JButton btnComfirmer = new JButton("Réinisialiser");
		btnComfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pseudo.setText("");
				password.setText("");
				nom.setText("");
				prenom.setText("");
				email.setText("");
				telephone.setText("");
				adresse.setText("");
			}
		});
		btnComfirmer.setForeground(new Color(0, 153, 255));
		btnComfirmer.setBounds(341, 383, 117, 29);
		panel.add(btnComfirmer);

		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					String query = "insert into client (Pseudo,Password,Nom,Prenom,Email,Telephone,Adresse)values(?,?,?,?,?,?,?)";
					PreparedStatement statement1 = connection.prepareStatement(query);
					statement1.setString(1, pseudo.getText());
					statement1.setString(2, password.getText());
					statement1.setString(3, nom.getText());
					statement1.setString(4, prenom.getText());
					statement1.setString(5, email.getText());
					statement1.setString(6, telephone.getText());
					statement1.setString(7, adresse.getText());
					statement1.execute();
					JOptionPane.showMessageDialog(null, "Ajout reussi !");
					/*
					 * interfaceadmin a = new interfaceadmin(); a.setVisible(true);
					 */
					dispose();
				} catch (SQLException e1) {
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
		btnConfirmer.setForeground(new Color(0, 153, 255));
		btnConfirmer.setBounds(212, 383, 117, 29);
		panel.add(btnConfirmer);

		adresse = new JTextField();
		adresse.setColumns(10);
		adresse.setBounds(386, 319, 130, 26);
		panel.add(adresse);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAnnuler.setForeground(new Color(0, 153, 255));
		btnAnnuler.setBounds(470, 383, 117, 29);
		panel.add(btnAnnuler);
	}
}
