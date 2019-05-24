//package com.lambdaschool.niftymarket.model;
//
//
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.hibernate.annotations.Type;
//import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "purchases")
//public class Purchase extends Auditable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userid", nullable = false)
//    @JsonIgnoreProperties({"purchases","hibernateLazyInitializer"})
//    private User user;
//
//
//    private Card item;
//
//
////    private String seller;
////   private Double sellerRating;
//
//    public Purchase() {
//    }
//
//    public Card getItem() {
//        return item;
//    }
//
//    public void setItem(Card item) {
//        this.item = item;
//    }
//
//    public Purchase(Card item, User user) {
//        this.item = item;
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//
//
//}
