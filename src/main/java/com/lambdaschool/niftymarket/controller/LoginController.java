package com.lambdaschool.niftymarket.controller;

import com.lambdaschool.niftymarket.model.*;
import com.lambdaschool.niftymarket.repos.UserRepository;
import com.lambdaschool.niftymarket.service.*;
import io.swagger.annotations.ApiOperation;
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
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    CardService cardService;

    @Autowired
    VideoGameService videoGameService;

    @Autowired
    GameItemService gameItemService;

//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @ApiOperation(value = "Returns all market place items. No auth required.")
    @CrossOrigin
    @GetMapping(value = "/market", produces = {"application/json"})
    public ResponseEntity<?> listAllMarketItems()
    {

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = ((UserDetails)principal).getUsername();

        List<Card> homeCards = cardService.findAll(Pageable.unpaged());
        List<VideoGame> videoGames = videoGameService.findAll(Pageable.unpaged());
        List<GameItem> gameItems = gameItemService.findAll(Pageable.unpaged());

        HomeConfigDetails myHomeDetails = new HomeConfigDetails(videoGames,homeCards,gameItems);


        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myHomeDetails, HttpStatus.OK);
    }
    @ApiOperation(value = "/registration located in UserController.  /login Returns all userdetails (transactions,posts,wishlist) for an Authenticated user.")
    @CrossOrigin
    @GetMapping(value = "/login", produces = {"application/json"})
    public ResponseEntity<?> listDashboardItems()
    {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();

//        List<Card> homeCards = cardService.find(Pageable.unpaged());
//        List<VideoGame> videoGames = videoGameService.findAll(Pageable.unpaged());
        User currentUser = userRepository.findByUsername(username);

//        DashboardConfigDetails dashboardConfigDetails = new DashboardConfigDetails(homeCards,videoGames,principal);


        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

}