package com.axsos.BookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.BookClub.models.User;
import com.axsos.BookClub.models.Book;
import com.axsos.BookClub.models.LoginUser;
import com.axsos.BookClub.services.BookService;
import com.axsos.BookClub.services.UserService;



@SpringBootApplication
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@GetMapping("/")
	public String landingPage(Model model) {
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
		return "FormsPage.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result , Model model ,HttpSession session) {
		userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "FormsPage.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}
	@PostMapping("/login")
	public String LoginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result , Model model ,HttpSession session) {
		User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "FormsPage.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String home(Model model ,HttpSession session ) {
		Long user_id = (Long) session.getAttribute("user_id");
		User thisUser = userService.findUserById(user_id);
		model.addAttribute("thisUser", thisUser);
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "welcome.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	

}
