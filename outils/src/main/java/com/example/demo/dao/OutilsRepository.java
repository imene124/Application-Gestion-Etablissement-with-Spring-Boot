package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Outils;


@Repository

public interface OutilsRepository extends JpaRepository<Outils,Long>{

	List<Outils>findBySourceStartingWith(String caractere);
	Outils findByDate( Date date);
}
