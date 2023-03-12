package conversor;

import java.util.*;

public class DivisasUtil {

	private Map<String, Double> cop;
	private Map<String, Double> usd;
	private Map<String, Double> eur;
	private Map<String, Double> gbp;
	private Map<String, Double> jpy;
	private Map<String, Double> krw;

	public DivisasUtil() {
		this.cop = new HashMap<>();
		this.usd = new HashMap<>();
		this.eur = new HashMap<>();
		this.gbp = new HashMap<>();
		this.jpy = new HashMap<>();
		this.krw = new HashMap<>();
		this.generarDivisaUSD();
		this.generarDivisaCOP();
		this.generarDivisaEUR();
		this.generarDivisaGBP();
		this.generarDivisaJPY();
		this.generarDivisaKRW();
	}

	public Map<String, Double> getCop() {
		return this.cop;
	}

	public Map<String, Double> getUsd() {
		return this.usd;
	}

	public Map<String, Double> getEur() {
		return this.eur;
	}

	public Map<String, Double> getGbp() {
		return this.gbp;
	}

	public Map<String, Double> getJpy() {
		return this.jpy;
	}

	public Map<String, Double> getKrw() {
		return this.krw;
	}

	private void generarDivisaUSD() {
		this.usd.put(Divisas.COP.name(), 4715.69);
		this.usd.put(Divisas.EUR.name(), 0.93961);
		this.usd.put(Divisas.GBP.name(), 0.831028);
		this.usd.put(Divisas.JPY.name(), 135.052);
		this.usd.put(Divisas.KRW.name(), 1323.54);
	}

	private void generarDivisaCOP() {
		this.cop.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.COP.name()));
		this.cop.put(Divisas.EUR.name(), this.usd.get(Divisas.EUR.name()) / this.usd.get(Divisas.COP.name()));
		this.cop.put(Divisas.GBP.name(), this.usd.get(Divisas.GBP.name()) / this.usd.get(Divisas.COP.name()));
		this.cop.put(Divisas.JPY.name(), this.usd.get(Divisas.JPY.name()) / this.usd.get(Divisas.COP.name()));
		this.cop.put(Divisas.KRW.name(), this.usd.get(Divisas.KRW.name()) / this.usd.get(Divisas.COP.name()));
	}

	private void generarDivisaEUR() {
		this.eur.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.EUR.name()));
		this.eur.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.EUR.name()));
		this.eur.put(Divisas.GBP.name(), this.usd.get(Divisas.GBP.name()) / this.usd.get(Divisas.EUR.name()));
		this.eur.put(Divisas.JPY.name(), this.usd.get(Divisas.JPY.name()) / this.usd.get(Divisas.EUR.name()));
		this.eur.put(Divisas.KRW.name(), this.usd.get(Divisas.KRW.name()) / this.usd.get(Divisas.EUR.name()));
	}

	private void generarDivisaGBP() {
		this.gbp.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.GBP.name()));
		this.gbp.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.GBP.name()));
		this.gbp.put(Divisas.EUR.name(), 1 / this.eur.get(Divisas.GBP.name()));
		this.gbp.put(Divisas.JPY.name(), this.usd.get(Divisas.JPY.name()) / this.usd.get(Divisas.GBP.name()));
		this.gbp.put(Divisas.KRW.name(), this.usd.get(Divisas.KRW.name()) / this.usd.get(Divisas.GBP.name()));
	}

	private void generarDivisaJPY() {
		this.jpy.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.EUR.name(), 1 / this.eur.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.GBP.name(), 1 / this.gbp.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.KRW.name(), this.usd.get(Divisas.KRW.name()) / this.usd.get(Divisas.JPY.name()));
	}

	private void generarDivisaKRW() {
		this.krw.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.KRW.name()));
		this.krw.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.KRW.name()));
		this.krw.put(Divisas.EUR.name(), 1 / this.eur.get(Divisas.KRW.name()));
		this.krw.put(Divisas.GBP.name(), 1 / this.gbp.get(Divisas.KRW.name()));
		this.krw.put(Divisas.JPY.name(), 1 / this.jpy.get(Divisas.KRW.name()));
	}
}
