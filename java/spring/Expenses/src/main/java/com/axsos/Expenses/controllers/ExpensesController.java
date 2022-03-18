package com.axsos.Expenses.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.Expenses.Services.ExpensesService;
import com.axsos.Expenses.models.Expenses;

@Controller
public class ExpensesController {
	 private final ExpensesService expensesService;
	    public ExpensesController(ExpensesService expensesService){
	        this.expensesService = expensesService;
	    }
	    @RequestMapping("/expenses")
	    public String index(Model model, @ModelAttribute("expenses") Expenses expenses) {
	    	List<Expenses> expense = expensesService.allExpenses();
	    	model.addAttribute("expense", expense);
	    	return "info.jsp";
	    }
	    
	    @RequestMapping(value="/expenses/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("expenses") Expenses expenses,BindingResult result) {
	    	if (result.hasErrors()) {
	            return "/info.jsp";
	        } else {
	        expensesService.createExpenses(expenses);
	        return "redirect:/expenses";}
	    }
	    @GetMapping("/expenses/{id}/edit")
	    public String edit(@PathVariable("id") Long id,@ModelAttribute("expensess") Expenses expense, Model model) {
	    	Expenses expenses = expensesService.findExpenses(id);
	        model.addAttribute("expenses", expenses);
	        return "/edit.jsp";
	    }
	    
	    @RequestMapping(value="/expenses/update/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	    public String update(@Valid @ModelAttribute("expensess") Expenses expenses,BindingResult result) {
	    	if (result.hasErrors()) {
	            return "/edit.jsp";
	        } else {
	        	
	        expensesService.updateExpenses(expenses);
	        return "redirect:/expenses";}
	    }
//	    
	    @RequestMapping("/expenses/{id}")
	    public String show(Model model,@PathVariable("id") Long id) {
	        Expenses expense = expensesService.findExpenses(id);
	        model.addAttribute("expense", expense);
	        return "show.jsp";
	    }
	    
	    @RequestMapping("/expenses/{id}/delete")
	    public String delete(@PathVariable("id") long id) {
	    	Expenses expense = expensesService.findExpenses(id);
	    	expensesService.delete(expense);
	    	return "redirect:/expenses";
	    }

}
