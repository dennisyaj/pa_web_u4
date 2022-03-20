package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.concurrent.TimeUnit;


public class GestorAtencionHilo extends Thread {
	// identificamos el metodo a paralelizar

	private CajeroHilo cajero;
	private long tiempoInicial;

	public GestorAtencionHilo(CajeroHilo cajero, long tiempoInicial) {
		this.cajero = cajero;
		this.tiempoInicial = tiempoInicial;
	}

	@Override
	public void run() {
		this.procesar(this.cajero, this.tiempoInicial);
	}

	public void procesar(CajeroHilo cajero, long tiempoInicial) {
		System.out.println("Inicia cajero " + cajero.getNombre());

		for (Integer tiempo : cajero.getClientes()) {
			this.atenderCliente(tiempo);
		}

		System.out.println("Finaliza atender cajero: " + cajero.getNombre());
		long tiempoTranscurrido = (System.currentTimeMillis() - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + "seg atendido por el cajero " + cajero.getNombre());
	}

	private void atenderCliente(Integer tiempo) {
//		System.out.println("Atendiendo a cliente: " + tiempo);
		System.out.println("Hilo:" + Thread.currentThread().getName());
		
		try {
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
