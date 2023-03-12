package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIConversorTemperatura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputValor;
	private JComboBox<String> temperaturaOrigen;
	private JComboBox<String> temperaturaDestino;
	private JLabel resultado;

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
		setTitle("Conversor de temperatura\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
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

		inputValor = new JTextField();
		inputValor.setFont(new Font("Roboto", Font.BOLD, 12));
		inputValor.setColumns(10);
		inputValor.setBounds(10, 35, 120, 20);
		contentPane.add(inputValor);

		JLabel lblCantidad_2 = new JLabel("A:");
		lblCantidad_2.setFont(new Font("Roboto", Font.BOLD, 12));
		lblCantidad_2.setBounds(350, 10, 70, 15);
		contentPane.add(lblCantidad_2);

		JButton btnConvertir = new JButton("Convertir\n");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Temperatura temperatura = new Temperatura();
				String valorTemperatura = inputValor.getText();

				if (valorTemperatura.matches("-*[0-9]*\\.*[0-9]*") && !valorTemperatura.isEmpty()) {
					double valor = Double.parseDouble(valorTemperatura);
					String origen = temperaturaOrigen.getSelectedItem().toString();
					String destino = temperaturaDestino.getSelectedItem().toString();

					String result = temperatura.convertir(valor, origen, destino);
					resultado.setText(result);
				} else {
					JOptionPane.showMessageDialog(null, "Valide el valor ingresado", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnConvertir.setForeground(Color.WHITE);
		btnConvertir.setFont(new Font("Roboto", Font.BOLD, 12));
		btnConvertir.setBackground(new Color(60, 60, 255));
		btnConvertir.setBounds(380, 65, 90, 20);
		contentPane.add(btnConvertir);

		temperaturaOrigen = new JComboBox<String>();
		temperaturaOrigen.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Kelvin (K)", "Celsius (C)", "Fahrenheit (F)" }));
		temperaturaOrigen.setBounds(150, 35, 120, 20);
		contentPane.add(temperaturaOrigen);

		temperaturaDestino = new JComboBox<String>();
		temperaturaDestino.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Kelvin (K)", "Celsius (C)", "Fahrenheit (F)" }));
		temperaturaDestino.setBounds(350, 36, 120, 20);
		contentPane.add(temperaturaDestino);

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
		btnLimpiar.setBounds(280, 65, 90, 20);
		contentPane.add(btnLimpiar);

		GUIConversorTemperatura conversorTemperatura = this;
		JButton btnVolver = new JButton("Volver\n\r\n");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				conversorTemperatura.dispose();
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Roboto", Font.BOLD, 12));
		btnVolver.setBackground(new Color(128, 128, 64));
		btnVolver.setBounds(10, 233, 90, 20);
		contentPane.add(btnVolver);

		JButton btnIntercambiar = new JButton("");
		btnIntercambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String origen = temperaturaOrigen.getSelectedItem().toString();
				String destino = temperaturaDestino.getSelectedItem().toString();

				temperaturaOrigen.setSelectedItem(destino);
				temperaturaDestino.setSelectedItem(origen);
			}
		});
		btnIntercambiar.setIcon(new ImageIcon(GUIConversorTemperatura.class.getResource("/img/intercambiar.png")));
		btnIntercambiar.setForeground(Color.WHITE);
		btnIntercambiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnIntercambiar.setBackground(Color.WHITE);
		btnIntercambiar.setBounds(280, 30, 60, 30);
		contentPane.add(btnIntercambiar);

		resultado = new JLabel("");
		resultado.setFont(new Font("Roboto", Font.BOLD, 12));
		resultado.setBounds(10, 65, 260, 20);
		contentPane.add(resultado);
	}
}
