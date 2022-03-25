package com.axsos.BookBrokers.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.BookBrokers.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long> {
List<Book> findAll();
@Query(value="SELECT * FROM books WHERE id Not IN (SELECT book_id FROM borrow WHERE user_id=?1)",nativeQuery=true)
List<Book> findBooksExceptThisUserBooks(Long id);
Optional<Book> findById(Long id);
@Modifying
@Query(value="Delete From borrow where user_id=?1 and book_id=?2",nativeQuery=true)
int deleteFromBorrow(Long userid, Long bookid);
}
