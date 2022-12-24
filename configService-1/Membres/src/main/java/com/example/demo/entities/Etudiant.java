package com.example.demo.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity@DiscriminatorValue("etd")
public class Etudiant extends Membre {
	
	private Date dateInscription;
	private String diplome;
	// chaque etudiant ayant 1 enseignant 
	//bidirectionnel 
	@ManyToOne
	private EnseignantChercheur encadrant;
	public Etudiant() {
		super();
	}
	
	
	public Etudiant(String cin, String nom, String prenom, String cv, String email, String password, Date date,
			byte[] photo, Date dateInscription, String diplome) {
		super(cin, nom, prenom, cv, email, password, date, photo);
		this.dateInscription = dateInscription;
		this.diplome = diplome;
	}


	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}


	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}


	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}
	

}
