package org.isamm.springData.GestionHospitaliaire.Controllers;

import java.util.List;

import org.isamm.springData.GestionHospitaliaire.Entity.Chambre;
import org.isamm.springData.GestionHospitaliaire.Entity.Lit;
import org.isamm.springData.GestionHospitaliaire.Entity.Malade;
import org.isamm.springData.GestionHospitaliaire.Entity.Medecin;
import org.isamm.springData.GestionHospitaliaire.dao.IChambreRepository;
import org.isamm.springData.GestionHospitaliaire.dao.ILitRepository;
import org.isamm.springData.GestionHospitaliaire.dao.IMaladeRepository;
import org.isamm.springData.GestionHospitaliaire.dao.IMedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LitController {
	@Autowired
	IMaladeRepository malade;
	
	@Autowired
	ILitRepository lit;
	
	@Autowired
	IChambreRepository chambre;
	
	@GetMapping(value = "/lit")
	public String action1 ( Model model,@RequestParam(name="page", defaultValue="0")int p) {
		Page<Lit> page = lit.findAll(PageRequest.of(p,5));
		model.addAttribute("page_lits", page);
		int nbPages = page.getTotalPages();
		int pages[] = new int[nbPages];
		for(int i=0;i<nbPages; i++)
			pages[i]=i;
		model.addAttribute("pages", pages);return "lit.html";}
	
	
	
	
	@GetMapping(value = "/ajout-lit")
	public String action2 ( Model model) {
		List<Chambre> listech = chambre.findAll();
		List<Lit> liste = lit.findAll(); 
		model.addAttribute("liste",liste);
        model.addAttribute("listech",listech);
		return "ajoutLit.html";}
	
   
	
	
	@GetMapping(value = "/lit-ajout")
	
	public String action3 ( @RequestParam(name ="idchamb") long idchamb,Model model) {
    Lit l = new Lit();
    Chambre ch = chambre.findById(idchamb).get();
    l.setCh(ch);
    ch.getLit().add(l);
    chambre.save(ch);
    if(l.getMalade()!= null) {
    String prenom = l.getMalade().getFname();
    String nom= l.getMalade().getLname();
    model.addAttribute("prenom",prenom);
	model.addAttribute("nom",nom);}
    lit.save(l);
    return "redirect:lit";}
   
	
	
	
	@GetMapping(value = "/Supprimer-lit")

    public String action4 ( Model model,@RequestParam(name="id", defaultValue="0") long id) {
	lit.deleteById(id);
	
    return "redirect:lit";}
	
}
