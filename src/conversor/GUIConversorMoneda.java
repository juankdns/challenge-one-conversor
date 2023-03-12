package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GUIConversorMoneda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputValor;
	private JLabel lblCantidad_2;
	private JButton btnConvertir;
	private JLabel resultado;
	private JComboBox<String> divisaOrigen;
	private JComboBox<String> divisaDestino;
	private JButton btnIntercambiar;

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
		setBounds(100, 100, 645, 300);
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
		lblCantidad_1.setBounds(200, 10, 70, 15);
		contentPane.add(lblCantidad_1);

		inputValor = new JTextField();
		inputValor.setFont(new Font("Roboto", Font.BOLD, 12));
		inputValor.setBounds(10, 35, 170, 20);
		contentPane.add(inputValor);
		inputValor.setColumns(10);

		lblCantidad_2 = new JLabel("A:");
		lblCantidad_2.setFont(new Font("Roboto", Font.BOLD, 12));
		lblCantidad_2.setBounds(390, 10, 70, 15);
		contentPane.add(lblCantidad_2);

		btnConvertir = new JButton("Convertir\n");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Moneda moneda = new Moneda();
				String valorDivisa = inputValor.getText().replaceAll("\\,", ".");

				if (valorDivisa.matches("[0-9]*\\.*[0-9]*") && !valorDivisa.isEmpty()) {
					double valor = Double.parseDouble(valorDivisa);
					String origen = divisaOrigen.getSelectedItem().toString();
					String destino = divisaDestino.getSelectedItem().toString();

					String result = moneda.convertir(valor, origen, destino);
					resultado.setText(result);
				} else {
					JOptionPane.showMessageDialog(null, "Valide la cantidad ingresada", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnConvertir.setForeground(new Color(255, 255, 255));
		btnConvertir.setBackground(new Color(60, 60, 255));
		btnConvertir.setFont(new Font("Roboto", Font.BOLD, 12));
		btnConvertir.setBounds(530, 65, 90, 20);
		contentPane.add(btnConvertir);

		divisaOrigen = new JComboBox<String>();
		divisaOrigen.setModel(new DefaultComboBoxModel<String>(new String[] { "COP - Peso Colombiano", "USD - Dólar",
				"EUR - Euros", "GBP - Libras Esterlinas", "JPY - Yen Japonés ", "KRW - Won surcoreano" }));
		divisaOrigen.setBounds(200, 35, 170, 20);
		contentPane.add(divisaOrigen);

		divisaDestino = new JComboBox<String>();
		divisaDestino.setModel(new DefaultComboBoxModel<String>(new String[] { "COP - Peso Colombiano", "USD - Dólar",
				"EUR - Euros", "GBP - Libras Esterlinas", "JPY - Yen Japonés ", "KRW - Won surcoreano" }));
		divisaDestino.setBounds(450, 35, 170, 20);
		contentPane.add(divisaDestino);

		resultado = new JLabel("");
		resultado.setFont(new Font("Roboto", Font.BOLD, 12));
		resultado.setBounds(10, 65, 300, 20);
		contentPane.add(resultado);

		JButton btnLimpiar = new JButton("Limpiar\r\n");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputValor.setText("");
				resultado.setText("");
			}
		});
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiar.setBackground(new Color(60, 60, 255));
		btnLimpiar.setBounds(430, 65, 90, 20);
		contentPane.add(btnLimpiar);

		GUIConversorMoneda conversorMoneda = this;
		JButton btnVolver = new JButton("Volver\n\r\n");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				conversorMoneda.dispose();
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Roboto", Font.BOLD, 12));
		btnVolver.setBackground(new Color(128, 128, 64));
		btnVolver.setBounds(10, 233, 90, 20);
		contentPane.add(btnVolver);

		btnIntercambiar = new JButton("");
		btnIntercambiar.setIcon(new ImageIcon(GUIConversorMoneda.class.getResource("/img/intercambiar.png")));
		btnIntercambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String origen = divisaOrigen.getSelectedItem().toString();
				String destino = divisaDestino.getSelectedItem().toString();

				divisaOrigen.setSelectedItem(destino);
				divisaDestino.setSelectedItem(origen);
			}
		});
		btnIntercambiar.setForeground(Color.WHITE);
		btnIntercambiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnIntercambiar.setBackground(new Color(255, 255, 255));
		btnIntercambiar.setBounds(380, 30, 60, 30);
		contentPane.add(btnIntercambiar);
	}
}
