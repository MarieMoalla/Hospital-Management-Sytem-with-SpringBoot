
package org.isamm.springData.GestionHospitaliaire.Entity;

	import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
	import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Entity 
	@Data
	@Getter
	@Setter
	
	@NoArgsConstructor
	@Table(name = "medecin")
	
	public class Medecin {
		public Medecin() {}
		public Medecin (String nom,String pnom,long tele, String dept) {
			this.Fname=nom;
			this.Lname=pnom;
			this.Tele=tele;
			this.Dept=dept;
		}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long Id;
		
		public long getId() {
			return Id;
		}

		public void setId(long id) {
			Id = id;
		}

		public String getFname() {
			return Fname;
		}

		public void setFname(String fname) {
			Fname = fname;
		}

		public String getLname() {
			return Lname;
		}

		public void setLname(String lname) {
			Lname = lname;
		}

		public String getDept() {
			return Dept;
		}

		public void setDept(String dept) {
			Dept = dept;
		}

		public long getTele() {
			return Tele;
		}

		public void setTele(long tele) {
			Tele = tele;
		}

		public java.util.Set<Malade> getMalade() {
			return malade;
		}

		public void setMalade(java.util.Set<Malade> malade) {
			this.malade = malade;
		}

		@Column(name = "FName")
		private String Fname;
		
		@Column(name = "LName")
		private String Lname;
		
		@Column(name="dept")
		private String Dept;
		
		@Column(name = "Tele")
		private long Tele;

		@OneToMany(mappedBy="med")
		private java.util.Set<Malade> malade;
		
}
