package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Etudiant;
//sepecified pour les classe de DAO 
//@services pour les classes de métier 
//@component pour les classes java 
@Repository
public interface EtudiantRepisotory extends JpaRepository<Etudiant, Long>{
	List<Etudiant>findByDiplome(String diplome);
	List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String
	diplome);
}
