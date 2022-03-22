package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	Estudiante buscarEstudiante(Integer id);

	List<Estudiante> buscarTodos();

	void insertarEstudinte(Estudiante estudiante);

	void actualizarEstudinte(Estudiante estudiante);

	public void eliminar(Integer id);
}
