package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Outils;


public interface IOutilsService {
	public Outils addOutils( Outils o);
	public Outils findOutils(Long id) ;
	public List<Outils> findAll();
	//Filtrage par propriété
	public Outils findByTitre(String titre);
	public Outils findBySource(String source);
	public Outils updateOutils(Outils o);
}
