package ec.edu.uce.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProcesamientoFacultadServiceImpl implements IProcesamientoFacultadService {
	private static final Logger LOG = LoggerFactory.getLogger(ProcesamientoFacultadServiceImpl.class);

	@Override
	@Async
	public Integer calcularDeuda(String cedula, Integer valor) {
		LOG.info("Procesando: " + cedula);

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info("Finalizo: " + cedula);
		return valor;
	}

	@Override
	@Async
	public CompletableFuture<Integer> calcularDeudaFuture(String cedula, Integer valor) {
		LOG.info("Procesando: " + cedula);
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LOG.info("Finalizo: " + cedula);
		return CompletableFuture.completedFuture(valor);
	}
}
