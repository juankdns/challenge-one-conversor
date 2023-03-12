package conversor;

import java.text.DecimalFormat;

public class Temperatura implements Convertidor {

	@Override
	public String convertir(double valor, String origen, String destino) {

		String[] temperaturaOrigen = origen.split(" ");
		String[] temperaturaDestino = destino.split(" ");
		String resultado;
		double temperatura;

		if (!temperaturaOrigen[0].equalsIgnoreCase(temperaturaDestino[0])) {
			switch (temperaturaOrigen[0] + temperaturaDestino[0]) {
			case "KelvinCelsius" -> temperatura = valor - 273.15;
			case "KelvinFahrenheit" -> temperatura = 9.0 / 5.0 * (valor - 273.15) + 32;
			case "CelsiusKelvin" -> temperatura = valor + 273.15;
			case "CelsiusFahrenheit" -> temperatura = (9.0 / 5.0 * valor) + 32;
			case "FahrenheitKelvin" -> temperatura = 5.0 / 9.0 * (valor - 32) + 273.15;
			case "FahrenheitCelsius" -> temperatura = 5.0 / 9.0 * (valor - 32);
			default -> temperatura = valor;
			}
		} else {
			temperatura = valor;
		}

		DecimalFormat format = new DecimalFormat("0.00");
		resultado = format.format(valor) + " " + temperaturaOrigen[1] + " = " + format.format(temperatura) + " "
				+ temperaturaDestino[1];

		return resultado;
	}

}
