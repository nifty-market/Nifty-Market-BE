package com.lambdaschool.niftymarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "playingcards")
public class Card extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cardid;

    @Column(nullable = false)
    private String cardname;

    @Column(nullable = false)
    private String carddescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties({"cards","hibernateLazyInitializer"})
    private User user;

    private String imgUrl;

    private Double price;

//    private String seller;
//   private Double sellerRating;

    public Card() {
    }

    public Card(String cardname, String carddescription, String imgUrl, Double price,User user) {
        this.cardname = cardname;
        this.carddescription = carddescription;
        this.imgUrl = imgUrl;
        this.price = price;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getCardid() {
        return cardid;
    }

    public void setCardid(long cardid) {
        this.cardid = cardid;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCarddescription() {
        return carddescription;
    }

    public void setCarddescription(String carddescription) {
        this.carddescription = carddescription;
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
