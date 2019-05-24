package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long id);



    void delete(long id);

    User save(User user);

    User update(User user, long id);
}