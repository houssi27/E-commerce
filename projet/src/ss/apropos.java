package ss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class apropos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					apropos frame = new apropos();
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
	public apropos() {
		setTitle("A propos");
		setBounds(100, 100, 417, 541);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Développé par :");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(6, 6, 319, 33);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/fd/Downloads/26994166_2026531950926319_8839023918384862689_n.jpg"));
		lblNewLabel_1.setBounds(6, 51, 128, 128);
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/fd/Downloads/26993731_2026531920926322_4280815048099087249_n.jpg"));
		label.setBounds(6, 202, 128, 128);
		panel.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/Users/fd/Downloads/26994310_2026531997592981_5531467611944735363_n.jpg"));
		label_1.setBounds(6, 353, 128, 128);
		panel.add(label_1);

		JLabel lblNewLabel_2 = new JLabel("© 2017-2018  Groupe3 sous groupe 1. Tous droits réservés ");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 493, 395, 16);
		panel.add(lblNewLabel_2);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("/Users/fd/Downloads/facebook.png"));
		label_2.setBounds(167, 51, 32, 32);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("/Users/fd/Downloads/gmail (1).png"));
		label_3.setBounds(167, 95, 32, 32);
		panel.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("/Users/fd/Downloads/telephone-symbol-button (1).png"));
		label_4.setBounds(167, 139, 32, 32);
		panel.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("/Users/fd/Downloads/facebook.png"));
		label_5.setBounds(167, 202, 32, 32);
		panel.add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("/Users/fd/Downloads/gmail (1).png"));
		label_6.setBounds(167, 246, 32, 32);
		panel.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("/Users/fd/Downloads/telephone-symbol-button (1).png"));
		label_7.setBounds(167, 290, 32, 32);
		panel.add(label_7);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("/Users/fd/Downloads/facebook.png"));
		label_8.setBounds(167, 353, 32, 32);
		panel.add(label_8);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("/Users/fd/Downloads/gmail (1).png"));
		label_9.setBounds(167, 397, 32, 32);
		panel.add(label_9);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("/Users/fd/Downloads/telephone-symbol-button (1).png"));
		label_10.setBounds(167, 441, 32, 32);
		panel.add(label_10);

		JLabel lblFacebookcomhoussi = new JLabel("facebook.com/Houssi27");
		lblFacebookcomhoussi.setForeground(new Color(51, 153, 255));
		lblFacebookcomhoussi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.facebook.com/Houssi27").toURI());
				} catch (Exception e1) {
				}
			}
		});
		lblFacebookcomhoussi.setBounds(211, 61, 190, 16);
		panel.add(lblFacebookcomhoussi);

		JLabel lblFacebookcomahmed = new JLabel("facebook.com/Ahmeds.profil");
		lblFacebookcomahmed.setForeground(new Color(51, 153, 255));
		lblFacebookcomahmed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.facebook.com/Ahmeds.profil").toURI());
				} catch (Exception e1) {
				}
			}
		});
		lblFacebookcomahmed.setBounds(211, 212, 190, 16);
		panel.add(lblFacebookcomahmed);

		JLabel lblFacebookcomzoumed = new JLabel("facebook.com/Zoumed96");
		lblFacebookcomzoumed.setForeground(new Color(51, 153, 255));
		lblFacebookcomzoumed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.facebook.com/zoumed96").toURI());
				} catch (Exception e1) {
				}
			}
		});
		lblFacebookcomzoumed.setBounds(211, 364, 190, 16);
		panel.add(lblFacebookcomzoumed);

		JLabel lblHoussihotmailcom = new JLabel("houssi27@hotmail.com");
		lblHoussihotmailcom.setForeground(new Color(0, 0, 0));
		lblHoussihotmailcom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblHoussihotmailcom.setBounds(211, 105, 190, 16);
		panel.add(lblHoussihotmailcom);

		JLabel lblSaadallahgmailcom = new JLabel("saadallah42@gmail.com");
		lblSaadallahgmailcom.setForeground(new Color(0, 0, 0));
		lblSaadallahgmailcom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblSaadallahgmailcom.setBounds(211, 257, 190, 16);
		panel.add(lblSaadallahgmailcom);

		JLabel lblZoumedlivefr = new JLabel("zoumed22@live.fr");
		lblZoumedlivefr.setForeground(new Color(0, 0, 0));
		lblZoumedlivefr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(
							new URL("https://mail.google.com/mail/u/1/#drafts?compose=16138e5f7b3de81d").toURI());
				} catch (Exception e1) {
				}
			}
		});
		lblZoumedlivefr.setBounds(211, 408, 190, 16);
		panel.add(lblZoumedlivefr);

		JLabel label_11 = new JLabel("+213 659-36-24-97");
		label_11.setBounds(211, 149, 190, 16);
		panel.add(label_11);

		JLabel label_13 = new JLabel("+213 776-94-79-64");
		label_13.setBounds(211, 301, 190, 16);
		panel.add(label_13);

		JLabel label_14 = new JLabel("+213 558-44-88-13");
		label_14.setBounds(211, 452, 190, 16);
		panel.add(label_14);
	}
}
