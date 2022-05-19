package com.example.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Kandidats;
import com.example.demo.models.Pilseta;
import com.example.demo.repos.IBalsojumsRepo;
import com.example.demo.repos.IKandidatsRepo;
import com.example.demo.repos.IPartijaRepo;
import com.example.demo.repos.IPilsetaRepo;
import com.example.demo.services.IKandidatuService;

@Service
public class KandidatuService implements IKandidatuService {

	
	@Autowired
	IKandidatsRepo kandRepo;
	
	@Autowired
	IPartijaRepo partRepo;
	
	@Autowired
	IPilsetaRepo pilsRepo;
	
	@Autowired
	IBalsojumsRepo balsRepo;
	
	@Override
	public ArrayList<Kandidats> selectKandidatusByPartijaId(int id) throws Exception {
		if(partRepo.existsById(id))
		{
			return kandRepo.findByPartijaIdPa(id);
		}
		else
			throw new Exception("Nav atrasta partija ar tadu id");
	}

	@Override
	public ArrayList<Kandidats> selectKandidatusByPilsetaId(int id) throws Exception {
		if(pilsRepo.existsById(id))
		{
			return kandRepo.findByPilsetaIdPi(id);
		}
		else
			throw new Exception("Nav atrasta partija ar tadu id");
	}

	@Override
	public ArrayList<Kandidats> selectKandidatusBalsojumsVirsDesmit() {
		return kandRepo.findByBalsojumsGreaterThan(10);
	}


	@Override
	public void insertKandidatu(Kandidats jaunaisKandidats) throws Exception {
		if(kandRepo.existsByVardsAndUzvardsAndPartija(jaunaisKandidats.getVards(),jaunaisKandidats.getUzvards(),jaunaisKandidats.getPartija()))
		{
			throw new Exception("Kandidats jau eksiste");
		
		}
		else
		{
		Kandidats kandidats = new Kandidats(jaunaisKandidats.getVards(),
											jaunaisKandidats.getUzvards(),
											jaunaisKandidats.getPartija());
			kandidats.setPilseta(jaunaisKandidats.getPilseta());
		}
			
		}

	@Override
	public void increaseKandidataBalsojumuSkaitu(Kandidats kandidats) throws Exception {
		if(kandRepo.existsByVardsAndUzvardsAndPartija(kandidats.getVards(),kandidats.getUzvards(),kandidats.getPartija()))
		{
			int balsuSkaits = kandRepo.findById(kandidats.getIdK()).get().getBalsojums().getBalsis() + 1;
			kandRepo.findById(kandidats.getIdK()).get().getBalsojums().setBalsis(balsuSkaits);
				
		}
		else
			throw new Exception("Kandidats neeksiste");
		}


}
