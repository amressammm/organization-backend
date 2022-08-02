package com.example.Organizationapp.dtos;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Organization {
    @Id
   private  int id;
   private String name;
   @OneToMany(
           mappedBy = "organization",
           cascade=CascadeType.ALL,
           orphanRemoval = true,
           fetch = FetchType.EAGER
   )
   private List <Team> teams= new ArrayList<>();
   @OneToOne(cascade=CascadeType.ALL)
   @JoinColumn(name ="details_id",referencedColumnName = "id")
   private OrganizationDetails details;



   public Organization(String name) {
      this.name = name;
   }
   public void addTeam(Team team){
      teams.add(team);
   }

   public Organization(int id, String name) {
      this.id = id;
      this.name = name;
   }
}


//
//   @ManyToOne
//   @JoinTable(
//           name = "working teams",
//           joinColumns= @JoinColumn (name="organization_id"),
//           inverseJoinColumns = @JoinColumn(name="team_id")
//   )
//   private List<Team> teams= new ArrayList<>();