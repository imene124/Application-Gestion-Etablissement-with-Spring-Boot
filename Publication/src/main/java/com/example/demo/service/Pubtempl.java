package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

@Service 
public class Pubtempl implements IPublicationService{
	//l'injection automatique de dépendance AppRepo
	@Autowired
	PublicationRepository pubRepository;

	@Override
	public Publication addPublication(Publication p) {
		// TODO Auto-generated method stub
		pubRepository.save(p);
		return p;
	}

	@Override
	public Publication findPublication(Long id) {
		// TODO Auto-generated method stub
		return  pubRepository.findById(id).get();
	}

	@Override
	public List<Publication> findAll() {
		// TODO Auto-generated method stub
		return pubRepository.findAll();
	}

	@Override
	public Publication findByTitre(String titre) {
		// TODO Auto-generated method stub
		return pubRepository.findBytitreStartingWith(titre).get(0);
	}

	@Override
	public Publication findByType(String type) {
		// TODO Auto-generated method stub
		return pubRepository.findBytype(type);
	}



	@Override
	public Publication updatePublication(Publication p) {
		// TODO Auto-generated method stub
		return pubRepository.saveAndFlush(p);
	}




}
