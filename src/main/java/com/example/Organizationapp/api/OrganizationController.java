package com.example.Organizationapp.api;

import com.example.Organizationapp.dtos.Organization;
import com.example.Organizationapp.facade.OrganizationFacade;
import com.example.Organizationapp.repository.OrganiationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/organizations")


public class OrganizationController {
    @Autowired
    private OrganiationRepository organiationRepository;

    private final OrganizationFacade organizationFacade;

    @PostMapping(path="/createOrganization")
    public void createOrganization(@RequestParam String name){
        organizationFacade.createOrganization(name);


    }
    @PostMapping(path="/createTeam")
    public void createTeam(@RequestParam String name,Integer orgId){

        organizationFacade.createTeam(name,orgId);
    }
    @PostMapping(path = "/createPrject")
    public void createProject(@RequestParam String name,Integer teamId){
        organizationFacade.createProject(name, teamId);

    }
    @PostMapping(path="/assignPtoject")
    public void assignProject(@RequestParam Integer projectId,Integer teamId){
        organizationFacade.assignProject(projectId,teamId);
    }
    @PostMapping(path="/createOrgDetails")
    public void createOrgDetails(@RequestParam String discription,Integer orgId){
        organizationFacade.createOrgDetails(discription,orgId);
    }

}
