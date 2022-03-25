package com.axsos.Languages.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.axsos.Languages.models.Language;
import com.axsos.Languages.services.LanguageService;
@SpringBootApplication
@Controller
public class TestLanguage {
	private final LanguageService languageService;

	public TestLanguage(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/languages")
	public String mainPage(Model model , @ModelAttribute("lang") Language lang) {
		List <Language> language = languageService.allLanguages();
		model.addAttribute("language", language);
		return "home.jsp";
	}
	@PostMapping("/create")
	public String form(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "home.jsp";
		}
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	@GetMapping("/languages/{id}")
	public String show(@PathVariable ("id") Long id , Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "details.jsp";
		
		
	}
	
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id , Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	
	@RequestMapping(value ="/edit/{id}" , method = RequestMethod.PUT)
	public String updateForm(@PathVariable("id") Long id,@Valid @ModelAttribute("language") Language language , BindingResult result) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languageService.updateLanguage(language , id);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	public String deleteLang(@PathVariable("id") Long id , @ModelAttribute("language") Language language) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
	
	

}
