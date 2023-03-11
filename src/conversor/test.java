package conversor;

import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		
		Map<String, Double> cop = new HashMap<>();
		cop.put(Divisas.USD.name(), 4600.4);
		
		System.out.println(1 / 4600.4);
	}
}
