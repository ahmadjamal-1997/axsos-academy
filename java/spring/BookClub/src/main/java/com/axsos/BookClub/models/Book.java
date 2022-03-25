package com.axsos.BookClub.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotNull
	    @Size(min = 2, max = 50)
	    private String title;
	    @NotNull
	    @Size(min = 2, max = 20)
	    private String author;
	    @NotNull
	    @Size(min = 2, max = 300)
	    private String thoughts;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    
	    private User user;
	    
	    private Date createdAt;
	    private Date updatedAt;

		public Book() {
			
		}

//		public Book(@NotNull @Size(min = 2, max = 50) String title, @NotNull @Size(min = 2, max = 20) String author,
//				@NotNull @Size(min = 2, max = 300) String thoughts) {
//			super();
//			this.title = title;
//			this.author = author;
//			this.thoughts = thoughts;
//		}

		public Book(Long id, @NotNull @Size(min = 2, max = 50) String title,
				@NotNull @Size(min = 2, max = 20) String author, @NotNull @Size(min = 2, max = 300) String thoughts,
				User user) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.thoughts = thoughts;
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getThoughts() {
			return thoughts;
		}

		public void setThoughts(String thoughts) {
			this.thoughts = thoughts;
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
