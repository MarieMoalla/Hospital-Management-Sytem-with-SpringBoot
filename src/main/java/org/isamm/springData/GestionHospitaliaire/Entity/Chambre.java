package org.isamm.springData.GestionHospitaliaire.Entity;

import java.util.ArrayList;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chambre")
public class Chambre {
	
	public long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(long idChambre) {
		this.idChambre = idChambre;
	}

	public java.util.Set<Lit> getLit() {
		return lit;
	}
	public void setLit(java.util.Set<Lit> lit) {
		this.lit = lit;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
	


	@OneToMany(mappedBy="ch")
	private java.util.Set<Lit> lit;

	
	
}

