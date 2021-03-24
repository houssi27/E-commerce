package ss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class interfaceadmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceadmin frame = new interfaceadmin();
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
	public interfaceadmin() {
		setTitle("ACCUIEL");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/fd/Downloads/letter-g (1).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 542);
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
		panel_1.setBounds(6, 6, 508, 92);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAdministration = new JLabel("ADMINISTRATION");
		lblAdministration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblAdministration.setForeground(new Color(255, 255, 255));
		lblAdministration.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministration.setFont(new Font("Chalkduster", Font.PLAIN, 43));
		lblAdministration.setBounds(6, 6, 451, 80);
		panel_1.add(lblAdministration);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login l = new login();
				l.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setIcon(new ImageIcon("/Users/fd/Downloads/logout-sign.png"));
		lblNewLabel.setBounds(456, 6, 46, 85);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statistique a2 = new statistique();
				a2.setVisible(true);

			}
		});
		btnNewButton.setIcon(new ImageIcon("/Users/fd/Downloads/graph (1).png"));
		btnNewButton.setBounds(40, 298, 177, 155);
		panel.add(btnNewButton);

		JLabel lblStatistique = new JLabel("Modifier");
		lblStatistique.setForeground(new Color(0, 153, 255));
		lblStatistique.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistique.setBounds(292, 270, 177, 16);
		panel.add(lblStatistique);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				modifier a1 = new modifier();
				a1.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("/Users/fd/Downloads/user (4).png"));
		button.setBounds(292, 110, 177, 155);
		panel.add(button);

		JLabel label = new JLabel("STATISTIQUE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 153, 255));
		label.setBounds(40, 465, 177, 16);
		panel.add(label);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ajout s = new ajout();
				s.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("/Users/fd/Downloads/user (5).png"));
		button_1.setBounds(40, 110, 177, 155);
		panel.add(button_1);

		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouter.setForeground(new Color(0, 153, 255));
		lblAjouter.setBounds(40, 270, 177, 16);
		panel.add(lblAjouter);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archive sII = new archive();
				sII.setVisible(true);
			}
		});
		button_2.setIcon(new ImageIcon("/Users/fd/Downloads/office-material.png"));
		button_2.setBounds(292, 298, 177, 155);
		panel.add(button_2);

		JLabel lblArchiveDesGestionnaires = new JLabel("ARCHIVE DES GESTIONNAIRES");
		lblArchiveDesGestionnaires.setHorizontalAlignment(SwingConstants.CENTER);
		lblArchiveDesGestionnaires.setForeground(new Color(0, 153, 255));
		lblArchiveDesGestionnaires.setBounds(292, 465, 187, 16);
		panel.add(lblArchiveDesGestionnaires);
	}
}
