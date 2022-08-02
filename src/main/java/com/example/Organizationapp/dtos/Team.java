package com.example.Organizationapp.dtos;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name="organiation_id")
    private Organization organization;

    @Fetch(value = FetchMode.SUBSELECT)
    @ManyToMany(cascade=CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinTable(
           name = "working_projects",
           joinColumns= @JoinColumn (name="team_id"),
           inverseJoinColumns = @JoinColumn(name="project_id")
    )
   private List<Project> projects= new ArrayList<>();



    public Team(String name, Organization organization) {
        this.name = name;
        this.organization = organization;
    }

    public Team(int id, String name, Organization organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }

    public void assignProject(Project project){
        projects.add(project);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organization=" + organization +
                ", projects=" + projects +
                '}';
    }
}
