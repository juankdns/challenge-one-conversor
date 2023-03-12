package conversor;

import java.text.DecimalFormat;

public class Moneda implements Convertidor {

	@Override
	public String convertir(double valor, String origen, String destino) {

		DivisasUtil util = new DivisasUtil();
		String[] divisaOrigen = origen.split(" - ");
		String[] divisaDestino = destino.split(" - ");
		String resultado;
		double valorDivisa;

		if (!divisaOrigen[0].equalsIgnoreCase(divisaDestino[0])) {
			switch (divisaOrigen[0]) {
			case "COP" -> valorDivisa = util.getCop().get(divisaDestino[0]);
			case "USD" -> valorDivisa = util.getUsd().get(divisaDestino[0]);
			case "EUR" -> valorDivisa = util.getEur().get(divisaDestino[0]);
			case "GBP" -> valorDivisa = util.getGbp().get(divisaDestino[0]);
			case "JPY" -> valorDivisa = util.getJpy().get(divisaDestino[0]);
			case "KRW" -> valorDivisa = util.getKrw().get(divisaDestino[0]);
			default -> valorDivisa = 1;
			}
		} else {
			valorDivisa = 1;
		}

		DecimalFormat format = new DecimalFormat("#,##0.00");
		resultado = divisaOrigen[0] + " " + format.format(valor) + " = " + divisaDestino[0] + " "
				+ format.format(valor * valorDivisa);
		return resultado;
	}
}
