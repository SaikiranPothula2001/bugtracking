package com.bug.tracking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bug.tracking.modal.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	Project findByProjectIdentifier(String projectIdentifier);
	default List<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
