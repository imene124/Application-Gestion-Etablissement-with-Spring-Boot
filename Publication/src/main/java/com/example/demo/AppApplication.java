package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.PublicationRepository;

import com.example.demo.entities.Publication;
import com.example.demo.service.IPublicationService;
@SpringBootApplication
@EnableDiscoveryClient
public class AppApplication implements CommandLineRunner {
	@Autowired
	IPublicationService pubservice;
	@Autowired

	PublicationRepository  pubRepo; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormatter.parse("2010-05-01");
		Date date2 = dateFormatter.parse("2019-05-01");
		Date date3 = dateFormatter.parse("2012-05-01");
	
		Publication pub1= new Publication((long) 1622555,"commercial", "helloWorld", "wwxw.comercial.com","imagine",date1 );
		Publication pub2= new Publication((long) 178546,"Droit", "Your Future", "wwxw.droit.com","believe",date2 );
		Publication pub3= new Publication((long) 1622555,"compta", "Calculate", "wwxw.comptability.com","calcul",date3);
		pubRepo.save(pub1);
	
		pubRepo.save(pub2);
		pubRepo.save(pub3);

	

	
		Publication p =pubRepo.findById(2L).get();
		p.setTitre("Hi mayna");
		pubRepo.save(p);
		pubRepo.deleteById(2L);
		List<Publication> listmembre = pubservice.findAll();
		for (Publication p1 : listmembre) {
			System.out.println(p1.getType() + "" + p1.getSourcepdf());
		}
		p.setSourcepdf("");
	}

}
