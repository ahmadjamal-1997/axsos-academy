package com.axsos.BookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.BookClub.models.Book;
import com.axsos.BookClub.models.User;
import com.axsos.BookClub.services.BookService;
import com.axsos.BookClub.services.UserService;

@Controller
public class BookController {
	private final BookService bookService; 
	@Autowired
	private  UserService userService;
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	@RequestMapping("/books/new")
	public String formBook(@ModelAttribute("book") Book book ) {
		return "addBooks.jsp";
	}
	@PostMapping("/createBook")
	public String createBook(Model model ,@Valid @ModelAttribute("book") Book book , BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "addBooks.jsp";
		}
		
		Long user_id =(Long) session.getAttribute("user_id");
		User user1 = userService.findUserById(user_id);
		 book.setUser(user1);
		 bookService.createBook(book);
		
		
		return "redirect:/home";
		
		
	}
	@GetMapping("/books/{id}")
	public String bookDetails(Model model , @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "bookDetails.jsp";
	}
	@RequestMapping("/books/{id}/edit")
	public String editBook(Model model ,@ModelAttribute("book") Book book , @PathVariable("id") Long id) {
		Book books = bookService.findBook(id);
		model.addAttribute("books", books);
		return "editBook.jsp";
	}
	
	@RequestMapping(value ="/edit/{id}" , method = RequestMethod.PUT)
	public String updateBook(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Book book , BindingResult result) {
		System.out.println(id);
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			System.out.println(id);
			bookService.updateBook(book, id);
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("id") Long id , @ModelAttribute("book") Book book) {
		bookService.deleteBook(id);
		return "redirect:/home";
	}
	

}
