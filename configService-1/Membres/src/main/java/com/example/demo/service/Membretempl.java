package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepisotory;
import com.example.demo.dao.MembreRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

@Service
public class Membretempl implements IMembreService{
	@Autowired
	MembreRepository membreRepository;
	@Autowired
    EtudiantRepisotory etudiantRepo;
	@Autowired
     EnseignantChercheurRepository enseignantRepo ; 
	@Override
	public Membre addMember(Membre m) {
		// TODO Auto-generated method stub
		 		return membreRepository.save(m);

	}
	@Override
	public void deleteMember(Long id) {
		// TODO Auto-generated method stub
		membreRepository.deleteById(id);
	}
	@Override
	public Membre updateMember(Membre p) {
		// TODO Auto-generated method stub
		return membreRepository.saveAndFlush(p);
	}
	@Override
	public Membre findMember(Long id) {
		// TODO Auto-generated method stub
		return membreRepository.findById(id).get();
	}
	@Override
	public List<Membre> findAll() {
		// TODO Auto-generated method stub
		return membreRepository.findAll();
	}
	@Override
	public Membre findByCin(String cin) {
		// TODO Auto-generated method stub
		return membreRepository.findByCin(cin);
	}
	@Override
	public Membre findByEmail(String email) {
		// TODO Auto-generated method stub
		return membreRepository.findByEmail(email);
	}
	@Override
	public List<Membre> findByNom(String nom) {
		// TODO Auto-generated method stub
		return membreRepository.findByNomStartingWith(nom);
	}
	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		// TODO Auto-generated method stub
		return etudiantRepo.findByDiplome(diplome);
	}
	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		// TODO Auto-generated method stub
		return enseignantRepo.findByGrade(grade);
	}
	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		// TODO Auto-generated method stub
		return enseignantRepo.findByEtablissement(etablissement);
	}
	public void affectetudtoens(Long idetd, Long idens) {
		// TODO Auto-generated method stub
		//on obtient les etudiants et 
		Etudiant etd= etudiantRepo.findById(idetd).get();
		EnseignantChercheur ens = enseignantRepo.findById(idens).get();
		//encadrant_id for id 1 devient 4 
		etd.setEncadrant(ens);
		etudiantRepo.save(etd);
	}

		
			
			
		
}
	


