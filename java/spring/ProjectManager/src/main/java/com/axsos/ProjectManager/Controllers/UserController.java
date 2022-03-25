package com.axsos.ProjectManager.Controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.ProjectManager.Services.UserService;
import com.axsos.ProjectManager.models.LoginUser;
import com.axsos.ProjectManager.models.User;

@Controller
public class UserController {
private final UserService userService;

public UserController(UserService userService) {
	this.userService = userService;
}

@GetMapping("/")
public String showForm(Model model) {
	model.addAttribute("newUser",new User());
	model.addAttribute("newLogin",new LoginUser());
	return "main.jsp";
}
@PostMapping("/new/user")
public String creatUser(@Valid @ModelAttribute("newUser") User user,BindingResult result,Model model,HttpSession session) {
	userService.register(user, result);
	if (result.hasErrors()) {
		model.addAttribute("newLogin",new LoginUser());
		return "main.jsp";
	}
	else {
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}
}
@PostMapping("/login")
public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,BindingResult result,Model model,HttpSession session) {
	User user =userService.login(newLogin, result);
	
	if(result.hasErrors()) {
		model.addAttribute("newUser",new User());
		return "main.jsp";
	}
	else {
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}
	
}


@GetMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
}
}
