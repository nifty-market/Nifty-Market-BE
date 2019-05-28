package com.lambdaschool.niftymarket.model;

import javax.persistence.*;

@Entity
public class WishListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wishitemid;

    @ManyToOne
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
}
