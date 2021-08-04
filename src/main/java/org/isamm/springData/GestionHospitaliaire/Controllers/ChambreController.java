package org.isamm.springData.GestionHospitaliaire.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.isamm.springData.GestionHospitaliaire.Entity.Chambre;
import org.isamm.springData.GestionHospitaliaire.Entity.Lit;
import org.isamm.springData.GestionHospitaliaire.dao.IChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChambreController {
	@Autowired
	IChambreRepository chambre;
	
	@GetMapping(value = "/chambre")
	public String action1 ( Model model,@RequestParam(name="page", defaultValue="0")int p) {
		Page<Chambre> page = chambre.findAll(PageRequest.of(p,5));
		model.addAttribute("page_chambres", page);
		int nbPages = page.getTotalPages();
		int pages[] = new int[nbPages];
		for(int i=0;i<nbPages; i++)
			pages[i]=i;
		model.addAttribute("pages", pages);
		return "chambre.html";
}
	
	
	
	@GetMapping(value = "/chambre-info")
	public String action2 ( Model model,@RequestParam(name="idch", defaultValue="0") long idch) {
	Set<Lit> liste = chambre.findById(idch).get().getLit();
	List<Lit> listelit = new ArrayList<Lit>();
	for(Lit l:liste) {
		listelit.add(l);
	}
	model.addAttribute("idch",idch);
    model.addAttribute("listelit",listelit);
	return "chambre-info.html";
}	
	
	
	
	
	@GetMapping(value = "/ajout-chambre")
	public String action3 ( Model model) {
	Chambre ch =new Chambre();
	chambre.save(ch);
	return "redirect:chambre";
}	
}
