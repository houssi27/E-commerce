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
import java.sql.SQLException;
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

public class statistique extends JFrame {

	private JPanel contentPane, panel_3, panel_2;
	private JComboBox combox;
	private String[] entetes = { "Nombre de vente", "produit", "Prix" };
	private Object donnees[][] = new Object[40][6];
	private String[] entetes2 = { "Nombre de vente", "produit", "Prix" };
	private Object donnees2[][] = new Object[40][6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statistique frame = new statistique();
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
	public statistique() {
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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 140, 424, 261);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblStatistique = new JLabel("STATISTIQUE");
		lblStatistique.setFont(new Font("Chalkduster", Font.PLAIN, 39));
		lblStatistique.setForeground(new Color(255, 255, 255));
		lblStatistique.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistique.setBounds(43, 6, 391, 62);
		panel_1.add(lblStatistique);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/fd/Downloads/analytics.png"));
		lblNewLabel.setBounds(6, 0, 73, 74);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 140, 424, 261);
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
			query = "select * from products order by price DESC";
			ResultSet res = stat.executeQuery(query);
			int i = 0;
			while (res.next()) {
				donnees[i][0] = res.getString("id");
				donnees[i][1] = res.getString("name");
				donnees[i][2] = res.getString("price") + " DA";
				i++;
			}
		} catch (Exception e6) {

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException y) {

				}
			}
		}
		Connection connection1;
		Statement statement1;
		Statement stat1;
		connection1 = null;
		try {
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:8889/GL1", "root", "root");

			statement1 = connection1.createStatement();
			statement1.setQueryTimeout(30);
			stat1 = connection1.createStatement();
			stat1.setQueryTimeout(30);
			String query = null;
			query = "select * from products order by name ";
			ResultSet res = stat1.executeQuery(query);
			int i = 0;
			while (res.next()) {
				donnees2[i][0] = res.getString("id");
				donnees2[i][1] = res.getString("name");
				donnees2[i][2] = res.getString("price") + " DA";
				i++;
			}
		} catch (Exception e6) {

		} finally {
			if (connection1 != null) {
				try {
					connection1.close();
				} catch (SQLException y) {

				}
			}
		}

		JTable tableau = new JTable(donnees, entetes);
		tableau.setColumnSelectionAllowed(true);
		tableau.setBorder(UIManager.getBorder("Button.border"));
		tableau.setBounds(0, 5, 418, 165);

		JTable tableau2 = new JTable(donnees2, entetes2);
		tableau2.setColumnSelectionAllowed(true);
		tableau2.setBorder(UIManager.getBorder("Button.border"));
		tableau2.setBounds(0, 5, 418, 165);

		JScrollPane scrollPane = new JScrollPane(tableau);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 413, 255);
		panel_2.add(scrollPane);

		panel.add(tableau.getTableHeader(), BorderLayout.NORTH);

		JScrollPane scrollPane_1 = new JScrollPane(tableau2);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 0, 413, 255);
		panel_3.add(scrollPane_1);

		panel.add(tableau2.getTableHeader(), BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Trier par :");
		lblNewLabel_1.setBounds(10, 86, 441, 19);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(104, 86, 331, 27);
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					panel_3.setVisible(true);
					panel_2.setVisible(false);
				}
				if (comboBox.getSelectedIndex() == 1) {
					panel_3.setVisible(false);
					panel_2.setVisible(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Nombre de vente", "Prix" }));
	}
}
