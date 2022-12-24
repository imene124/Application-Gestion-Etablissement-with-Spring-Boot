package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//declaration for entity 
//singleType : pour  tout les entités seront obtenu un seule tableau 

@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE)

//ajouter un colonne type mbr et chaque element string de longueur 3

@DiscriminatorColumn(name= "type_mbr", discriminatorType =
DiscriminatorType.STRING,length = 3)

//objet du classe capable de se transformer en octet et circule à travers réseau 
// tout les classes filles sont Serializables auto à travers extends 
// abstract pour ne pas instancier ce classe 

public abstract class Membre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String nom; 
	private String prenom; 
	private String cv ;
	private String email; 
	private String password;
	private Date date ;
	private  byte[] photo ;
	public Membre() {
		super();
	}
	public Membre(String cin, String nom, String prenom, String cv, String email, String password, Date date,
			byte[] photo) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.cv = cv;
		this.email = email;
		this.password = password;
		this.date = date;
		this.photo = photo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
}
