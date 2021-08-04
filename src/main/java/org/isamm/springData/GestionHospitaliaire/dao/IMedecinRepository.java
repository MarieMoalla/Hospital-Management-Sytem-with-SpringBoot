package org.isamm.springData.GestionHospitaliaire.dao;

import java.util.List;

import org.isamm.springData.GestionHospitaliaire.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMedecinRepository extends JpaRepository<Medecin, Long> {
	//public List<Medecin> findAllById(Iterable<Long> id); 
}