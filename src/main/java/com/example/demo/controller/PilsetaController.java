package com.example.demo.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Pilseta;
import com.example.demo.services.IPilsetaService;

@Controller
@RequestMapping("/pilseta")
public class PilsetaController {

	@Autowired
	private IPilsetaService pilsService;
	
	@GetMapping("/add") //localhost:8080/pilseta/add
	public String getPilsetaNew(Pilseta pilseta) {
		return "pils-add-page";
		}

	@PostMapping("/add")
	public String postPilsetAdd(@Valid Pilseta pilseta, BindingResult result)	// sanem pilnu produktu
	{
		if (!result.hasErrors()) {	//nav nevienas ievades kludas, kas izpilditos pie nepareizs datu ievades
			try {
				pilsService.insertPilseta(pilseta);
				return "redirect:/pilseta/all"; // izsauc url nevis html lapu
			}

			catch (Exception e) {

				e.printStackTrace();
				return "redirect:/pilseta/error-page";
			}
		}
		return "pils-add-page";
		
	}
	@GetMapping("/all")
	public String getPilsetaAll(Model model) {
		model.addAttribute("package", pilsService.selectAllPilsetas());
		return "all-pils-page";
	}
	
	@GetMapping("/updatebyid/{id}")
	public String getByID(@PathVariable(name = "id") int id, Model model) {

		try {
			Pilseta pilsetaForSending = pilsService.selectPilsetaById(id);
			model.addAttribute("package", pilsetaForSending);
			return "pilseta-update-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error-page";
		}

	}

	@PostMapping("/updatebyid/{id}")
	public String postUpdatedPilseta(@PathVariable(name = "id") int id, Pilseta pilseta) {
		try 
		{	
			pilsService.updatePilsetabyId(id, pilseta);
			return "redirect:/pilseta/all/";
		}
		catch (Exception e) {
			return "redirect:/product/error-page";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String getPilsetaDelete(@PathVariable(name = "id") int id, Model model) {
		try {
			pilsService.removePilsetaById(id);
			ArrayList<Pilseta> allPilsetaForSending = pilsService.selectAllPilsetas();
			model.addAttribute("package", allPilsetaForSending);
			return "all-pils-page";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error-page";
		}

	}
	
	@GetMapping("/all/{id}")
	public String getPilsetaAllWithOutQuestionMark(@PathVariable(name = "id") int id, Model model) {
		try {
			Pilseta pilsetaForSending = pilsService.selectPilsetaById(id);
			model.addAttribute("package", pilsetaForSending);
			return "pils-page";
		} catch (Exception e) {
			// e.printStackTrace();
			return "error-page";
		}

	}
	
	}
	
	

