package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Evenement;


public interface IEventService {
	public Evenement addEvnet( Evenement e);
	public Evenement findEvenement(Long id) ;
	public List<Evenement> findAll();
	//Filtrage par propriété
	public Evenement findByTitre(String titre);
	public Evenement findByLieu(String lieu);
	public Evenement updateEvenement(Evenement e);
}
