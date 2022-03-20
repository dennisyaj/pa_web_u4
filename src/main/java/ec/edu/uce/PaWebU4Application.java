package ec.edu.uce;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import ec.edu.uce.service.IProcesamientoFacultadService;
import ec.edu.uce.service.ProcesamientoFacultadServiceImpl;

@SpringBootApplication
@EnableAsync
public class PaWebU4Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProcesamientoFacultadServiceImpl.class);

	@Autowired
	private IProcesamientoFacultadService iProcesamientoFacultadService;

	public static void main(String[] args) {
		SpringApplication.run(PaWebU4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long inicio = System.currentTimeMillis();
//		procesamiento asicrono pero sin respuesta en cada hilo
//		Integer valor1 = this.iProcesamientoFacultadService.calcularDeuda("1235", 4);
//		Integer valor2 = this.iProcesamientoFacultadService.calcularDeuda("12345", 4);
//		Integer valor3 = this.iProcesamientoFacultadService.calcularDeuda("123456", 4);
//		Integer valor4 = this.iProcesamientoFacultadService.calcularDeuda("1234567", 4);

//		Procesamiento asincrono pero sin respuesta en cada hilo
		CompletableFuture<Integer> valor1 = this.iProcesamientoFacultadService.calcularDeudaFuture("1235", 4);
		CompletableFuture<Integer> valor2 = this.iProcesamientoFacultadService.calcularDeudaFuture("12345", 4);
		CompletableFuture<Integer> valor3 = this.iProcesamientoFacultadService.calcularDeudaFuture("123456", 4);
		CompletableFuture<Integer> valor4 = this.iProcesamientoFacultadService.calcularDeudaFuture("1234567", 4);

//		Sentencia que espera a que terminen  de procesar todos lo hilos
		CompletableFuture.allOf(valor1, valor2, valor3, valor4).join();

		// esperar a todos los hilos
//		LOG.info("Valor1: " + valor1);
		LOG.info("Total: " + (valor1.get() + valor2.get() + valor3.get() + valor4.get()));
		long tFinal = System.currentTimeMillis();
		long tiempoTrancurrido = (tFinal - inicio) / 1000;
		LOG.info(tiempoTrancurrido + " Seg");
	}

}
