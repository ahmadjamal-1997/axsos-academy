package com.axsos.DojosAndNinjas.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.DojosAndNinjas.Services.DojoNinjaService;
import com.axsos.DojosAndNinjas.models.Dojo;
import com.axsos.DojosAndNinjas.models.Ninja;

@Controller
public class DojoNinjaController {
private final DojoNinjaService dojoninjaService;

public DojoNinjaController(DojoNinjaService dojoninjaService) {
	this.dojoninjaService = dojoninjaService;
}

@RequestMapping("/dojos/new")
public String dojo(@ModelAttribute("dojo") Dojo dojo) {
	return "newDojo.jsp";
}
@PostMapping("/dojos/new")
public String newDojo(@Valid@ModelAttribute("dojo") Dojo dojo,BindingResult Result) {
	if (Result.hasErrors()) {
		return "redirect:/dojos/new";
	}
	else {
		dojoninjaService.creatDojo(dojo);
		return "redirect:/dojos/new";
	}
}
@RequestMapping("/ninjas/new")
public String ninja(@ModelAttribute("ninja") Ninja ninja,Model model) {
	List<Dojo> dojos = dojoninjaService.findAllDojos();
	model.addAttribute("dojos", dojos);
	return "newNinja.jsp";
}
@PostMapping("/ninjas/new")
public String newninja(@Valid@ModelAttribute("ninja") Ninja ninja,BindingResult result,Model model) {
	if (result.hasErrors()) {
		return "redirect:/ninjas/new";
	}
	else {
		dojoninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
}
@RequestMapping("dojos/{id}")
public String displayDojo(@PathVariable("id") long id,Model model) {
	Dojo dojo = dojoninjaService.findDojo(id);
	model.addAttribute("dojo", dojo);
	return "details.jsp";
}

}
