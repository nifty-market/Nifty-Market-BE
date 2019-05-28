package com.lambdaschool.niftymarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)//removing this causes an error in database schema where I cannot list a user by json
//seems that the tables of sub classes do not get created in db
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;




}