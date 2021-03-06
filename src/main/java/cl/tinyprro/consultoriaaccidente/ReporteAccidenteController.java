package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.ReporteAccidente;
import cl.tinyprro.services.ReporteAccidenteService;

@Controller
public class ReporteAccidenteController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReporteAccidenteController.class);

	@Autowired
	ReporteAccidenteService rar;
	/**
	 * MUestra la vista de la lista de accidentes
	 * @return
	 */
	@RequestMapping(value = "/ReportesAccidentesAll")
	public ModelAndView listarReportes(Locale locale, ModelMap model) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/
		List<ReporteAccidente> lista = rar.getAll();
		
		return new ModelAndView("admin/AccidentabilidadReadAll", "listaAccidente", lista);
	}
	@RequestMapping(value = "/ReportesAccidentes/{id}")
	public ModelAndView listarReportesById(@PathVariable int id) {
		List<ReporteAccidente> lista  = rar.getAll();
		int idCliente = id;
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listaReporte", lista);
		model.put("idCliente", idCliente);
		
		return new ModelAndView("admin/AccidentabilidadReadById", "model", model);
	}
	
	/**
	 * Muestra la Vista del formulario para crear un reporte de accidente
	 * @return
	 */
	@RequestMapping(value = "/ReportarAccidente", method = RequestMethod.GET)
	public ModelAndView formCrearAccidente(Locale locale, ModelMap model) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/	
		logger.info("/ReportarAccidente estamos en ReporteAccidenteController ");
		
		return new ModelAndView("cliente/ReporteAccCreate");
	}
	
	@RequestMapping(value = "/ReporteAccCreate", method = RequestMethod.POST)
	public ModelAndView insertarAccidente(Locale locale, ModelMap model,HttpServletRequest request) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/
		rar.add(new ReporteAccidente(
				request.getParameter("tipoAccidente"),
				Integer.parseInt(request.getParameter("diasPerdidos")),
				request.getParameter("fechaAccidente"),
				request.getParameter("lugarAccidente"),
				request.getParameter("descripcion"),
				Integer.parseInt(request.getParameter("idCliente"))));;
		
		return new ModelAndView("redirect:/ReportarAccidente");
	}
	
	
	
	
	/*
		
	private static final Logger logger = LoggerFactory.getLogger(ReporteAccidenteController.class);

	@Autowired
	DAOaccidente accidenteDAO;

	

	@RequestMapping(value = "/ReporteAccidenteCreate", method = RequestMethod.GET)
	public String reporteaccidentecrear(Model model) {
		logger.info("/ReporteAccidenteCreate estamos en ReporteAccidenteController ");

		return "cliente/ReporteAccCreate";
	}
	
	@RequestMapping(value = "/ReporteAccCreate", method = RequestMethod.POST)
	public ModelAndView insertarAccidente(HttpServletRequest request) {

		accidenteDAO.insertar(new ReporteAccidente(
				request.getParameter("tipoAccidente"),
				Integer.parseInt(request.getParameter("diasPerdidos")),
				request.getParameter("fechaAccidente"),
				request.getParameter("lugarAccidente"),
				request.getParameter("descripcion"),
				Integer.parseInt(request.getParameter("idCliente"))));

		List<ReporteAccidente> lista = accidenteDAO.buscarTodos();

		return new ModelAndView("cliente/ReporteAccReadCliente", "listaAccidente", lista);
	}

	@RequestMapping(value = "/Accidentabilidad", method = RequestMethod.GET)
	public String accidentabilidad(Model model) {
		logger.info("/Accidentabilidad estamos en ReporteAccidenteController ");


		return "admin/AccidentabilidadReadAll";
	}
	
	*/
}
