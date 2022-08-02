package com.example.Organizationapp.facade;

import com.example.Organizationapp.services.OrganizationDBservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationFacade {
    private final OrganizationDBservice organizationDBservice;

    public void createOrganization(String name) {
        organizationDBservice.CreateOrganization(name);
    }

    public void createTeam(String name, Integer organizationId) {

        organizationDBservice.createTeam(name,organizationId);
    }
    public void createProject(String name, Integer teamId) {
        organizationDBservice.createProject(name,teamId);
    }

    public void assignProject(Integer projectId, Integer teamId) {
        organizationDBservice.assignProject(projectId,teamId);
    }

    public void createOrgDetails(String discription, Integer orgId) {
        organizationDBservice.creeateOrgDetails(discription,orgId);
    }
}
