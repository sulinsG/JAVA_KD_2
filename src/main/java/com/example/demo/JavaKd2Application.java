package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Balsojums;
import com.example.demo.models.Kandidats;
import com.example.demo.models.Novads;
import com.example.demo.models.Partija;
import com.example.demo.models.Pilseta;
import com.example.demo.repos.IBalsojumsRepo;
import com.example.demo.repos.IKandidatsRepo;
import com.example.demo.repos.IPartijaRepo;
import com.example.demo.repos.IPilsetaRepo;


@SpringBootApplication
public class JavaKd2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaKd2Application.class, args);
	}

	@Bean	
	public CommandLineRunner testDB(IBalsojumsRepo balsRepo,
			IKandidatsRepo kandRepo, IPartijaRepo partRepo,
			IPilsetaRepo pilsRepo)
	{
	return new CommandLineRunner() {
		
		@Override
		public void run(String... args) throws Exception {
			
			Pilseta pl1 = new Pilseta("Jekabpils", Novads.Zemgale, 12000);
			Pilseta pl2 = new Pilseta("Riga", Novads.Vidzeme, 52000);
			Pilseta pl3 = new Pilseta("Jelgava", Novads.Zemgale, 36000);

			pilsRepo.save(pl1);
			pilsRepo.save(pl2);
			pilsRepo.save(pl3);
			
			Partija p1 = new Partija("Banani", "Ban", (float) 1337.0);
			Partija p2 = new Partija("Nekompetentie", "Nek", (float) 420.0);
			Partija p3 = new Partija("Banditi", "Bnd", (float) 69.0);
					
			partRepo.save(p1);
			partRepo.save(p2);
			partRepo.save(p3);
			
			Kandidats k1 = new Kandidats("Andris", "Ravins", p3);
			Kandidats k2 = new Kandidats("Nils", "Usakovs", p1);
			Kandidats k3 = new Kandidats("Aivars", "Lembergs", p2);
			
			kandRepo.save(k1);
			kandRepo.save(k2);
			kandRepo.save(k3);
			
			Balsojums b1 = new Balsojums(5, k1);
			Balsojums b2 = new Balsojums(7, k2);
			Balsojums b3 = new Balsojums(20, k3);
			
			balsRepo.save(b1);
			balsRepo.save(b2);
			balsRepo.save(b3);


		}
	};
	}
	
	
}
