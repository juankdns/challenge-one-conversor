package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIConversorTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConversorTemperatura frame = new GUIConversorTemperatura();
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
	public GUIConversorTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 221, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Roboto", Font.BOLD, 12));
		lblValor.setBounds(10, 10, 70, 15);
		contentPane.add(lblValor);
		
		JLabel lblCantidad_1 = new JLabel("De:");
		lblCantidad_1.setFont(new Font("Roboto", Font.BOLD, 12));
		lblCantidad_1.setBounds(150, 10, 70, 15);
		contentPane.add(lblCantidad_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(10, 35, 120, 20);
		contentPane.add(textField);
		
		JLabel lblCantidad_2 = new JLabel("A:");
		lblCantidad_2.setFont(new Font("Roboto", Font.BOLD, 12));
		lblCantidad_2.setBounds(290, 10, 70, 15);
		contentPane.add(lblCantidad_2);
		
		JButton btnConvertir = new JButton("Convertir\n");
		btnConvertir.setForeground(Color.WHITE);
		btnConvertir.setFont(new Font("Roboto", Font.BOLD, 12));
		btnConvertir.setBackground(new Color(60, 60, 255));
		btnConvertir.setBounds(320, 65, 90, 20);
		contentPane.add(btnConvertir);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kelvin (K)", "Celsius (C)", "Fahrenheit (F)", "Reaumur (R)", "Rankine"}));
		comboBox.setBounds(150, 35, 120, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Kelvin (K)", "Celsius (C)", "Fahrenheit (F)", "Reaumur (R)", "Rankine"}));
		comboBox_1.setBounds(290, 35, 120, 20);
		contentPane.add(comboBox_1);
	}

}
