package com.axsos.ProjectManager.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.axsos.ProjectManager.models.Project;
import com.axsos.ProjectManager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository <Project , Long> {
	List<Project> findAll();
	@Query(value="SELECT * FROM projects WHERE id NOT IN (SELECT id FROM projects LEFT JOIN users_projects ON projects.id = users_projects.project_id Where user =?1 or user_id=?1)",nativeQuery=true)
	List<Project> findByProjectsNotContaining(Long id);
	@Query(value="SELECT * FROM projects LEFT JOIN users_projects ON projects.id = users_projects.project_id Where user =?1 or user_id=?1",nativeQuery=true)
	List<Project> findUserProjectsAndUserTeams(Long id);
}
