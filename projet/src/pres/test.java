package pres;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGestionDeStock = new JLabel("     Gestion De Stock   ");
		lblGestionDeStock.setForeground(Color.LIGHT_GRAY);
		lblGestionDeStock.setToolTipText("");
		lblGestionDeStock.setBackground(Color.BLUE);
		lblGestionDeStock.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblGestionDeStock.setBounds(72, 101, 251, 63);
		frame.getContentPane().add(lblGestionDeStock);
		
		JButton btnNewButton = new JButton("malki");
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(62, 78, 89, 49);
		frame.getContentPane().add(btnNewButton);
	}

}
