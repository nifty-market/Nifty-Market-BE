package com.lambdaschool.niftymarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="wishlist")
public class WishList extends Auditable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties({"wishlist","hibernateLazyInitializer"})
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "CART_PRODUCT", joinColumns = @JoinColumn(name = "CART_ID") , inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID") )
    @JsonIgnoreProperties({"cart_product","hibernateLazyInitializer"})
    private Set<Product> products;

    public WishList() {
    }

    public WishList(Set<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}


