package pres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GestionDeStock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDeStock frame = new GestionDeStock();
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
	public GestionDeStock() {
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(430, 130, 600, 500);
		
		getContentPane().setLayout(null);
	    ImageIcon stock=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/st.jpg");
	    
		JLabel Lblimg = new JLabel(stock);
		Lblimg.setBackground(new Color(255, 255, 255));
		Lblimg.setBounds(0, 186, 584, 216);
		getContentPane().add(Lblimg);
		ImageIcon prods=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/stock.png");
		JButton btnprod = new JButton(prods);
		btnprod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				interfaceProds pr=new interfaceProds();
				
		        pr.setVisible(true);
		        setVisible(false);
			}
		});
		btnprod.setBackground(new Color(255, 255, 255));
		
		btnprod.setBounds(96, 83, 64, 64);
	    getContentPane().add(btnprod);
		
		ImageIcon fourni=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/businessman.png");
		JButton btnfourn = new JButton();
		btnfourn.setIcon(fourni);
		btnfourn.setForeground(Color.BLACK);
		btnfourn.setBackground(Color.WHITE);
		btnfourn.setBounds(274, 83, 64, 64);
		getContentPane().add(btnfourn);
		ImageIcon cmd=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/clipboard.png");
		JButton btncmd = new JButton(cmd);
		btncmd.setBackground(new Color(255, 255, 255));
		btncmd.setBounds(421, 83, 64, 64);
		getContentPane().add(btncmd);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 564, 61);
		getContentPane().add(panel);
		
		JLabel lblGestionDeStock = new JLabel("GESTION DE STOCK");
		lblGestionDeStock.setForeground(new Color(240, 248, 255));
		lblGestionDeStock.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblGestionDeStock);
		
		JLabel lblNewLabel = new JLabel("Produits");
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setBounds(96, 158, 64, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fournisseurs");
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setBounds(274, 161, 76, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Commandes");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setBounds(421, 158, 76, 14);
		getContentPane().add(lblNewLabel_2);
	}

}
