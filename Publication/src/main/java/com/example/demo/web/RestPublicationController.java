package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;

@RestController
public class RestPublicationController {
	@Autowired
	IPublicationService pubService;
	@RequestMapping(value="/publication", method=RequestMethod.GET)
	public List<Publication> findMembres (){
	return pubService.findAll();
	}
	@GetMapping(value="/publication/{id}")
	public Publication findOneMemberById(@PathVariable Long id){
		return pubService.findPublication(id);
		}
		@GetMapping(value="/publication/search/titre")
		public Publication findOnePublicationByTitre(@RequestParam String titre)
		{
		return pubService.findByTitre(titre);
		}
	
		@PostMapping(value="/publication/type")
		public Publication addPublication(@RequestBody Publication p)
		{
		return pubService.addPublication(p);
		}
		@PutMapping(value="/publication/pubupdate/{id}")
		public Publication updatePub(@PathVariable Long id, @RequestBody Publication p)
		{
		p.setId(id);
		return pubService.updatePublication(p);
		}
	
}
