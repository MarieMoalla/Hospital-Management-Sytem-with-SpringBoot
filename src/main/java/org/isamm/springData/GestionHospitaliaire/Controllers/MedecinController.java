package org.isamm.springData.GestionHospitaliaire.Controllers;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.Line;

import org.isamm.springData.GestionHospitaliaire.Entity.Chambre;
import org.isamm.springData.GestionHospitaliaire.Entity.Malade;
import org.isamm.springData.GestionHospitaliaire.Entity.Medecin;
import org.isamm.springData.GestionHospitaliaire.dao.IMaladeRepository;
import org.isamm.springData.GestionHospitaliaire.dao.IMedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MedecinController {
	@Autowired
	IMedecinRepository medecin;
	@Autowired
	IMaladeRepository malade;
	
	@GetMapping(value = "/medecin")
	public String action1 ( Model model,@RequestParam(name="page", defaultValue="0")int p) {
		
		List<Medecin> liste = medecin.findAll(); 
		model.addAttribute("l",liste);
	return "medecin.html";}
	
	
	
	@GetMapping(value = "/ajout-medecin")
	public String action2 ( Model model) {
	List<Medecin> liste = medecin.findAll(); 
	model.addAttribute("liste",liste);

	return "ajoutMedecin.html";}
	
	
	
	@PostMapping(value = "/medecin-ajout")
	
	public String action3 ( @RequestParam(name ="nom") String nom,@RequestParam(name = "prenom") String prenom, @RequestParam(name = "tele") long tele, @RequestParam(name = "dept") String dept,Model model) {
	Medecin m = new Medecin(nom,prenom,tele,dept); 
	medecin.save(m);
	
   
	return "redirect:medecin";}
	
	
	
	
   @GetMapping(value = "/modifier-med")
	
	public String action5 ( Model model,@RequestParam(name="id", defaultValue="0") long id) {
	
	Medecin med= medecin.findById(id).get();
	model.addAttribute("med",med);
	return "modifierMedecin.html";}

   
   
   @PostMapping(value = "/medecin-modifie")

    public String action6 ( Model model, @ModelAttribute("med")Medecin med,@RequestParam(name="dept") String dept) {

    med.setDept(dept);
	medecin.save(med);
    List<Medecin> liste = medecin.findAll(); 
    model.addAttribute("liste",liste);
    return "redirect:medecin";}
	
	
}
