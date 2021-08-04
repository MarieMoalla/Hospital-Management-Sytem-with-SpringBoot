package org.isamm.springData.GestionHospitaliaire.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lit")
public class Lit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLit;
	
	public long getIdLit() {
		return idLit;
	}

	public void setIdLit(long idLit) {
		this.idLit = idLit;
	}

	public Chambre getCh() {
		return ch;
	}

	public void setCh(Chambre ch) {
		this.ch = ch;
	}

	

	public Malade getMalade() {
		return malade;
	}

	public void setMalade(Malade malade) {
		this.malade = malade;
	}

	@ManyToOne
	@JoinColumn(name="id_ch",nullable=true)
    private Chambre ch;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	   @JoinColumn(name = "malade_id", nullable= true)
    private Malade malade ;
    public Lit () {}
	
	public long getNumLit() {
		return numLit;
	}

	public void setNumLit(long numLit) {
		this.numLit = numLit;
	}

	public Lit (long idlit) {
		this.numLit=idlit;
		
	}
	private long numLit;
	
}

