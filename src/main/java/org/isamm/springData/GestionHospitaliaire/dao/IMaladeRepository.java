package org.isamm.springData.GestionHospitaliaire.dao;

import org.isamm.springData.GestionHospitaliaire.Entity.Malade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaladeRepository extends JpaRepository<Malade, Long>{

}
