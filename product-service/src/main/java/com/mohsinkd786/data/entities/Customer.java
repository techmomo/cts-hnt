package com.mohsinkd786.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "id") // primary key for credentials
    private Credentials credentials;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Address> addresses;
}
