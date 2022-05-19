package com.example.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Pilseta;
import com.example.demo.repos.IPilsetaRepo;
import com.example.demo.services.IPilsetaService;

@Service
public class PilsetaService implements IPilsetaService {

	@Autowired
	IPilsetaRepo pilsRepo;
	
	@Override
	public void insertPilseta(Pilseta pilseta) throws Exception {
		if(pilsRepo.existsByNosaukumsAndNovadsAndIedzivotajuSkaits(pilseta.getNosaukums(),
																	pilseta.getNovads(),
																	pilseta.getIedzivotajuSkaits()))
		{
			throw new Exception("Pilseta jau eksiste");
			
		}
		else
		{
			Pilseta jaunaPilseta = new Pilseta(pilseta.getNosaukums(),pilseta.getNovads(),pilseta.getIedzivotajuSkaits());
			pilsRepo.save(jaunaPilseta);
		}
		
	}

	@Override
	public void updatePilsetabyId(int id, Pilseta tmp) throws Exception {
		if(pilsRepo.existsById(id))
		{
			Pilseta pils = pilsRepo.findById(id).get();
			pils.setNosaukums(tmp.getNosaukums());
			pils.setIedzivotajuSkaits(tmp.getIedzivotajuSkaits());
			pils.setNovads(tmp.getNovads());
			pils.setKandidatuSaraksts(tmp.getKandidatuSaraksts());
			pilsRepo.save(pils);			
		}
		else
			throw new Exception("Tada pilseta neeksiste, nepareizs id");
	}

	@Override
	public Pilseta selectPilsetaById(int id) throws Exception {
		if(pilsRepo.existsById(id))
		{
			return pilsRepo.findById(id).get();
		}
		else
			throw new Exception("Tada pilseta neeksiste, nepareizs id");
		
	}

	@Override
	public void removePilsetaById(int id) throws Exception {
	if(pilsRepo.existsById(id))
	{
		pilsRepo.deleteById(id);
	}
	else
		throw new Exception("Tada pilseta neeksiste, nepareizs id");
	
		
	}

	@Override
	public ArrayList<Pilseta> selectAllPilsetas(){
		return (ArrayList<Pilseta>)pilsRepo.findAll();
	}

}
