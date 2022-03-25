package com.axsos.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.axsos.BookClub.models.Book;
import com.axsos.BookClub.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
//    edit a book details
    public void updateBook(Book book , Long id) {
    	Book editBook = bookRepository.findById(id).orElse(null);
    	assert editBook !=null;
    	editBook.setTitle(book.getTitle());
    	editBook.setAuthor(book.getAuthor());
    	editBook.setThoughts(book.getThoughts());
    	bookRepository.save(editBook);
    	
    }
//    delete a book
    public void deleteBook(Long id) {
    	Book book = findBook(id);
    	if (book!=null) {
    		bookRepository.deleteById(id);
    	}
    }
	

}
