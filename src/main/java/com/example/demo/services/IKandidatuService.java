package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Kandidats;
import com.example.demo.models.Partija;

public interface IKandidatuService {
	//Atlasīt visus kandidātus konkrētā partijā.
	ArrayList<Kandidats> selectKandidatusByPartijaId(int id)throws Exception;
	//Atlasīt visus kandidātus konkrētā pilsētā.
	ArrayList<Kandidats> selectKandidatusByPilsetaId(int id) throws Exception;

	//Atlasīt tos kandidātus, kuriem balsu skaits ir lielāks par 10.
	ArrayList<Kandidats> selectKandidatusBalsojumsVirsDesmit();

	//Izveidot jaunu kandidātu, tai skaitā, saglabājot sasaisti starp tā pārstāvēto
	//partiju un sasaisti starp tā pārstāvēto pilsētu.
	void insertKandidatu(Kandidats jaunaisKandidats)throws Exception;
	
	//Palielināt konkrēta kandidāta balsu skaitu par vienu balsi.
	void increaseKandidataBalsojumuSkaitu(Kandidats kandidats)throws Exception;
	
}
