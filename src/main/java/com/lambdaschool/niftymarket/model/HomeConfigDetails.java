package com.lambdaschool.niftymarket.model;

import java.util.List;

public class HomeConfigDetails {

    private String username;
    private List<Card> homecards;

    public HomeConfigDetails() {
    }

    public HomeConfigDetails(String username, List<Card> homecards) {
        this.username = username;
        this.homecards = homecards;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Card> getHomecards() {
        return homecards;
    }

    public void setHomecards(List<Card> homecards) {
        this.homecards = homecards;
    }
}
