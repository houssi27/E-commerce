package pres;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.MetiercatalogueImpl;
import metier.Produit;
import ss.interfacegestion;

import javax.security.auth.Refreshable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;


import javax.swing.border.LineBorder;

public class interfaceProds extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	   private ProduitModel produitModel;
	   private MetiercatalogueImpl metier=new MetiercatalogueImpl();	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceProds frame = new interfaceProds();
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
	public interfaceProds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(430, 130, 900, 600);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 884, 69);
		getContentPane().add(panel);
		panel.setLayout(null);
		ImageIcon retour=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/return-button.png");
		JLabel lblGestionproduits = new JLabel("GERER PRODUITS");
		lblGestionproduits.setBounds(299, 10, 374, 48);
		lblGestionproduits.setForeground(new Color(240, 248, 255));
		lblGestionproduits.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblGestionproduits);
		produitModel=new ProduitModel();
		List<Produit> p=  metier.getproduitsParMC("");
        produitModel.loaddata(p);
		JTable table=new JTable(produitModel);
		table.setForeground(new Color(30, 144, 255));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBounds(20, 196, 532, 282);
		contentPane.add(scrollPane);
		ImageIcon add=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/add.png");
		JButton btnadd = new JButton(add);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajouterProds ajou=new ajouterProds();
				ajou.setVisible(true);
				setVisible(false);
			}
		});
		btnadd.setBackground(new Color(255, 255, 255));
		btnadd.setBounds(20, 103, 64, 64);
		contentPane.add(btnadd);
		ImageIcon edit=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/edit.png");
		JButton btnedit = new JButton(edit);
		btnedit.addActionListener(new ActionListener() {
			int x=0;
			public void actionPerformed(ActionEvent e) {
			for(int i=0; i<= table.getRowCount();i++) {	 if(table.isRowSelected(i)) {modifierProds mod=new modifierProds();
				mod.setVisible(true);
			    //mod.getTextField_1().setText(table.getValueAt(i, 0).toString());
			    
			    mod.getTextField_2().setText(table.getValueAt(i, 1).toString());
			    mod.getTextField_4().setText(table.getValueAt(i, 4).toString());
			    mod.getTextField_5().setText(table.getValueAt(i, 2).toString());
			    mod.getTextField_3().setText(table.getValueAt(i, 3).toString());
			    mod.getTextField().setText(table.getValueAt(i, 5).toString());
			    mod.getComboBox().setSelectedItem(table.getValueAt(i, 6));
			    ImageIcon prods=new ImageIcon(new ImageIcon(table.getValueAt(i, 5).toString()).getImage().getScaledInstance(mod.getLbl_img().getWidth(),mod.getLbl_img().getHeight(),Image.SCALE_SMOOTH));
			    mod.getLbl_img().setIcon(prods);
				x=1;
				setVisible(false);
				break;	
				}}
		if(x==0)	 {JOptionPane jop3 = new JOptionPane();
		 jop3.showMessageDialog(null, "Vous devez choisir un enregistrement depuis la liste! ", "Erreur", JOptionPane.WARNING_MESSAGE);}
			}
		});
		
		
		
		btnedit.setBackground(new Color(255, 255, 255));
		btnedit.setBounds(83, 103, 64, 64);
		contentPane.add(btnedit);
		ImageIcon remove=new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/error.png");
		JButton btnremove = new JButton(remove);
		btnremove.addActionListener(new ActionListener() {
			int x=0;
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<= table.getRowCount();i++) {	 if(table.isRowSelected(i)) {x=1;
				JOptionPane jop = new JOptionPane();
				int r=jop.showConfirmDialog(null, "�tes-vous s�r de vouloir continue ?", "Confirmation de supprission", JOptionPane.YES_NO_OPTION);
				if ( r==0)
					
				{   MetiercatalogueImpl c=new MetiercatalogueImpl();
					Produit p=new Produit();
					p.setRefProduit(table.getValueAt(i, 0).toString());
					c.suppProduit(p);
					}
				List<Produit> p=  metier.getproduitsParMC("");
	            produitModel.loaddata(p);
				break;
				
				
				}
				}
				if(x==0) {JOptionPane jop3 = new JOptionPane();
				 jop3.showMessageDialog(null, "Vous devez choisir un enregistrement depuis la liste! ", "Erreur", JOptionPane.WARNING_MESSAGE);}
				
			
			}
		});
		
		btnremove.setForeground(new Color(255, 255, 255));
		btnremove.setBackground(new Color(255, 255, 255));
		btnremove.setBounds(144, 103, 64, 64);
		contentPane.add(btnremove);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(239, 125, 174, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("recherche");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt=textField.getText();
				List<Produit> p=  metier.getproduitsParMC(txt);
	            produitModel.loaddata(p);
			}
		});
		btnNewButton.setForeground(new Color(30, 144, 255));
		btnNewButton.setBounds(423, 125, 102, 23);
		contentPane.add(btnNewButton);
		
		JButton retour2 = new JButton("Retour");
		retour2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfacegestion z1 = new interfacegestion();
				z1.setVisible(true);
				dispose();
			}
		});
		retour2.setForeground(new Color(30, 144, 255));
		retour2.setBounds(523, 125, 102, 23);
		contentPane.add(retour2);
		
		JLabel label = new JLabel("");
		label.setBounds(678, 253, 160, 136);
		contentPane.add(label);
		ImageIcon prods=new ImageIcon(new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/produits.png").getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH));
		
		
		label.setIcon(prods);
		
		
	}
}
