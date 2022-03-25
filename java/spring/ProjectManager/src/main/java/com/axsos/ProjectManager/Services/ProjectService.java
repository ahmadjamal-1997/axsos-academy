package com.axsos.ProjectManager.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.ProjectManager.Repositories.ProjectRepo;
import com.axsos.ProjectManager.Repositories.UserRepository;
import com.axsos.ProjectManager.models.Project;
import com.axsos.ProjectManager.models.User;

@Service
public class ProjectService {
	

	
	
		@Autowired
		private ProjectRepo projectRepo;
		@Autowired
		private UserRepository userRepo;
		
		public Project createProject(Project b) {
			return projectRepo.save(b);
		}
	
		public List<Project> findprojectsExcept(Long id){
			
			return projectRepo.findByProjectsNotContaining(id);
		}
		public Optional<Project> findProject(Long id) {
			return projectRepo.findById(id);
		}
		
		public List<Project> findAllUserProjects(Long id){
			return projectRepo.findUserProjectsAndUserTeams(id);
		}
		public void updateProject(Project project , Long id) {
	    	Project editProject = projectRepo.findById(id).orElse(null);
	    	assert editProject !=null;
	    	editProject.setTitle(project.getTitle());
	    	editProject.setDescription(project.getDescription());
	    	editProject.setDueDate(project.getDueDate());
	    	projectRepo.save(editProject);
	    	
	    }
		public void deleteProject(Long id) {
	        Optional<Project> project = projectRepo.findById(id);
	        if (project!=null) {
	            projectRepo.deleteById(id);
	        }
	    }
		public Project leaveTeam(User thisUser , Project thisProject) {
			 thisUser.getManyprojects().remove(thisProject);
			 return projectRepo.save(thisProject);
		}
		
	
		
	}


