package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//the entity contain the data : Model 
@Entity
public class Publication {
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private String type;
	  private String titre;
	  private String lien;
	  private String sourcepdf;
	  private Date date ;
	  
	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publication(Long id, String type, String titre, String lien, String sourcepdf, Date date) {
		super();
		this.id = id;
		this.type = type;
		this.titre = titre;
		this.lien = lien;
		this.sourcepdf = sourcepdf;
		this.date = date;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getSourcepdf() {
		return sourcepdf;
	}
	public void setSourcepdf(String sourcepdf) {
		this.sourcepdf = sourcepdf;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	

}
