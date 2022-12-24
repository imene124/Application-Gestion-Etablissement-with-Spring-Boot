package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.OutilsRepository;
import com.example.demo.entities.Outils;

@SpringBootApplication
@EnableDiscoveryClient
public class OutilsApplication implements CommandLineRunner{
	@Autowired
	OutilsRepository  outilRepository;

	public static void main(String[] args)  {
		SpringApplication.run(OutilsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormatter.parse("2010-05-01");
		Date date2 = dateFormatter.parse("2019-05-01");
		Date date3 = dateFormatter.parse("2012-05-01");
	
		Outils ou1= new Outils((long) 189 , date1 , "Labo1");
		Outils ou2= new Outils((long) 14599 , date1 , "Labo2");
		Outils ou3= new Outils((long) 5869 , date1 , "Labo3");
		outilRepository.save(ou1);
		outilRepository.save(ou2);
		outilRepository.save(ou3);
		
		Outils e =outilRepository.findById(3L).get();
		e.setSource("Laboo");
		outilRepository.save(e);
		outilRepository.deleteById(1L);
		List<Outils> listmembre = outilRepository.findAll();
		for (Outils  e1 : listmembre) {
			System.out.println(e1.getSource()+ " " + e1.getDate());
		}
		e.setDate(date2);
	}

}
