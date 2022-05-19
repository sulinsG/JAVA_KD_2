package com.example.demo.repos;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Kandidats;
import com.example.demo.models.Partija;

public interface IKandidatsRepo extends CrudRepository<Kandidats, Integer>{

	ArrayList<Kandidats> findByPartijaIdPa(int id);

	ArrayList<Kandidats> findByPilsetaIdPi(int id);

	ArrayList<Kandidats> findByBalsojumsGreaterThan(int i);

	boolean existsByVardsAndUzvardsAndPartija(@NotNull String vards, @NotNull String uzvards, Partija partija);

}
