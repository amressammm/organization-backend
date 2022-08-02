package com.example.Organizationapp;

import com.example.Organizationapp.dtos.Organization;
import com.example.Organizationapp.dtos.OrganizationDetails;
import com.example.Organizationapp.dtos.Project;
import com.example.Organizationapp.dtos.Team;
import com.example.Organizationapp.repository.OrganizationRepository;
import com.example.Organizationapp.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OrganizationAppApplicationTests {

	@Autowired
	OrganizationRepository organizationRepository;
	@Autowired
	TeamRepository teamRepository;




	@Test
	public void createOrganization(){
		Organization org= new Organization(1,"org1");
		organizationRepository.save(org);

		assertNotNull(organizationRepository.findById(1).get());
	}


	@Test
	public void createTeam(){

		Organization org= new Organization(1,"org1");
		Team team= new Team(1,"team1",org);
		org.addTeam(team);

		organizationRepository.save(org);


		assertEquals("team1",organizationRepository.findById(1).get().getTeams().get(0).getName());
	}


	@Test
	public void createOrgDesc(){
		Organization org= new Organization(1,"org1");
		org.setDetails(new OrganizationDetails("this is organization description"));
		organizationRepository.save(org);
		assertEquals("this is organization description",organizationRepository.findById(1).get().getDetails().getDiscription());
	}

	@Test
	public void deleteOrganization(){
		Organization org= new Organization(1,"org1");
		organizationRepository.save(org);
		organizationRepository.deleteById(1);
		assertEquals(Optional.empty(),organizationRepository.findById(1));
	}

	
}
