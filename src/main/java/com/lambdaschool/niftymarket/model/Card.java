package com.lambdaschool.niftymarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "playingcards")
public class Card extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties({"cards","hibernateLazyInitializer"})
    private User user;

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
//    @JsonIgnoreProperties({"carts","hibernateLazyInitializer"})
//    private Set<WishList> carts;

    private String imgUrl;


    private Double price;

    private String category;

    private String subcategory;
//
//    private boolean userposted;
//
//    private boolean userpurchased;
//    private String seller;
//   private Double sellerRating;

//    public Set<WishList> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(Set<WishList> carts) {
//        this.carts = carts;
//    }

//    public boolean isUserposted() {
//        return userposted;
//    }
//
//    public boolean isUserpurchased() {
//        return userpurchased;
//    }

    public Card() {
    }
    public Card(String category, String subcategory,String name, String description, String imgUrl, Double price) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;

        this.category = category;
        this.subcategory = subcategory;
    }


    public Card(String category, String subcategory,String name, String description, String imgUrl, Double price,User user) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.user = user;
        this.category = category;
        this.subcategory = subcategory;
//        this.userposted = userposted;
//        this.userpurchased = userpurchased;
    }

//    public boolean getUserposted() {
//        return userposted;
//    }
//
//    public void setUserposted(boolean userposted) {
//        this.userposted = userposted;
//    }

//    public boolean getUserpurchased() {
//        return userpurchased;
//    }
//
//    public void setUserpurchased(boolean userpurchased) {
//        this.userpurchased = userpurchased;
//    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
