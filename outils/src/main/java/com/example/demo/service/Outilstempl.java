package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OutilsRepository;
import com.example.demo.entities.Outils;

@Service 

public class Outilstempl implements IOutilsService {
	@Autowired
	OutilsRepository outilrepo;
	@Override
	public Outils addOutils(Outils o) {
		// TODO Auto-generated method stub
		outilrepo.save(o);
		return o;
		}

	@Override
	public Outils findOutils(Long id) {
		// TODO Auto-generated method stub
		return  outilrepo.findById(id).get();
	}

	@Override
	public List<Outils> findAll() {
		// TODO Auto-generated method stub
		return outilrepo.findAll();
	}

	@Override
	public Outils findByTitre(String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Outils findBySource(String caractere) {
		// TODO Auto-generated method stub
 		return  outilrepo.findBySourceStartingWith(caractere).get(0);
	}	

	@Override
	public Outils updateOutils(Outils o) {
		// TODO Auto-generated method stub
		return outilrepo.saveAndFlush(o); 
	}

}
