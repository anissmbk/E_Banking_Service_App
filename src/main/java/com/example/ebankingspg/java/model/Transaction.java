package com.example.ebankingspg.java.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transaction extends AbstractAuditableEntity<User, Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "transact_seq", sequenceName = "transact_seq", allocationSize = 1)
    private Long id;
    private double amount;
    private String motif;
    private Boolean active;

    //aniss
    private String recipientOutOfBank;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;


    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_target_id")
    private Account accountTarget;

    //aniss
    @Transient
    private String description;

}
