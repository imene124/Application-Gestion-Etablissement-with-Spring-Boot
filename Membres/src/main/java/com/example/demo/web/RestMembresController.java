package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.service.IMembreService;


@RestController

public class RestMembresController {
	@Autowired
	IMembreService memberService;
	@RequestMapping(value="/membre", method=RequestMethod.GET)
	public List<Membre> findMembres (){
	return memberService.findAll();
	}
	@GetMapping(value="/membre/{id}")
	public Membre findOneMemberById(@PathVariable Long id){
		return memberService.findMember(id);
		}
		@GetMapping(value="/membre/search/cin")
		public Membre findOneMemberByCin(@RequestParam String cin)
		{
		return memberService.findByCin(cin);
		}
		@GetMapping(value="/membre/search/email")
		public Membre findOneMemberByEmail(@RequestParam String email){
		return memberService.findByEmail(email);
		}
		@PostMapping(value="/membres/enseignant")
		public Membre addMembre(@RequestBody EnseignantChercheur m)
		{
		return memberService.addMember(m);
		}
		@PostMapping(value="/membres/etudiant")
		public Membre addMembre(@RequestBody Etudiant e)
		{
		return memberService.addMember(e);
		}
		@DeleteMapping(value="/membres/{id}")
		public void deleteMembre(@PathVariable Long id)
		{
		memberService.deleteMember(id);
		}
}
	
