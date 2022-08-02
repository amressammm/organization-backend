package com.example.Organizationapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String discription;
    @OneToOne(mappedBy = "details")
    private Organization organization;

    public OrganizationDetails(String discription) {
        this.discription = discription;
    }
}
