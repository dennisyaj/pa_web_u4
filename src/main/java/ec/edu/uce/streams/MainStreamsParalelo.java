package ec.edu.uce.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamsParalelo {
	public static void main(String[] args) {

		long inicio = System.currentTimeMillis();

		List<Integer> lista = new ArrayList<>();
//		List<String> listaString = new ArrayList<>();

		for (int i = 1; i <= 1000; i++) {
			lista.add(i);
		}
		// esto se uso en cuentahabienteVip
		// streams mejorar manejos

		List<String> listaString = lista.parallelStream().map(numero -> convertirNumero(numero))
				.collect(Collectors.toList());
		listaString.forEach(System.out::println);// metodo referenciado funciona porq el foreach recivbe una interfaz
													// funcional
		long fin = System.currentTimeMillis();
		long tiempoFin = (fin - inicio) / 1000;
		System.out.println("Tiempo Total " + tiempoFin + " seg");
	}

	private static String convertirNumero(Integer numero) {
		System.out.println(Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "N:" + numero.toString();
	}
}
