package ss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class acceuil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acceuil frame = new acceuil();
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
	public acceuil() {
		setTitle("Logiciel de magasin de vente en ligne");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 255));
		panel_1.setBounds(0, 0, 710, 96);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAcceuil = new JLabel("Acceuil");
		lblAcceuil.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcceuil.setFont(new Font("Chalkduster", Font.PLAIN, 50));
		lblAcceuil.setForeground(new Color(255, 255, 255));
		lblAcceuil.setBounds(151, 0, 412, 96);
		panel_1.add(lblAcceuil);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/fd/Downloads/home.png"));
		lblNewLabel.setBounds(6, 6, 96, 84);
		panel_1.add(lblNewLabel);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login a2 = new login();
				a2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("/Users/fd/Downloads/manager (2).png"));
		btnNewButton.setBounds(10, 108, 332, 278);
		panel.add(btnNewButton);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logingestion a = new logingestion();
				a.setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("/Users/fd/Downloads/boss (3).png"));
		button.setBounds(372, 108, 332, 278);
		panel.add(button);

		JLabel lblGestionnaire = new JLabel("GESTIONNAIRE");
		lblGestionnaire.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionnaire.setForeground(new Color(102, 153, 255));
		lblGestionnaire.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblGestionnaire.setBounds(372, 395, 326, 52);
		panel.add(lblGestionnaire);

		JLabel label_1 = new JLabel("ADMINISTRATEUR");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(new Color(102, 153, 255));
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label_1.setBounds(0, 398, 342, 52);
		panel.add(label_1);
	}
}
