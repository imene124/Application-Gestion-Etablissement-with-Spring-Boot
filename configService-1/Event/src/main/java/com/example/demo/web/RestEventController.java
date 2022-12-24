package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evenement;
import com.example.demo.service.IEventService;

@RestController

public class RestEventController {

		@Autowired
		IEventService eventservice;
		
		@RequestMapping(value="/evenement", method=RequestMethod.GET)
		public List<Evenement> findMembres (){
		return eventservice.findAll();
		}
		@GetMapping(value="/evenement/{id}")
		public Evenement findOneMemberById(@PathVariable Long id){
			return eventservice.findEvenement(id);
			}
			@GetMapping(value="/evenement/search/titre")
			public Evenement findOnePublicationByTitre(@RequestParam String titre)
			{
			return eventservice.findByTitre(titre);
			}	
		
			@PostMapping(value="/evenement/lieu")
			public Evenement addEvent(@RequestBody Evenement e)
			{
			return eventservice.addEvnet(e);
			}
			@PutMapping(value="/evenement/eventupdate/{id}")
			public Evenement updatePub(@PathVariable Long id, @RequestBody Evenement p)
			{
			p.setId(id);
			return eventservice.updateEvenement(p);
			}
		
	}


