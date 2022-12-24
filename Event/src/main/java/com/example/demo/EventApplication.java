
package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;
import com.example.demo.service.IEventService;

@SpringBootApplication
@EnableDiscoveryClient
public class EventApplication implements CommandLineRunner{
	@Autowired
	IEventService evservice;
	@Autowired
	EvenementRepository eventRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}
	
@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormatter.parse("2010-05-01");
		Date date2 = dateFormatter.parse("2019-05-01");
		Date date3 = dateFormatter.parse("2012-05-01");
	
		Evenement ev1= new Evenement((long) 185526 , "Event human" , date1, "France");
		Evenement ev2= new Evenement((long) 185526 , "Event Theatre" , date2, "Milano");
		Evenement ev3= new Evenement((long) 185526 , "Event Music" , date3, "America");
		eventRepository.save(ev1);
		eventRepository.save(ev2);
		eventRepository.save(ev3);

		
		Evenement e =eventRepository.findById(3L).get();
		e.setTitre("Event Info");
		eventRepository.save(e);
		eventRepository.deleteById(2L);
		List<Evenement> listmembre = evservice.findAll();
		for (Evenement e1 : listmembre) {
			System.out.println(e1.getLieu()+ " " + e1.getTitre());
		}
		e.setDate(date2);
	
	}
	
}
