package com.axsos.BookBrokers.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="books")
public class Book {
	
		
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
		    @Size(min=3,max=200,message="title should atleast contain 3 charachters")
		    private String title;
		    @Size(min=3,max=200,message="author should atleast contain 3 charachters")
		    private String author;
		    @Size(min=3,max=200,message="mythoughts should atleast contain 3 charachters")
		    private String mythoughts;
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
		    @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name="user")
		    private User user;
		    @ManyToMany(fetch = FetchType.LAZY)
		    @JoinTable(
		        name = "borrow", 
		        joinColumns = @JoinColumn(name = "book_id"), 
		        inverseJoinColumns = @JoinColumn(name = "user_id")
		    )
		    private List<User> manyusers;
			public Book() {
				
			}
			public Book(@Size(min = 3, max = 200, message = "title should atleast contain 3 charachters") String title,
					@Size(min = 3, max = 200, message = "author should atleast contain 3 charachters") String author,
					@Size(min = 3, max = 200, message = "mythoughts should atleast contain 3 charachters") String mythoughts,
					User user) {
				super();
				this.title = title;
				this.author = author;
				this.mythoughts = mythoughts;
				this.user = user;
			}
			public Long getId() {
				return id;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getAuthor() {
				return author;
			}
			public void setAuthor(String author) {
				this.author = author;
			}
			public String getMythoughts() {
				return mythoughts;
			}
			public void setMythoughts(String mythoughts) {
				this.mythoughts = mythoughts;
			}
			public User getUser() {
				return user;
			}
			public void setUser(User user) {
				this.user = user;
			}
			
			@PrePersist
		    protected void onCreate(){
		        this.createdAt = new Date();
		    }
		    @PreUpdate
		    protected void onUpdate(){
		        this.updatedAt = new Date();
		    }
	    
		    
}
