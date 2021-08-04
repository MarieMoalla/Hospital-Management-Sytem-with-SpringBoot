package org.isamm.springData.GestionHospitaliaire.dao;

import java.awt.print.Pageable;

import org.isamm.springData.GestionHospitaliaire.Entity.Chambre;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IChambreRepository extends JpaRepository<Chambre, Long> {
	
}
