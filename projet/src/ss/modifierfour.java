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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JComboBox;

public class modifierfour extends JFrame {
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField telephone;
	private JTextField adresse;
	private JTable table;
	public int a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifierfour frame = new modifierfour();
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
	public modifierfour() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/fd/Downloads/user (4).png"));
		setTitle("Modifier fournisseur");
		setBounds(100, 100, 660, 312);
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

		JLabel lblNewLabel = new JLabel("MODIFIER FOURNISSEUR");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Chalkduster", Font.PLAIN, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 622, 57);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/fd/Downloads/user (4).png"));
		lblNewLabel_1.setBounds(6, 86, 182, 129);
		panel.add(lblNewLabel_1);

		JLabel label_1 = new JLabel("Nom");
		label_1.setForeground(new Color(0, 153, 255));
		label_1.setBounds(200, 92, 61, 16);
		panel.add(label_1);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(new Color(0, 153, 255));
		lblPrenom.setBounds(200, 125, 61, 16);
		panel.add(lblPrenom);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setForeground(new Color(0, 153, 255));
		lblTelephone.setBounds(200, 194, 75, 16);
		panel.add(lblTelephone);

		JLabel lblEmail = new JLabel("Adresse");
		lblEmail.setForeground(new Color(0, 153, 255));
		lblEmail.setBounds(200, 158, 61, 16);
		panel.add(lblEmail);

		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(386, 87, 130, 26);
		panel.add(nom);

		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(386, 120, 130, 26);
		panel.add(prenom);

		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(386, 189, 130, 26);
		panel.add(telephone);

		adresse = new JTextField();
		adresse.setColumns(10);
		adresse.setBounds(386, 153, 130, 26);
		panel.add(adresse);

		Connection connection3;
		Statement statement3;
		connection3 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection3 = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");


			String query2 = "select count(*) from fournisseur";
			statement3 = connection3.createStatement();
			ResultSet r = statement3.executeQuery(query2);
			if(r.next()) {  a = Integer.parseInt(r.getString("count(*)"));}
		} catch (SQLException e2) {
			System.err.println(e2.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (connection3 != null) {
				try {
					connection3.close();
				} catch (SQLException y) {

				}
			}
		}
		String[] box = new String[a];

		Connection connection1;
		Statement statement1;
		connection1 = null;
		try {

			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");


			String query2 = "select id from fournisseur";
			statement1 = connection1.createStatement();
			ResultSet r1 = statement1.executeQuery(query2);
			// PreparedStatement statement1 = connection.prepareStatement(query);
			int j = 0;
			
			while (r1.next()) {
				box[j] = r1.getString("id");
				j++;
			}

		} catch (SQLException e1) {
			System.err.println(e1.getMessage());
		} finally {
			if (connection1 != null) {
				try {
					connection1.close();
				} catch (SQLException y) {

				}
			}
		}
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection connection;
				Statement statement;
				connection = null;
				try {
					

					connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");

					String a = (String) comboBox.getSelectedItem();
					String query2 = "select * from fournisseur where id=" + a;

					statement = connection.createStatement();
					ResultSet r = statement.executeQuery(query2);

					while (r.next()) {
						nom.setText(r.getString("Nom"));
						prenom.setText(r.getString("Prenom"));
						telephone.setText(r.getString("Telephone"));
						adresse.setText(r.getString("Adresse"));
					}

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
		comboBox.setModel(new DefaultComboBoxModel(box));
		comboBox.setBounds(565, 88, 75, 27);
		panel.add(comboBox);

		JButton Confirmer = new JButton("Confirmer");
		Confirmer.addActionListener(new ActionListener() {
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
					String query = "UPDATE fournisseur SET Nom=?,Prenom=?,Telephone=?,Adresse=? where id="
							+ comboBox.getSelectedItem();
					PreparedStatement statement1 = connection.prepareStatement(query);
					statement1.setString(1, nom.getText());
					statement1.setString(2, prenom.getText());
					statement1.setString(3, telephone.getText());
					statement1.setString(4, adresse.getText());

					statement1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update sucessfully");

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
		Confirmer.setForeground(new Color(0, 153, 255));
		Confirmer.setBounds(270, 241, 117, 29);
		panel.add(Confirmer);

		JButton Annuler = new JButton("Annuler");
		Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Annuler.setForeground(new Color(0, 153, 255));
		Annuler.setBounds(399, 241, 117, 29);
		panel.add(Annuler);

	}

	private static void forName(String string) {
		// TODO Auto-generated method stub
		
	}
}
