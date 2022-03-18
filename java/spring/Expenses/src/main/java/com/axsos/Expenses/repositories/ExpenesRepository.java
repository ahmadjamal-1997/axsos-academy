package com.axsos.Expenses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.Expenses.models.Expenses;

@Repository
public interface ExpenesRepository extends CrudRepository<Expenses,Long>{
    List<Expenses> findAll();



}
