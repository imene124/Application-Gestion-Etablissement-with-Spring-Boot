package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Publication;

//DAO classes are responsible for providing CRUD operations on database tables

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long>
{
	Publication findBytype(String cin);
	List<Publication>findBytitreStartingWith(String caractere);
	
}
