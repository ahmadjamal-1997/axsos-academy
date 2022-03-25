package com.axsos.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.Languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
    // this method retrieves all the books from the database
    List<Language> findAll();

}
