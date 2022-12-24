package com.example.demo.sweb;

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

import com.example.demo.entities.Outils;
import com.example.demo.service.IOutilsService;


@RestController
public class RestOutilController {
	@Autowired
	IOutilsService outilservice;
	
	@RequestMapping(value="/outils", method=RequestMethod.GET)
	public List<Outils> findMembres (){
	return outilservice.findAll();
	}
	@GetMapping(value="/outils/{id}")
	public Outils findOneMemberById(@PathVariable Long id){
		return outilservice.findOutils(id);
		}
		@GetMapping(value="/outils/search/source")
		public Outils findOneOutilsBySource(@RequestParam String source)
		{
		return outilservice.findBySource(source);
		}	
	
		@PostMapping(value="/outils")
		public Outils addEvent(@RequestBody Outils e)
		{
		return 	outilservice.addOutils(e);
		}
		@PutMapping(value="/outils/outilsupdate/{id}")
		public Outils updatePub(@PathVariable Long id, @RequestBody Outils p)
		{
		p.setId(id);
		return outilservice.updateOutils(p);
		}
	
}
