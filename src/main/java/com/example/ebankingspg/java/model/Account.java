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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractAuditableEntity<User,Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1)
    private Long id;
    private String rib;
    private double balance;
    private String typeaccount;
    private String blockedbalance;
    private Boolean accountvalidated;
    private Date activation_date;
    private Date desactivation_date;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transaction;


    //aniss remove @JsonManagedReference and replace it with @JsonIgnore
    @JsonManagedReference
    @OneToOne(mappedBy="accountTarget",fetch = FetchType.LAZY,
              cascade =  CascadeType.ALL)
    private Transaction transactionTarget;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonBackReference
    private Client client;

    //aniss daroooooori
    @ManyToOne
    @JoinColumn(name = "typecontratId")
    private TypeContrat typecontrat;
    //aniss-fin
}
