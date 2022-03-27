package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes/")
public class EstudianteController {
// por cada uno debe existir un recurso

	@Autowired
	private IEstudianteService iEstudianteService;

	@GetMapping("buscar/{idEstudiante}")
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

	@GetMapping("todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiantes = this.iEstudianteService.buscarTodos();
		modelo.addAttribute("listEstudiantes", listaEstudiantes);
		return "listaEstudiantes";
	}

	@GetMapping("estudianteNuevo")
	public String obtenerPaginaIngresoDatos(Estudiante estudiante) {
		return "estudianteNuevo";
	}

	@PostMapping("insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo,
			RedirectAttributes redirectAttributes) {
		this.iEstudianteService.insertarEstudinte(estudiante);
		redirectAttributes.addFlashAttribute("mensaje", "Estudiante guadardo");
		// posibles paginas repuestas para despues de insertar
		return "redirect:/estudiantes/todos";
	}

	@GetMapping("estudianteActualiza/{idEstudiante}")
	private String obtenerPaginaAtualizarDatos(@PathVariable("idEstudiante") Integer idEstudiante,
			Estudiante estudiante, Model modelo) {

		Estudiante estu = this.iEstudianteService.buscarEstudiante(idEstudiante);
		modelo.addAttribute("estu", estu);
		return "estudianteActualiza";
	}

	@PutMapping("actualizar/{idEstudiante}")
	public String actualizarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante,
			Model modelo) {
		estudiante.setId(idEstudiante);
		this.iEstudianteService.actualizarEstudinte(estudiante);

//		List<Estudiante> listaEstudiantes = this.iEstudianteService.buscarTodos();
//		modelo.addAttribute("listEstudiantes", listaEstudiantes);
//
//		return "index";
		return "redirect:/estudiantes/todos";

	}

	@DeleteMapping("borrar/{idEstudiante}")
	public String eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		this.iEstudianteService.eliminar(idEstudiante);

//		List<Estudiante> listaEstudiantes = this.iEstudianteService.buscarTodos();
//		modelo.addAttribute("listEstudiantes", listaEstudiantes);

		return "redirect:/estudiantes/todos";
	}
}
