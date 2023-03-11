package conversor;

public class Moneda implements Convertidor {

	private int cantidad;
	private int nombreDivisa;

	public Moneda(int cantidad, int nombreDivisa) {
		this.cantidad = cantidad;
		this.nombreDivisa = nombreDivisa;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public int getNombreDivisa() {
		return this.nombreDivisa;
	}

	@Override
	public String convertir(int valor, String origen, String destino) {
		return null;
	}

}
