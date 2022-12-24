package com.example.demo.service;

import java.util.List;


import com.example.demo.entities.Publication;


public interface IPublicationService {
		public Publication addPublication(Publication m);
		public Publication findPublication(Long id) ;
		public List<Publication> findAll();
		//Filtrage par propriété
		public Publication findByTitre(String titre);
		public Publication findByType(String type);
		public Publication updatePublication(Publication p);
	
}
