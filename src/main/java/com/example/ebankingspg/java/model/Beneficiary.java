package com.example.ebankingspg.java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiary extends AbstractAuditableEntity<User, Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String rib;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;


}
