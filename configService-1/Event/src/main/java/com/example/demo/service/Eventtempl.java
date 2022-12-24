package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;
@Service 

public class Eventtempl  implements IEventService{
	@Autowired
	EvenementRepository eventRepository;
	@Override
	public Evenement addEvnet(Evenement e) {
		// TODO Auto-generated method stub
		eventRepository.save(e);
		return e;	
		}

	@Override
	public Evenement findEvenement(Long id) {
		// TODO Auto-generated method stub
		return  eventRepository.findById(id).get();
	}

	@Override
	public List<Evenement> findAll() {
		// TODO Auto-generated method stub
		return eventRepository.findAll();
	}

	@Override
	public Evenement findByTitre(String titre) {
		// TODO Auto-generated method stub
		return eventRepository.findByTitreStartingWith(titre).get(0);
	}

	

	@Override
	public Evenement updateEvenement(Evenement e) {
		// TODO Auto-generated method stub
		return eventRepository.saveAndFlush(e);
	}

	@Override
	public Evenement findByLieu(String lieu) {
		// TODO Auto-generated method stub
		return eventRepository.findByLieu(lieu);	}
}
