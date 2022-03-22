package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Estudiante;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante buscarEstudiante(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> buscarTodos() {

		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante", Estudiante.class);
		return myQuery.getResultList();
	}

	@Override
	public void insertarEstudinte(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizarEstudinte(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscarEstudiante(id));
	}

}
