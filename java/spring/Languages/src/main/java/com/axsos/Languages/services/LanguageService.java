package com.axsos.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.axsos.Languages.models.Language;
import com.axsos.Languages.repositories.LanguageRepository;

@Service

public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public void updateLanguage(Language lang , Long id) {
    	System.out.println(lang.getId());
    	Language editLanguage = languageRepository.findById(id).orElse(null);
    	System.out.println("editLanguage");
    	assert editLanguage !=null;
    	editLanguage.setName(lang.getName());
    	editLanguage.setCreator(lang.getCreator());
    	editLanguage.setCurrentVersion(lang.getCurrentVersion());
    	languageRepository.save(editLanguage);
    	
    }
    public void deleteLanguage(Long id) {
    	Language language = findLanguage(id);
    	if (language!=null) {
    		languageRepository.deleteById(id);
    	}
    }
		
	}
	

