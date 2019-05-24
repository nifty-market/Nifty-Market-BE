package com.lambdaschool.niftymarket.controller;


import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Transaction;
import com.lambdaschool.niftymarket.model.User;
import com.lambdaschool.niftymarket.repos.TransactionRepository;
import com.lambdaschool.niftymarket.repos.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @ApiOperation(value = "Allows authenticated user to post a purchase to database. Don't worry about the user parameter or id parameter below")
    @ApiImplicitParam(name = "transaction object", dataType = "Transaction", paramType = "body",
            value = "transaction object")
    @PostMapping(value = "/new")
    public ResponseEntity<?> addNewTransaction(@Valid @RequestBody Transaction transaction) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();


        User currentUser = userRepository.findByUsername(username);
        transaction.setUser(currentUser);


        transactionRepository.save(transaction);

        return new ResponseEntity<>(HttpStatus.OK);


    }
}