package com.axsos.ProjectManager.Controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.ProjectManager.Services.ProjectService;
import com.axsos.ProjectManager.Services.UserService;
import com.axsos.ProjectManager.models.Project;
import com.axsos.ProjectManager.models.User;

@Controller
public class ProjectsController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@RequestMapping("/home")
	public String home(Model model,HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		List<Project> projects = projectService.findprojectsExcept(userId);
		List<Project> userProjects = projectService.findAllUserProjects(userId);
		model.addAttribute("userProjects", userProjects);
		model.addAttribute("projects", projects);
		model.addAttribute("thisUser", thisUser);
		return "home.jsp";
	}
	
	@RequestMapping("/jointeam/{id}")
	public String join(@PathVariable("id") Long projectId,HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		Optional<Project> possibleProject = projectService.findProject(projectId);
		if(!possibleProject.isPresent()) {
			return "redirect:/";
		}
		Project thisProject = possibleProject.get();
		thisProject.getManyusers().add(thisUser);
		projectService.createProject(thisProject);
		return "redirect:/home";
	}
	@RequestMapping("/leaveteam/{id}")
	public String leave(@PathVariable("id") Long projectId,HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		Optional<Project> possibleProject = projectService.findProject(projectId);
		if(!possibleProject.isPresent()) {
			return "redirect:/";
		}
		Project thisProject = possibleProject.get();
		projectService.leaveTeam(thisUser, thisProject);
		return "redirect:/home";
	}
	@GetMapping("/project/new")
	public String newProject(@ModelAttribute("projects") Project project,BindingResult result) {
		return "new.jsp";
	}
	@PostMapping("/project/create")
	public String create(@Valid@ModelAttribute("projects") Project project,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		Long userId = (Long)session.getAttribute("user_id");
		Optional<User> possibleUser = userService.findUser(userId);
		if(!possibleUser.isPresent()) {
			return "redirect:/";
		}
		User thisUser = possibleUser.get();
		project.setUser(thisUser);
		projectService.createProject(project);
		return "redirect:/home";
	}
	@RequestMapping("projects/{id}/edit")
	public String editForm(@PathVariable("id") Long projectId,@ModelAttribute("edited")Project edited,BindingResult newResult,Model model) {
		Optional<Project> possibleProject = projectService.findProject(projectId);
		if(!possibleProject.isPresent()) {
			return "redirect:/";
		}
		Project thisProject = possibleProject.get();
		model.addAttribute("thisProject", thisProject);
		return "edit.jsp";
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.PUT)
	public String edit(@PathVariable("id") Long projectId,@Valid@ModelAttribute("edited") Project edited,BindingResult newResult) {
		if(newResult.hasErrors()){
			return "edit.jsp";
		}
		projectService.updateProject(edited, projectId);
		return "redirect:/home";
	}
	@RequestMapping("projects/{id}")
	public String display(@PathVariable("id") Long projectId,Model model) {
		Optional<Project> possibleProject = projectService.findProject(projectId);
		if(!possibleProject.isPresent()) {
			return "redirect:/";
		}
		Project thisProject = possibleProject.get();
		model.addAttribute("thisProject", thisProject);
		return "details.jsp";
	}
	
}
