package ec.edu.uce.paralelo.hilos;

import java.util.concurrent.TimeUnit;

public class GestorAtencion {

	public void procesar(Cajero cajero, long tiempoInicial) {
		System.out.println("Inicia cajero " + cajero.getNombre());

		for (Integer tiempo : cajero.getClientes()) {
			this.atenderCliente(tiempo);
		}

		System.out.println("Finaliza atender cajero: " + cajero.getNombre());
		long tiempoTranscurrido = (System.currentTimeMillis() - tiempoInicial) / 1000;
		System.out.println(tiempoTranscurrido + "seg atendido por el cajero " + cajero.getNombre());
	}

	private void atenderCliente(Integer tiempo) {
		System.out.println("Atendiendo a cliente: " + tiempo);

		try {
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
