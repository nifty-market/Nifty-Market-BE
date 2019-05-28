package com.lambdaschool.niftymarket.controller;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.User;
import com.lambdaschool.niftymarket.repos.CardRepository;
import com.lambdaschool.niftymarket.repos.UserRepository;
import com.lambdaschool.niftymarket.service.CardService;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/playingcards")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardRepository cardRepository;



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
    @ApiOperation(value = "Permits Authenticated user to post card. Don't worry about the user parameter or id parameter.", response = Card.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "string", paramType = "body",
                    value = "Name of card"),
            @ApiImplicitParam(name = "description", dataType = "string", paramType = "body",
                    value = "Description of item."),
            @ApiImplicitParam(name = "imgUrl", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Image url"),
            @ApiImplicitParam(name = "price", allowMultiple = true, dataType = "double", paramType = "body",
                    value = "Item price"),
            @ApiImplicitParam(name = "category", allowMultiple = true, dataType = "string", paramType = "body",
                    value = "Item major category Card or Videogame"),
            @ApiImplicitParam(name = "subcategory", allowMultiple = true, dataType = "string", paramType = "body",
                    value = "Item minor category, e.g. type of card")})

    @PostMapping(value = "/post/card")
    public ResponseEntity<?> postNewCard(@Valid @RequestBody Card newCard)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();


        User currentUser = userRepository.findByUsername(username);
        newCard.setUser(currentUser);
//        newCard.setUserposted(true);

        cardService.save(newCard);


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "Permits Authenticated user to delete card")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardid", dataType = "int", paramType = "query",
                    value = "Id of card"),})
    @DeleteMapping("/delete/card/{cardid}")
    public ResponseEntity<?> deleteByCardId(@PathVariable long cardid)
    {
        cardRepository.deleteById(cardid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Permits Authenticated user to update card",response = Card.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardid", dataType = "int", paramType = "query",
                    value = "Id of card"),
            @ApiImplicitParam(name = "updateCard", dataType = "object", paramType = "body",
                    value = "Any parameter from the Card object schema you wish to update")})
    @PutMapping(value = "/update/{cardid}")
    public ResponseEntity<?> updateCard(
            @RequestBody
                    Card updateCard,
            @PathVariable
                    long cardid)
    {
        cardService.update(updateCard, cardid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
