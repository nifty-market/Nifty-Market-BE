package com.lambdaschool.niftymarket.model;


import java.util.List;

public class DashboardConfigDetails {


    private List<Card> cards;
    private List<VideoGame> videogames;
    private Object securitydetails;

    public DashboardConfigDetails() {
    }

    public DashboardConfigDetails(List<Card> cards, List<VideoGame> videogames, Object securitydetails) {
        this.cards = cards;
        this.videogames = videogames;
        this.securitydetails = securitydetails;
    }
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }


    public Object getSecuritydetails() {
        return securitydetails;
    }

    public void setSecuritydetails(Object securitydetails) {
        this.securitydetails = securitydetails;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<VideoGame> getVideogames() {
        return videogames;
    }

    public void setVideogames(List<VideoGame> videogames) {
        this.videogames = videogames;
    }

//    public List<Card> getHomecards() {
//        return homecards;
//    }
//
//    public void setHomecards(List<Card> homecards) {
//        this.homecards = homecards;
//    }
}
