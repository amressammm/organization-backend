package com.example.Organizationapp.services;

import com.example.Organizationapp.dtos.Organization;
import com.example.Organizationapp.dtos.OrganizationDetails;
import com.example.Organizationapp.dtos.Project;
import com.example.Organizationapp.dtos.Team;
import com.example.Organizationapp.repository.OrganiationRepository;
import com.example.Organizationapp.repository.ProjectRepository;
import com.example.Organizationapp.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class OrganizationDBservice {
    @Autowired
    private OrganiationRepository organiationRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired

    private ProjectRepository projectRepository;

    public void CreateOrganization(String name) {
        organiationRepository.save(new Organization(name));

    }

    public void createTeam(String name, Integer organizationId) {

        Organization org= organiationRepository.findById(organizationId).get();
        Team team= new Team(name,org);
        org.addTeam(team);
        organiationRepository.save(org);
    }

    public void createProject(String name, Integer teamId) {
        Team team= teamRepository.findById(teamId).get();
        Project project = new Project(name);
        team.assignProject(project);
        teamRepository.save(team);
    }

    public void assignProject(Integer projectId, Integer teamId) {
        Project project= projectRepository.findById(projectId).get();
        Team team =teamRepository.findById(teamId).get();
        team.assignProject(project);
        teamRepository.save(team);


    }

    public void creeateOrgDetails(String discription, Integer orgId) {
        Organization org= organiationRepository.findById(orgId).get();
        org.setDetails(new OrganizationDetails(discription));
        organiationRepository.save(org);

    }
}
