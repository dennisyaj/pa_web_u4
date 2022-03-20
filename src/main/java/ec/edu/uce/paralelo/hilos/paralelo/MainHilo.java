package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.Arrays;

public class MainHilo {

	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis();

		CajeroHilo cajero = new CajeroHilo("Pedro", Arrays.asList(2, 2, 3, 2, 2));
		CajeroHilo cajero2 = new CajeroHilo("Kevin", Arrays.asList(1, 2, 2));
		CajeroHilo cajero3 = new CajeroHilo("Alex", Arrays.asList(2, 1, 2, 3, 4));

		System.out.println("Hilo pricipal " + Thread.currentThread().getName());
		GestorAtencionHilo gestorAtencion = new GestorAtencionHilo(cajero, tiempoInicial);
		GestorAtencionHilo gestorAtencion2 = new GestorAtencionHilo(cajero2, tiempoInicial);
		GestorAtencionHilo gestorAtencion3 = new GestorAtencionHilo(cajero3, tiempoInicial);

		gestorAtencion.start();
		gestorAtencion2.start();
		gestorAtencion3.start();

		long tiempoFinal = System.currentTimeMillis();
		System.out.println("Hilo pricipal2 " + Thread.currentThread().getName());
		
		long tiempoTranscurrido = (System.currentTimeMillis() - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + "seg");
		System.out.println("Termino");
	}

}
