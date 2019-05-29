package com.lambdaschool.niftymarket.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "videogames")
public class VideoGame extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties({"videogames","hibernateLazyInitializer"})
    private User user;

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
//    @JsonIgnoreProperties({"carts","hibernateLazyInitializer"})
//    private Set<WishList> carts;

    private String imgUrl;

    private Double price;

    private String category;
    private String subcategory;

//    private String seller;
//   private Double sellerRating;

    public VideoGame() {
    }

//    public Set<WishList> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(Set<WishList> carts) {
//        this.carts = carts;
//    }

    public VideoGame(String category, String subcategory, String name, String description, String imgUrl, Double price, User user) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.user = user;
        this.category = category;
        this.subcategory= subcategory;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

