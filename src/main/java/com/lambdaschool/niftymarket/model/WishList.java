package com.lambdaschool.niftymarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="wishlist")
public class WishList extends Auditable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "userid")
//    @JsonIgnoreProperties({"wishlist","hibernateLazyInitializer"})
//    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"wishlist","hibernateLazyInitializer"})
    private Set<WishListItem> wishListItems;

    @OneToOne
    @JsonIgnore
    private User user;

    public WishList() {
    }

    public WishList(Set<WishListItem> wishListItems, User user) {
        this.wishListItems = wishListItems;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public Set<WishListItem> getWishListItems() {
        return wishListItems;
    }

    public void setWishListItems(Set<WishListItem> wishListItems) {
        this.wishListItems = wishListItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishList)) return false;
        WishList wishList = (WishList) o;
        return Objects.equals(getWishListItems(), wishList.getWishListItems()) &&
                Objects.equals(getUser(), wishList.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWishListItems(), getUser());
    }
}


