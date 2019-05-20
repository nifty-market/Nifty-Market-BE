package com.lambdaschool.niftymarket.model;

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

    private String imgUrl;

    private Double price;

//    private String seller;
//   private Double sellerRating;

    public Card() {
    }

    public Card(String cardname, String carddescription, String imgUrl, Double price) {
        this.cardname = cardname;
        this.carddescription = carddescription;
        this.imgUrl = imgUrl;
        this.price = price;
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
