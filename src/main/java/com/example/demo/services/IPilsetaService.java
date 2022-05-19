package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Pilseta;

public interface IPilsetaService {
	
	void insertPilseta(Pilseta pilseta)throws Exception;
	
	void updatePilsetabyId(int id, Pilseta tmp) throws Exception;
	
	Pilseta selectPilsetaById(int id)throws Exception;
	
	void removePilsetaById(int id)throws Exception;
	
	ArrayList<Pilseta> selectAllPilsetas();

}
