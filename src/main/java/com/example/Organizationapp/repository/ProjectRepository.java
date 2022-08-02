package com.example.Organizationapp.repository;

import com.example.Organizationapp.dtos.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Integer> {
}
