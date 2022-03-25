package com.axsos.BookBrokers.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.BookBrokers.Repositories.BookRepo;
import com.axsos.BookBrokers.models.Book;
import com.axsos.BookBrokers.models.User;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;
	
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	public List<Book> findAllBooks(){
		return bookRepo.findAll();
	}
	public List<Book> findBooksExcept(Long id){
		return bookRepo.findBooksExceptThisUserBooks(id);
	}
	public Optional<Book> findBook(Long id) {
		return bookRepo.findById(id);
	}
	public void updateBook(Book book , Long id) {
    	Book editBook = bookRepo.findById(id).orElse(null);
    	assert editBook !=null;
    	editBook.setTitle(book.getTitle());
    	editBook.setAuthor(book.getAuthor());
    	editBook.setMythoughts(book.getMythoughts());
    	bookRepo.save(editBook);
    	
    }
	public void deleteBook(Long id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book!=null) {
            bookRepo.deleteById(id);
        }
    }
	public Book deleteBorrow(User thisUser , Book thisBook) {
		 thisUser.getManybooks().remove(thisBook);
		 return bookRepo.save(thisBook);
	}
	
}
