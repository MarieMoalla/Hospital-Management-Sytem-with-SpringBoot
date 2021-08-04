package org.isamm.springData.GestionHospitaliaire.Controllers;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.isamm.springData.GestionHospitaliaire.Entity.Medecin;
import org.isamm.springData.GestionHospitaliaire.dao.IMedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class GhController {
	
	
	@GetMapping(value = "/")
	public String acceuil() {
	return "index.html";
	}
	
	
	
}
