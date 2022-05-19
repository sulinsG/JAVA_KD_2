package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Partija;

public interface IPartijaRepo extends CrudRepository<Partija, Integer> {

}
