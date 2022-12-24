package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Outils {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	
	private Date date;
	private String source;
	public Outils(Long id, Date date, String source) {
		super();
		this.id = id;
		this.date = date;
		this.source = source;
	}
	public Outils() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
}
