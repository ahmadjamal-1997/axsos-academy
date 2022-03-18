package com.axsos.Expenses.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.Expenses.Services.ExpensesService;
import com.axsos.Expenses.models.Expenses;

@RestController
public class ExpensesAPI {
	

	    private final ExpensesService expensesService;
	    public ExpensesAPI(ExpensesService expensesService){
	        this.expensesService = expensesService;
	    }
	    @RequestMapping("/api/expenses")
	    public List<Expenses> index() {
	        return expensesService.allExpenses();
	    }
	    
	    @RequestMapping(value="/api/expenses", method=RequestMethod.POST)
	    public Expenses create(@RequestParam(value="name") String name, @RequestParam(value="description") String desc,
	    		@RequestParam(value="vendor") String vendor, @RequestParam(value="amount") double amount) {
	        Expenses expenses = new Expenses(name,vendor,amount, desc);
	        return expensesService.createExpenses(expenses);
	    }
	    
	    @RequestMapping("/api/expenses/{id}")
	    public Expenses show(@PathVariable("id") Long id) {
	        Expenses expense = expensesService.findExpenses(id);
	        return expense;
	    }
}
