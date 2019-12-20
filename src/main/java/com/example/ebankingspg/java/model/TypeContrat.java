package com.example.ebankingspg.java.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeContrat extends AbstractAuditableEntity<User, Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typecontrat_seq")
    @SequenceGenerator(name = "typecontrat_seq", sequenceName = "typecontrat_seq", allocationSize = 1)
    private Long id;
    private String name;
    private double Rate; //taux

   //aniss darori prblm f serialisation
    /*
    @OneToMany(mappedBy = "typecontrat", cascade = CascadeType.ALL)
    private Set<Account> Account;
*/
    //aniss-fin
}

