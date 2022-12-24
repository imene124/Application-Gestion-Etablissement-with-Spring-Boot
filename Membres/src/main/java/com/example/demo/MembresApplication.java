package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepisotory;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.service.IMembreService;




@SpringBootApplication
@EnableDiscoveryClient
public class MembresApplication implements CommandLineRunner {
	//injection des dependances : instanciation from DAO déja déclaré en dao 
	@Autowired
	EtudiantRepisotory  etudiantRepisotory;
	@Autowired

	EnseignantChercheurRepository enseignantRepisotory;
@Autowired
IMembreService membreservice ;
	public static void main(String[] args) {
		SpringApplication.run(MembresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormatter =new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormatter.parse("2010-05-01");
		Date date2 = dateFormatter.parse("2019-05-01");
		Date date3 = dateFormatter.parse("2012-05-01");
		Date date4 = dateFormatter.parse("2012-03-01");
		
		Etudiant etd1= new Etudiant("081705454", "ben fekih", "rim", "", "rim@enis.rn", "11111", date1, null, date1, "these");
		Etudiant etd2= new Etudiant("885705454", "ben ahmed", "sana", "",  "sana@enis.rn", "11111", date2, null, date2,  "mastere");
		Etudiant etd3= new Etudiant("081454", "chaari", "rim", "",  "chaari@enis.rn", "11111", date3, null,date3,"ingénieur");
		etudiantRepisotory.save(etd1);
		etudiantRepisotory.save(etd2);
		etudiantRepisotory.save(etd3);
		EnseignantChercheur ens1= new EnseignantChercheur("12860082", "Mayssa", "Alouane", "", "mayssa.alouane@gmail.com","123456",
				date3, null, "GE3", "Enis");
		EnseignantChercheur ens2= new EnseignantChercheur("14001558", "Aya", "Cherifa", "", "ayacherif129@gmail.com","123456",
				date3, null, "GE3", "Enis");
		enseignantRepisotory.save(ens1);
		enseignantRepisotory.save(ens2);
	
	// on modifie élement d'indice 2  : 2L : son type Long 	
Etudiant e=etudiantRepisotory.findById(2L).get();
e.setPrenom("Salah");
etudiantRepisotory.save(e);
//effacer le ligne d'indice 2
etudiantRepisotory.deleteById(2L);
List<Membre> listmembre = membreservice.findAll();
for (Membre m : listmembre) {
	System.out.println(m.getNom() + "" + m.getPrenom());
}
membreservice.affectetudtoens(1L, 4L);

}
	
	
	

}
