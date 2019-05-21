package com.lambdaschool.niftymarket.controller;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.HomeConfigDetails;
import com.lambdaschool.niftymarket.model.User;
import com.lambdaschool.niftymarket.service.CardService;
import com.lambdaschool.niftymarket.service.RoleService;
import com.lambdaschool.niftymarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController
{

    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    CardService cardService;

//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @CrossOrigin
    @GetMapping(value = "/login", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers()
    {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        List<Card> homeCards = cardService.findAll(Pageable.unpaged());

        HomeConfigDetails myHomeDetails = new HomeConfigDetails(username,homeCards);


        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myHomeDetails, HttpStatus.OK);
    }}