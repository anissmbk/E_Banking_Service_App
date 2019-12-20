package com.example.ebankingspg.java.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
    @SequenceGenerator(name = "admin_seq", sequenceName = "admin_seq", allocationSize = 1)
    private Long id;


    @Builder
    public Admin(Long id, String password, String firstname, String lastname, String email, String numtel, boolean isValid, String adress, String status, String token, Set<Role> roles) {
        super(id, password, firstname, lastname, email, numtel, isValid, adress, status, token, roles);
    }

    public Admin( String firstname, String lastname, String email, String numtel, String adress,String password) {
        super(firstname, lastname, email, numtel,  adress,  password);
    }


}
