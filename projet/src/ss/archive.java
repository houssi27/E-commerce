package ss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class archive extends JFrame {

	private JPanel contentPane, panel_2;
	private JComboBox combox;
	private String[] entetes = { "Nom", "Prenom", "Telephone" };
	private Object donnees[][] = new Object[40][6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					archive frame = new archive();
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
	public archive() {
		setBounds(100, 100, 451, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 255));
		panel_1.setBounds(0, 0, 440, 74);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblStatistique = new JLabel("ARCHIVE");
		lblStatistique.setFont(new Font("Chalkduster", Font.PLAIN, 39));
		lblStatistique.setForeground(new Color(255, 255, 255));
		lblStatistique.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistique.setBounds(43, 6, 391, 62);
		panel_1.add(lblStatistique);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/fd/Downloads/office-material (1).png"));
		lblNewLabel.setBounds(6, 0, 73, 74);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 86, 424, 315);
		panel.add(panel_2);
		panel_2.setLayout(null);
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
			query = "select * from archivegest";
			ResultSet res = stat.executeQuery(query);
			int i = 0;
			while (res.next()) {
				donnees[i][0] = res.getString("nom");
				donnees[i][1] = res.getString("prenom");
				donnees[i][2] = res.getString("telephone");
				i++;
			}
		} catch (Exception e6) {

		}

		JTable tableau = new JTable(donnees, entetes);
		tableau.setColumnSelectionAllowed(true);
		tableau.setBorder(UIManager.getBorder("Button.border"));
		tableau.setBounds(0, 5, 418, 165);

		JScrollPane scrollPane = new JScrollPane(tableau);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 424, 309);
		panel_2.add(scrollPane);

		panel.add(tableau.getTableHeader(), BorderLayout.NORTH);
	}
}
