package com.lambdaschool.niftymarket.controller;



import com.lambdaschool.niftymarket.model.GameItem;
import com.lambdaschool.niftymarket.model.User;

import com.lambdaschool.niftymarket.repos.GameItemRepository;
import com.lambdaschool.niftymarket.repos.UserRepository;

import com.lambdaschool.niftymarket.service.GameItemService;
import com.lambdaschool.niftymarket.service.UserService;
import io.swagger.annotations.*;

//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/gameitems")
public class GameItemController {



    @Autowired
    UserRepository userRepository;



    @Autowired
    GameItemRepository gameItemRepository;
    @Autowired
    GameItemService gameItemService;



    //    @ApiOperation(value = "returns all Cards", response = Card.class, responseContainer = "List")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
//                    value = "Results page you want to retrieve (0..N)"),
//            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
//                    value = "Number of records per page."),
//            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
//                    value = "Sorting criteria in the format: property(,asc|desc). " +
//                            "Default sort order is ascending. " +
//                            "Multiple sort criteria are supported.")})
//    @GetMapping(value = "/all", produces = {"application/json"})
//    public ResponseEntity<?> listAllCards(@PageableDefault(page = 0,
//            size = 2) Pageable pageable)
//    {
//        List<Card> myBooks = cardService.findAll(pageable);
//        return new ResponseEntity<>(myBooks, HttpStatus.OK);
//    }
    @ApiOperation(value = "Permits Authenticated user to post gameitem. Don't worry about the user parameter or id parameter.", response = GameItem.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "string", paramType = "body",
                    value = "Name of gameitem"),
            @ApiImplicitParam(name = "description", dataType = "string", paramType = "body",
                    value = "Description of item."),
            @ApiImplicitParam(name = "imgUrl", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Image url"),
            @ApiImplicitParam(name = "price", allowMultiple = true, dataType = "double", paramType = "body",
                    value = "Item price"),
            @ApiImplicitParam(name = "category", allowMultiple = true, dataType = "string", paramType = "body",
                    value = "Item major category gameitem or Videogame"),
            @ApiImplicitParam(name = "subcategory", allowMultiple = true, dataType = "string", paramType = "body",
                    value = "Item minor category, e.g. type of gameitem")})

    @PostMapping(value = "/post/gameitem")
    public ResponseEntity<?> postNewGameItem(@Valid @RequestBody GameItem newGame)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();


        User currentUser = userRepository.findByUsername(username);
        newGame.setUser(currentUser);
//        newGame.setUserposted(true);

        gameItemRepository.save(newGame);


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "Permits Authenticated user to delete gameitem")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameitemid", dataType = "int", paramType = "query",
                    value = "Id of gameitem"),})
    @DeleteMapping("/delete/gameitem/{gameitemid}")
    public ResponseEntity<?> deleteByGameItemId(@PathVariable long gameid)
    {
        gameItemRepository.deleteById(gameid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Permits Authenticated user to update gameitem",response = GameItem.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameitemid", dataType = "int", paramType = "query",
                    value = "Id of gameitem"),
            @ApiImplicitParam(name = "updateGameItem", dataType = "object", paramType = "body",
                    value = "Any parameter from the GameItem object schema you wish to update")})
    @PutMapping(value = "/update/{gameitemid}")
    public ResponseEntity<?> updateGameItem(
            @RequestBody
                    GameItem updateGameItem,
            @PathVariable
                    long gameitemid)
    {
        gameItemService.update(updateGameItem, gameitemid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

