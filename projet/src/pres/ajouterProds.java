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
import javax.swing.border.EmptyBorder;import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import metier.Categorie;
import metier.MetiercatalogueImpl;
import metier.Produit;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JSlider;

public class ajouterProds extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterProds frame = new ajouterProds();
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
	private MetiercatalogueImpl metier=new MetiercatalogueImpl();
	Categorie cat=new Categorie();
	
	public ajouterProds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(430, 130, 800, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 784, 80);
		getContentPane().add(panel);
		JLabel lblGestionproduits = new JLabel("AJOUTER PRODUIT");
		lblGestionproduits.setForeground(new Color(240, 248, 255));
		lblGestionproduits.setFont(new Font("Papyrus", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblGestionproduits);
		
		List<String> s=metier.gatAllcategorie();
		JComboBox comboBox = new JComboBox();
		for(int i=0;i<s.size();i++)comboBox.addItem(s.get(i));
		comboBox.setBounds(359, 119, 148, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(141, 226, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lbl_img = new JLabel("");
		lbl_img.setBackground(UIManager.getColor("Button.disabledShadow"));
		lbl_img.setBounds(10, 80, 196, 142);
		contentPane.add(lbl_img);
		JButton btnNewButton = new JButton("Image");
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser=new JFileChooser();
			chooser.showOpenDialog(null);
			File f=chooser.getSelectedFile();
			String filename=f.getAbsolutePath();
			textField.setText(filename);
			ImageIcon prods=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lbl_img.getWidth(),lbl_img.getHeight(),Image.SCALE_SMOOTH));
			lbl_img.setIcon(prods);
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		});
		btnNewButton.setBounds(42, 224, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(45, 285, 172, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(45, 356, 172, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(359, 168, 159, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(359, 226, 159, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.setForeground(new Color(30, 144, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			MetiercatalogueImpl c=new MetiercatalogueImpl();
        	int a=0;
			public void actionPerformed(ActionEvent e) {
				List<Produit> prods;
				prods=c.getproduitsParMC("");
					for(Produit p:prods) {
					if(p.getNomProduit().equals(textField_1.getText()))	{a=1;break;}
					}	
						
			if(a==1 || textField.getText().isEmpty() || textField_2.getText().isEmpty() ||textField_3.getText().isEmpty()|| textField_4.getText().isEmpty() || textField_5.getText().isEmpty() ) {
							 JOptionPane jop3 = new JOptionPane();
							 jop3.showMessageDialog(null, "vous devez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
							 a=0;
						 }

						 else { 
							 Produit p=new Produit();
							 
							 p.setNomProduit(textField_2.getText());
							 p.setRefProduit(textField_1.getText());
							 p.setPrix(Double.valueOf(textField_5.getText()));
							 p.setPrix2(Double.valueOf(textField_3.getText()));
							 p.setQuantite(Integer.valueOf(textField_4.getText()));
							 p.setImage(textField.getText());
							 c.addProduit(p,comboBox.getSelectedItem().toString());
						 JOptionPane jop1 = new JOptionPane();
						 jop1.showMessageDialog(null, "L'ajout d'un produit", "Vous avez ajout� le produit", JOptionPane.INFORMATION_MESSAGE);
						 textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_3.setText("");
							lbl_img.setIcon(null);
						 
					}}
				});
		
		btnNewButton_1.setBounds(99, 413, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Nouveau");
		btnNewButton_2.setForeground(new Color(30, 144, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_3.setText("");
				lbl_img.setIcon(null);
			}
		});
		btnNewButton_2.setBounds(240, 413, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Annuler");
		btnNewButton_3.setForeground(new Color(30, 144, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaceProds inte=new interfaceProds();
				inte.setVisible(false);
				inte.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_3.setBounds(356, 413, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblRfrence = new JLabel("R\u00E9f\u00E9rence");
		lblRfrence.setForeground(new Color(30, 144, 255));
		lblRfrence.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblRfrence.setBounds(43, 270, 79, 14);
		contentPane.add(lblRfrence);
		
		JLabel lblNomproduit = new JLabel("Nom_Produit");
		lblNomproduit.setForeground(new Color(30, 144, 255));
		lblNomproduit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNomproduit.setBounds(42, 342, 102, 14);
		contentPane.add(lblNomproduit);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9");
		lblQuantit.setForeground(new Color(30, 144, 255));
		lblQuantit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblQuantit.setBounds(359, 155, 79, 14);
		contentPane.add(lblQuantit);
		
		JLabel lblPrix = new JLabel("Prix d'achat");
		lblPrix.setForeground(new Color(30, 144, 255));
		lblPrix.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPrix.setBounds(359, 211, 79, 14);
		contentPane.add(lblPrix);
		
		
		JLabel lblCategorie = new JLabel("Cat\u00E9gorie");
		lblCategorie.setForeground(new Color(30, 144, 255));
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblCategorie.setBounds(359, 102, 79, 14);
		contentPane.add(lblCategorie);
		
		JLabel label = new JLabel("");
		label.setBounds(587, 220, 100, 100);
		contentPane.add(label);
		ImageIcon prods=new ImageIcon(new ImageIcon("/Users/fd/eclipse-workspace/projet/src/pres/ajou.jpg").getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH));
		label.setIcon(prods);
		
		textField_3 = new JTextField();
		textField_3.setBounds(363, 356, 159, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPrixDeVente = new JLabel("Prix de vente");
		lblPrixDeVente.setForeground(new Color(30, 144, 255));
		lblPrixDeVente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPrixDeVente.setBounds(363, 343, 89, 14);
		contentPane.add(lblPrixDeVente);
		
		JLabel porsontage = new JLabel("");
		porsontage.setBounds(533, 282, 47, 23);
		contentPane.add(porsontage);
		
		
		JSlider profitMargin = new JSlider();
		profitMargin.setBounds(359, 285, 164, 23);
		contentPane.add(profitMargin);
		profitMargin.setValue(0);
		profitMargin.setMinimum(-100);
		//profitMargin.addChangeListener(new ChangeListener);
		profitMargin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				try {
					int percentage = profitMargin.getValue();
					double costp = Double.parseDouble(textField_5.getText());
					porsontage.setText(String.valueOf(profitMargin.getValue()) + "%");
					textField_3.setText(String.valueOf((double) (costp + costp * percentage * 0.01)));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid Cost Price.", "Error",
							JOptionPane.ERROR_MESSAGE);
					textField_5.setBorder(BorderFactory.createLineBorder(Color.red));
				}

			}
		});
		JLabel lblMargeDeProfit = new JLabel("Marge de profit");
		lblMargeDeProfit.setForeground(new Color(30, 144, 255));
		lblMargeDeProfit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblMargeDeProfit.setBounds(359, 270, 113, 14);
		contentPane.add(lblMargeDeProfit);
		
		
	}
}
