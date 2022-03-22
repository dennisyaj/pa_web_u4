package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
// por cada uno debe existir un recurso

	@Autowired
	private IEstudianteService iEstudianteService;

	@RequestMapping("/buscar/{idEstudiante}")
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		// retorna string debido que nos devuelve el nombre de la vista

		Estudiante estud = this.iEstudianteService.buscarEstudiante(idEstudiante);
//		estudiante.setId(idEstudiante);
//		estudiante.setNombre("Dennis");
//		estudiante.setApellido("Pilco");

		modelo.addAttribute("estu", estud);
		
		return "estudiante";
	}

}
