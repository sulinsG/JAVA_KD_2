package com.example.demo.repos;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Novads;
import com.example.demo.models.Pilseta;

public interface IPilsetaRepo extends CrudRepository<Pilseta,Integer> {

	boolean existsByNosaukumsAndNovadsAndIedzivotajuSkaits(@NotNull String nosaukums, Novads novads,
			int iedzivotajuSkaits);

}
