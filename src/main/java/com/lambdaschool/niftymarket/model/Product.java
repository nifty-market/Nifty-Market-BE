package com.lambdaschool.niftymarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;




}