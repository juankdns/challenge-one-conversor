package conversor;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 221, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Seleccione una acción de conversión:");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);

		Menu menu = this;
				
						JComboBox<Object> tipoConvertidor = new JComboBox<Object>();
						tipoConvertidor.setFont(new Font("Roboto", Font.PLAIN, 12));
						tipoConvertidor
								.setModel(new DefaultComboBoxModel<Object>(new String[] { "Conversor de moneda", "Conversor de temperatura" }));
						contentPane.add(tipoConvertidor);
						JButton btnNewButton = new JButton("Continuar\n");
						btnNewButton.setFont(new Font("Roboto", Font.BOLD, 12));
						btnNewButton.setForeground(new Color(255, 255, 255));
						btnNewButton.setBackground(new Color(60, 60, 255));
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if ("Conversor de moneda".equalsIgnoreCase(tipoConvertidor.getSelectedItem().toString())) {
									GUIConversorMoneda conversorMoneda = new GUIConversorMoneda();
									conversorMoneda.setVisible(true);
									menu.dispose();
								} else {
									GUIConversorTemperatura conversorTemperatura = new GUIConversorTemperatura();
									conversorTemperatura.setVisible(true);
									menu.dispose();
								}
							}
						});
						contentPane.add(btnNewButton);
	}
}
