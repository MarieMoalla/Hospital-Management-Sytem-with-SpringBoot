package org.isamm.springData.GestionHospitaliaire.Controllers;

import java.util.List;

import org.isamm.springData.GestionHospitaliaire.Entity.Chambre;
import org.isamm.springData.GestionHospitaliaire.Entity.Lit;
import org.isamm.springData.GestionHospitaliaire.Entity.Malade;
import org.isamm.springData.GestionHospitaliaire.Entity.Medecin;
import org.isamm.springData.GestionHospitaliaire.dao.ILitRepository;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MaladeContoller {
	@Autowired
	IMaladeRepository malade;
	@Autowired
	IMedecinRepository medecin;
	@Autowired
	ILitRepository lit;
	
	
	@GetMapping(value = "/malade")
	public String action1 (  Model model,@RequestParam(name="page", defaultValue="0")int p) {
		Page<Malade> page = malade.findAll(PageRequest.of(p,5));
		model.addAttribute("page_malades", page);
		int nbPages = page.getTotalPages();
		int pages[] = new int[nbPages];
		for(int i=0;i<nbPages; i++)
			pages[i]=i;
		model.addAttribute("pages", pages);
		return "malade.html";
}
	
	
	
	
	@GetMapping(value = "/ajoutMalade")
	public String action2 ( Model model) {
		
		List<Medecin> listeMed = medecin.findAll();
		List<Lit> listeLit = lit.findAll(); 
		model.addAttribute("listeMed",listeMed);
		model.addAttribute("listeLit",listeLit);
		
        
		return "ajoutMalade.html";}
	
	
	
	
	
	@GetMapping(value = "/malade-ajout")
	public String action3 ( @RequestParam(name ="age") int age,@RequestParam(name ="idlit") long idlit,@RequestParam(name ="idmed") long idmed, @RequestParam(name ="nom") String nom,@RequestParam(name = "prenom") String prenom, @RequestParam(name = "tele") long tele, @RequestParam(name = "maladie") String maladie, Model model){
		
		Malade m = new Malade (nom,prenom,tele,maladie,age);
		//medecin
		Medecin med = medecin.findById(idmed).get();
		med.getMalade().add(m);
		medecin.save(med);
		m.setMed( medecin.findById(idmed).get());
		
		malade.save(m);
		//lit
		Lit l= lit.findById(idlit).get();
		l.setMalade(m);
		lit.save(l);
		long numlit=  lit.findById(idlit).get().getNumLit();
		m.setLit( lit.findById(idlit).get());
		
		List<Malade> liste = malade.findAll(); 
		model.addAttribute("liste",liste);
		return "redirect:malade";}
	
    
	
	
	@GetMapping(value = "/Supprimer-mal")
	
	public String action4 ( Model model,@RequestParam(name="id", defaultValue="0") long id,@RequestParam(name="idlit", defaultValue="0") long idlit) {
	   
	    Malade m=malade.findById(id).get();
	    Lit l= m.getLit();
	   if(l != null) { 
		   l.setMalade(null);
	    lit.save(l);}
	    malade.deleteById(id);
		List<Malade> liste = malade.findAll(); 
		model.addAttribute("liste",liste);
	    return "redirect:malade";}


   @GetMapping(value = "/modifier-mal")

   public String action5 ( Model model,@RequestParam(name="id", defaultValue="0") long id) {

   //list lit et medecin 
   List<Medecin> listeMed = medecin.findAll();
   List<Lit> listeLit = lit.findAll(); 
   model.addAttribute("listeMed",listeMed);
   model.addAttribute("listeLit",listeLit);
   
   //malade a modifier info
   Malade m= malade.findById(id).get();
   model.addAttribute("mal",m);
   
   //medecin a modifier
   Medecin med= m.getMed();
   long idmedecin = med.getId();
   model.addAttribute("idmedecin",idmedecin);
   
   //lit a modifier
   Lit l=m.getLit();
   if(l != null) {
    long idl=l.getIdLit();
    model.addAttribute("idl",idl);
    Lit ll= lit.findById(idl).get();
    ll.setMalade(null);
    lit.save(ll);
   }

   return "modifierMalade.html";}

   
   
   
   @PostMapping(value = "/malade-modifie")

   public String action6 (  Model model,@ModelAttribute("mal")Malade mal,@RequestParam(name="idlit", defaultValue="0") long idlit,@RequestParam(name="idmed", defaultValue="0") long idmed) {

    mal.setLit(lit.findById(idlit).get());
	Lit l=lit.findById(idlit).get();
	l.setMalade(mal);
	lit.save(l);
	mal.getLit().setIdLit(idlit);
	mal.setMed(medecin.findById(idmed).get());
	malade.save(mal);
    List<Malade> liste = malade.findAll(); 
    model.addAttribute("liste",liste);
    
  return "redirect:malade";}
	
	}
