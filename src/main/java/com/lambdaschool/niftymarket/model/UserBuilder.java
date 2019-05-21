package com.lambdaschool.niftymarket.model;

import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    public String username;
    public String password;
    public List<UserRoles> userRoles = new ArrayList<>();

    public User buildUser()
    {
        return new User( username,password,userRoles);
    }

    public UserBuilder username(String username)
    {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password)
    {
        this.password = password;
        return this;
    }

    public UserBuilder userRoles(List<UserRoles> userRoles)
    {
        this.userRoles = userRoles;
        return this;
    }
}
