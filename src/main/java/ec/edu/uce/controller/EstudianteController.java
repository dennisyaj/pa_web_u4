package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
// por cada uno debe existir un recurso

	@Autowired
	private IEstudianteService iEstudianteService;

	@GetMapping("/buscar/{idEstudiante}")
//	@RequestMapping(path = "/buscar/{idEstudiante}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		// retorna string debido que nos devuelve el nombre de la vista

		Estudiante estud = this.iEstudianteService.buscarEstudiante(idEstudiante);
//		estudiante.setId(idEstudiante);
//		estudiante.setNombre("Dennis");
//		estudiante.setApellido("Pilco");

		modelo.addAttribute("estu", estud);

		return "estudiante";
	}

	@GetMapping("/buscar/todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiantes = this.iEstudianteService.buscarTodos();
		modelo.addAttribute("listEstudiantes", listaEstudiantes);
		return "listaEstudiantes";
	}

	@GetMapping("/estudianteNuevo")
	public String obtenerPaginaIngresoDatos() {
		return "estudianteNuevo";
	}

	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo) {
		this.iEstudianteService.insertarEstudinte(estudiante);
		// posibles paginas repuestas para despues de insertar
		return "listaEstudiantes";
	}
}
