package com.axsos.ProjectManager.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="projects")
public class Project {
	
		
			
			    @Id
			    @GeneratedValue(strategy = GenerationType.IDENTITY)
			    private Long id;
			    @Size(min=3,max=200,message="title should atleast contain 3 charachters")
			    private String title;
			    @Size(min=3,max=200,message="description should atleast contain 3 charachters")
			    private String description;
			    @NotNull
			    @DateTimeFormat(pattern="yyyy-MM-dd")
			    private Date dueDate;
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
			        name = "users_projects", 
			        joinColumns = @JoinColumn(name = "project_id"), 
			        inverseJoinColumns = @JoinColumn(name = "user_id")
			    )
			    private List<User> manyusers;
				public Project() {
				
				}
				public Project(
						@Size(min = 3, max = 200, message = "title should atleast contain 3 charachters") String title,
						@Size(min = 3, max = 200, message = "description should atleast contain 3 charachters") String description,
						@NotNull Date dueDate, User user) {
					super();
					this.title = title;
					this.description = description;
					this.dueDate = dueDate;
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
				public String getDescription() {
					return description;
				}
				public void setDescription(String description) {
					this.description = description;
				}
				public Date getDueDate() {
					return dueDate;
				}
				public void setDueDate(Date dueDate) {
					this.dueDate = dueDate;
				}
				public User getUser() {
					return user;
				}
				public void setUser(User user) {
					this.user = user;
				}
				public List<User> getManyusers() {
					return manyusers;
				}
				public void setManyusers(List<User> manyusers) {
					this.manyusers = manyusers;
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
