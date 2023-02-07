package com.bug.tracking.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.tracking.exception.ProjectIdException;
import com.bug.tracking.modal.Project;
import com.bug.tracking.repository.ProjectRepository;
import com.bug.tracking.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project saveOrUpdate(Project project) {
		try{
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}catch(Exception ex) {
			throw new ProjectIdException("Project Id : "+project.getProjectIdentifier().toUpperCase()+"already exists");
		}
		
	}
	
	
	
//	@Override
//	public Project findProjectByIdentifier(Long projectId) {
//		Project project=projectRepository.findById(projectId);
//		if(project == null)
//			throw new ProjectIdException("Project Id " + projectId+" does not exist");
//		else
//			return (Project) project;
//	}
	
	@Override
	public Iterable<Project> findAllProject() {
		return projectRepository.findAll();
	}
	
	@Override
	public Project deleteProjectByProjectIdentifier(Long projectId) {
		Optional<Project> project=projectRepository.findById(projectId);
		if(project == null)
			throw new ProjectIdException("Project Id " + projectId+" does not exist");
		projectRepository.deleteById(projectId);
		return null;
		
	}



	@Override
	public Project findProjectByIdentifier(Long projectId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

