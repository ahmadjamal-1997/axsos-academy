package com.axsos.BookBrokers.Controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.BookBrokers.Services.BookService;
import com.axsos.BookBrokers.Services.UserService;
import com.axsos.BookBrokers.models.Book;
import com.axsos.BookBrokers.models.User;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/home")
	public String home(Model model,HttpSession session,@ModelAttribute("book") Book book) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		List<Book> notBorrowed = bookService.findBooksExcept(userId);
		model.addAttribute("thisUser", thisUser);
		model.addAttribute("notBorrowed", notBorrowed);
		return "home.jsp";
	}
	
	@RequestMapping("borrow/{id}")
	public String borrow(@PathVariable("id") Long bookid,HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		Optional<Book> possibleBook = bookService.findBook(bookid);
		if(!possibleBook.isPresent()) {
			return "redirect:/home";
		}
		Book thisBook = possibleBook.get();
		thisUser.getManybooks().add(thisBook);
		userService.create(thisUser);
		return "redirect:/home";
	}
	@RequestMapping("/books/{id}/edit")
	public String editBook(Model model ,@ModelAttribute("book") Book book , @PathVariable("id") Long id) {
		Optional<Book> possibleBook = bookService.findBook(id);
		if(!possibleBook.isPresent()) {
			return "redirect:/home";
		}
		Book thisBook = possibleBook.get();
		model.addAttribute("thisBook", thisBook);
		return "edit.jsp";
	}
	@RequestMapping(value ="/edit/{id}" , method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Book book , BindingResult result) {
      
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        else {
           
            bookService.updateBook(book, id);
            return "redirect:/home";
        }
    }
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") Long id ) {
        bookService.deleteBook(id);
        return "redirect:/home";
    }
	
	@RequestMapping("/return/{id}")
	public String unborrow(@PathVariable("id") Long bookid,HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		Optional<Book> possibleBook = bookService.findBook(bookid);
		if(!possibleBook.isPresent()) {
			return "redirect:/home";
		}
		Book thisBook = possibleBook.get();
		bookService.deleteBorrow(thisUser, thisBook);
		return "redirect:/home";
	}

	
	
}
