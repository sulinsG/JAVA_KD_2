package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Kandidats;
import com.example.demo.models.Pilseta;
import com.example.demo.services.IKandidatuService;


@Controller
@RequestMapping("/kandidats")
public class ExtraController {
	
	@Autowired
	private IKandidatuService kandService;
	
	
	@GetMapping("/all/partija/{id}")
	public String getKandidatsByPartijaId(@PathVariable(name = "id") int id, Model model) {
		try {
			ArrayList<Kandidats> kandSaraksts = kandService.selectKandidatusByPartijaId(id);
			model.addAttribute("package", kandSaraksts);
			return "show-candidates";
		} catch (Exception e) {
			// e.printStackTrace();
			return "error-page";
		}

	}
	
	@GetMapping("/all/pilseta/{id}")
	public String getKandidatsByPilsetaId(@PathVariable(name = "id") int id, Model model) {
		try {
			ArrayList<Kandidats> kandSaraksts = kandService.selectKandidatusByPilsetaId(id);
			model.addAttribute("package", kandSaraksts);
			return "show-candidates";
		} catch (Exception e) {
			// e.printStackTrace();
			return "error-page";
		}

	}
	
	@GetMapping("/all/paridesmit")
	public String getKandidatsVirsDesmit(Model model) {
		try {
			ArrayList<Kandidats> kandSaraksts = kandService.selectKandidatusBalsojumsVirsDesmit();
			model.addAttribute("package", kandSaraksts);
			return "show-candidates";
		} catch (Exception e) {
			// e.printStackTrace();
			return "error-page";
		}

	}

}
