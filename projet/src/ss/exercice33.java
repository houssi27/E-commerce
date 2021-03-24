package ss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class exercice33 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exercice33 frame = new exercice33();
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
	int c;
	double num, ans;

	public void calcule() {
		try {
			switch (c) {
			case 1:
				ans = num + Double.parseDouble(textField.getText());
				textField.setText(Double.toString(ans));
				break;
			case 2:
				ans = num - Double.parseDouble(textField.getText());
				textField.setText(Double.toString(ans));
				break;
			case 3:
				ans = num * Double.parseDouble(textField.getText());
				textField.setText(Double.toString(ans));
				break;
			case 4:
				ans = num / Double.parseDouble(textField.getText());
				textField.setText(Double.toString(ans));
				break;
			}
		} catch (Exception e) {

		}
	}

	public exercice33() {
		setBounds(100, 100, 391, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setForeground(new Color(51, 153, 255));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(6, 94, 376, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("7");
		btnNewButton.setForeground(new Color(51, 153, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		btnNewButton.setBounds(6, 153, 85, 29);
		contentPane.add(btnNewButton);

		JButton button = new JButton("8");
		button.setForeground(new Color(51, 153, 255));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		button.setBounds(103, 153, 85, 29);
		contentPane.add(button);

		JButton button_1 = new JButton("9");
		button_1.setForeground(new Color(51, 153, 255));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 9);
			}
		});
		button_1.setBounds(200, 153, 85, 29);
		contentPane.add(button_1);

		JButton button_2 = new JButton("/");
		button_2.setForeground(new Color(51, 153, 255));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(textField.getText());
				c = 4;
				textField.setText("");
			}
		});
		button_2.setBounds(297, 153, 85, 29);
		contentPane.add(button_2);

		JButton button_3 = new JButton("4");
		button_3.setForeground(new Color(51, 153, 255));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 4);
			}
		});
		button_3.setBounds(6, 194, 85, 29);
		contentPane.add(button_3);

		JButton button_4 = new JButton("5");
		button_4.setForeground(new Color(51, 153, 255));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 5);
			}
		});
		button_4.setBounds(103, 194, 85, 29);
		contentPane.add(button_4);

		JButton button_5 = new JButton("6");
		button_5.setForeground(new Color(51, 153, 255));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 6);
			}
		});
		button_5.setBounds(200, 194, 85, 29);
		contentPane.add(button_5);

		JButton button_6 = new JButton("*");
		button_6.setForeground(new Color(51, 153, 255));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(textField.getText());
				c = 3;
				textField.setText("");
			}
		});
		button_6.setBounds(297, 194, 85, 29);
		contentPane.add(button_6);

		JButton button_7 = new JButton("1");
		button_7.setForeground(new Color(51, 153, 255));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 1);
			}
		});
		button_7.setBounds(6, 235, 85, 29);
		contentPane.add(button_7);

		JButton button_8 = new JButton("0");
		button_8.setForeground(new Color(51, 153, 255));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 0);
			}
		});
		button_8.setBounds(6, 281, 85, 29);
		contentPane.add(button_8);

		JButton button_9 = new JButton("2");
		button_9.setForeground(new Color(51, 153, 255));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 2);
			}
		});
		button_9.setBounds(103, 235, 85, 29);
		contentPane.add(button_9);

		JButton button_10 = new JButton("3");
		button_10.setForeground(new Color(51, 153, 255));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + 3);
			}
		});
		button_10.setBounds(200, 235, 85, 29);
		contentPane.add(button_10);

		JButton button_11 = new JButton("-");
		button_11.setForeground(new Color(51, 153, 255));
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(textField.getText());
				c = 2;
				textField.setText("");
			}
		});
		button_11.setBounds(297, 235, 85, 29);
		contentPane.add(button_11);

		JButton button_12 = new JButton(".");
		button_12.setForeground(new Color(51, 153, 255));
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + ".");
			}
		});
		button_12.setBounds(103, 281, 85, 29);
		contentPane.add(button_12);

		JButton button_13 = new JButton("+");
		button_13.setForeground(new Color(51, 153, 255));
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = Double.parseDouble(textField.getText());
				c = 1;
				textField.setText("");
			}
		});
		button_13.setBounds(297, 281, 85, 29);
		contentPane.add(button_13);

		JButton button_14 = new JButton("=");
		button_14.setForeground(new Color(51, 153, 255));
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcule();
			}
		});
		button_14.setBounds(200, 281, 85, 29);
		contentPane.add(button_14);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 255));
		panel.setBounds(6, 6, 379, 81);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Calculatrice");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Chalkduster", Font.PLAIN, 40));
		lblNewLabel.setBounds(0, 0, 379, 81);
		panel.add(lblNewLabel);
	}
}
