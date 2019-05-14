package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorOperacion {

	@RequestMapping(path = "/operaciones/{operacion}/")
	public ModelAndView operacionValidar(@PathVariable("operacion") String operacion,
			@RequestParam(value = "cadena", required = true) String cadena) {
		
		ModelMap model = new ModelMap();
		
		String resultado = new String();
		
		if (operacion.equals("pasarAMayuscula")) {
			resultado = cadena.toUpperCase();
		} else if (operacion.equals("pasarAMiniscula")) {
			resultado = cadena.toLowerCase();
		} else if (operacion.equals("invertirOrden")) {
			resultado = new StringBuilder(cadena).reverse().toString();
		} else if (operacion.equals("cantidadDeCaracteres")) {
			resultado = Integer.toString(cadena.length());
		} 
		
		model.put("cadena", cadena);
		model.put("resultado", resultado);
		model.put("operacion", operacion);
		
		return new ModelAndView("resultado-operacion", model);
	}

}
