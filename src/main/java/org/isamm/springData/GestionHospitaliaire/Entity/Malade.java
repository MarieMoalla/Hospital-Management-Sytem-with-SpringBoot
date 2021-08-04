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

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "malade")

public class Malade {
	public  Malade () {}
	public  Malade (String nom,String prenom,long tele,String maladie,int age) {
		this.maladie=maladie;
		this.tele=tele;
		this.FName=prenom;
		this.Lname=nom;
		this.age=age;
		
	
		
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMal ;
	
	public long getIdMal() {
		return idMal;
	}

	public void setIdMal(long idMal) {
		this.idMal = idMal;
	}

	public String getFname() {
		return FName;
	}

	public void setFname(String fName) {
		FName = fName;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getTele() {
		return tele;
	}

	public void setTele(long tele) {
		this.tele = tele;
	}

	public String getMaladie() {
		return maladie;
	}

	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}

	public Medecin getMed() {
		return med;
	}

	public void setMed(Medecin med) {
		this.med = med;
	}

	public Lit getLit() {
		return lit;
	}

	public void setLit(Lit lit) {
		this.lit = lit;
	}

	
	@Column(name = "FName")
	private String FName;
	
	@Column(name = "LName")
	private String Lname;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "tele")
	private long tele;
	
	@Column(name = "maladie")
	private String maladie;
	
	@ManyToOne
	@JoinColumn(name="id_med",nullable=true)
    private Medecin med;
	
	@OneToOne(mappedBy = "malade")
    private Lit lit;
	
	
	

}
