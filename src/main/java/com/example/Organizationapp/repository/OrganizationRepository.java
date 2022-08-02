package com.example.Organizationapp.repository;

import com.example.Organizationapp.dtos.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization,Integer> {
}
