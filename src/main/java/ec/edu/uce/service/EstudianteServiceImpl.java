package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IEstudianteRepo;
import ec.edu.uce.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo iEstudianteRepo;

	@Override
	public Estudiante buscarEstudiante(Integer id) {
		return this.iEstudianteRepo.buscarEstudiante(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		return this.iEstudianteRepo.buscarTodos();
	}

	@Override
	public void insertarEstudinte(Estudiante estudiante) {
		this.iEstudianteRepo.insertarEstudinte(estudiante);
	}

	@Override
	public void actualizarEstudinte(Estudiante estudiante) {
		this.iEstudianteRepo.actualizarEstudinte(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.iEstudianteRepo.eliminar(id);
	}

}
