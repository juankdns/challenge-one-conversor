package conversor;

import java.util.*;

public class DivisasUtil {

	private Map<String, Double> cop = new HashMap<>();
	private Map<String, Double> usd = new HashMap<>();
	private Map<String, Double> eur = new HashMap<>();
	private Map<String, Double> gbp = new HashMap<>();
	private Map<String, Double> jpy = new HashMap<>();
	private Map<String, Double> krw = new HashMap<>();

	public Map<String, Double> getDivisaCOP() {
		this.cop.put(Divisas.USD.name(), 4717.86);
		this.cop.put(Divisas.EUR.name(), 5021.47);
		this.cop.put(Divisas.GBP.name(), 5677.97);
		this.cop.put(Divisas.JPY.name(), 34.9503);
		this.cop.put(Divisas.KRW.name(), 3.57101);
		return this.cop;
	}

	public Map<String, Double> getDivisaUSD() {
		this.usd.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.USD.name()));
		this.usd.put(Divisas.EUR.name(), 1.06433);
		this.usd.put(Divisas.GBP.name(), 1.2034);
		this.usd.put(Divisas.JPY.name(), 0.00740744);
		this.usd.put(Divisas.KRW.name(), 0.00740744);
		return this.usd;
	}

	public Map<String, Double> getDivisaEUR() {
		this.eur.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.EUR.name()));
		this.eur.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.EUR.name()));
		this.eur.put(Divisas.GBP.name(), 1.13038);
		this.eur.put(Divisas.JPY.name(), 0.00695795);
		this.eur.put(Divisas.KRW.name(), 0.000711159);
		return this.eur;
	}

	public Map<String, Double> getDivisaGBP() {
		this.gbp.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.GBP.name()));
		this.gbp.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.GBP.name()));
		this.gbp.put(Divisas.EUR.name(), 1 / this.eur.get(Divisas.GBP.name()));
		this.gbp.put(Divisas.JPY.name(), 0.00615539);
		this.gbp.put(Divisas.KRW.name(), 0.000629193);
		return this.gbp;
	}

	public Map<String, Double> getDivisaJPY() {
		this.jpy.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.EUR.name(), 1 / this.eur.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.GBP.name(), 1 / this.gbp.get(Divisas.JPY.name()));
		this.jpy.put(Divisas.KRW.name(), 0.10222);
		return this.jpy;
	}

	public Map<String, Double> getDivisaKRW() {
		this.krw.put(Divisas.COP.name(), 1 / this.cop.get(Divisas.KRW.name()));
		this.krw.put(Divisas.USD.name(), 1 / this.usd.get(Divisas.KRW.name()));
		this.krw.put(Divisas.EUR.name(), 1 / this.eur.get(Divisas.KRW.name()));
		this.krw.put(Divisas.GBP.name(), 1 / this.gbp.get(Divisas.KRW.name()));
		this.krw.put(Divisas.JPY.name(), 1 / this.jpy.get(Divisas.KRW.name()));
		return this.krw;
	}
}
