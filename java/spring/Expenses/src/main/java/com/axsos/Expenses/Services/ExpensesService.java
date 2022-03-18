package com.axsos.Expenses.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.Expenses.models.Expenses;
import com.axsos.Expenses.repositories.ExpenesRepository;

@Service
public class ExpensesService {
	private final ExpenesRepository expensesRepository ;
	    
	    public ExpensesService(ExpenesRepository expensesRepository) {
	        this.expensesRepository = expensesRepository;
	    }
	    // returns all the books
	    public List<Expenses> allExpenses() {
	        return expensesRepository.findAll();
	    }
	    // creates a book
	    public Expenses createExpenses(Expenses b) {
	    	return expensesRepository.save(b);
	    }
	    // retrieves a book
	    public Expenses findExpenses(Long id) {
	        Optional<Expenses> optionalExpenses = expensesRepository.findById(id);
	        if(optionalExpenses.isPresent()) {
	            return optionalExpenses.get();
	        } else {
	            return null;
	        }
	    }
	    public Expenses updateExpenses(Expenses expenses) {
	    	Expenses editExpenses = expensesRepository.findById(expenses.getId()).orElse(null);
	    	assert editExpenses != null;
	    	editExpenses.setName(expenses.getName());
	    	editExpenses.setDescription(expenses.getDescription());
	    	editExpenses.setVendor(expenses.getVendor());
	    	editExpenses.setAmount(expenses.getAmount());
	    	return expensesRepository.save(editExpenses);
	    }
	    public void delete(Expenses expense) {
	    	if (expense != null) {
	    		expensesRepository.delete(expense);}
	    	
	    	}
}
