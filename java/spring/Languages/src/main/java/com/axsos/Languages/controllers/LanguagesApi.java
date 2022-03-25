package com.axsos.Languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.Languages.models.Language;
import com.axsos.Languages.services.LanguageService;

@RestController

public class LanguagesApi {
	private final LanguageService languageService;

	public LanguagesApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") Double currentVersion) {
        Language language = new Language(name, creator, currentVersion);
        return languageService.createLanguage(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
    	Language language = languageService.findLanguage(id);
        return language;
    }
	
	

}
