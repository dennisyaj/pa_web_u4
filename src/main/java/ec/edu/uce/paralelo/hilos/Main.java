package ec.edu.uce.paralelo.hilos;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		//38 segundos
		long tiempoInicial = System.currentTimeMillis();

		Cajero cajero = new Cajero("Dennis", Arrays.asList(2, 2, 3, 4, 5));
		Cajero cajero2 = new Cajero("Carlos", Arrays.asList(1, 2, 2, 3));
		Cajero cajero3 = new Cajero("Pedro", Arrays.asList(2, 3, 2, 3, 4));

		GestorAtencion gestorAtencion = new GestorAtencion();
		GestorAtencion gestorAtencion2 = new GestorAtencion();
		GestorAtencion gestorAtencion3 = new GestorAtencion();

		gestorAtencion.procesar(cajero, tiempoInicial);
		gestorAtencion2.procesar(cajero2, tiempoInicial);
		gestorAtencion3.procesar(cajero3, tiempoInicial);

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (System.currentTimeMillis() - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + "seg");

	}

}
