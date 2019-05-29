package com.lambdaschool.niftymarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wishlistitem")
public class WishListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long wishitemid;

    @ManyToOne
    @JsonIgnore//this seems to be the root of your JSON recursion issue
    private Product product;

    public WishListItem() {
    }

    public WishListItem(Product product) {
        this.product = product;
    }

    public Long getWishitemid() {
        return wishitemid;
    }

    public void setWishitemid(Long wishitemid) {
        this.wishitemid = wishitemid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "WishListItem{" +
                "wishitemid=" + wishitemid +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishListItem)) return false;
        WishListItem that = (WishListItem) o;
        return Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct());
    }
}
