package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIConversorMoneda extends JFrame {

	private JPanel contentPane;
	private JTextField inputValor;
	private JLabel lblCantidad_2;
	private JButton btnConvertir;
	private JComboBox divisaOrigen;
	private JComboBox divisaDestino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConversorMoneda frame = new GUIConversorMoneda();
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
	public GUIConversorMoneda() {
		setTitle("Conversor de moneda\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 221, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Roboto", Font.BOLD, 12));
		lblCantidad.setBounds(10, 10, 70, 15);
		contentPane.add(lblCantidad);
		
		JLabel lblCantidad_1 = new JLabel("De:");
		lblCantidad_1.setFont(new Font("Roboto", Font.BOLD, 12));
		lblCantidad_1.setBounds(150, 10, 70, 15);
		contentPane.add(lblCantidad_1);
		
		inputValor = new JTextField();
		inputValor.setFont(new Font("Roboto", Font.BOLD, 12));
		inputValor.setBounds(10, 35, 120, 20);
		contentPane.add(inputValor);
		inputValor.setColumns(10);
		
		lblCantidad_2 = new JLabel("A:");
		lblCantidad_2.setFont(new Font("Roboto", Font.BOLD, 12));
		lblCantidad_2.setBounds(290, 10, 70, 15);
		contentPane.add(lblCantidad_2);
		
		btnConvertir = new JButton("Convertir\n");
		btnConvertir.setForeground(new Color(255, 255, 255));
		btnConvertir.setBackground(new Color(60, 60, 255));
		btnConvertir.setFont(new Font("Roboto", Font.BOLD, 12));
		btnConvertir.setBounds(320, 65, 90, 20);
		contentPane.add(btnConvertir);
		
		divisaOrigen = new JComboBox();
		divisaOrigen.setModel(new DefaultComboBoxModel(new String[] {"Peso Colombiano", "Dólar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won Surcoreano"}));
		divisaOrigen.setBounds(150, 35, 120, 20);
		contentPane.add(divisaOrigen);
		
		divisaDestino = new JComboBox();
		divisaDestino.setModel(new DefaultComboBoxModel(new String[] {"Peso Colombiano", "Dólar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won Surcoreano"}));
		divisaDestino.setBounds(290, 35, 120, 20);
		contentPane.add(divisaDestino);
	}
}
