package com.lambdaschool.niftymarket.controller;

import com.lambdaschool.niftymarket.model.*;
import com.lambdaschool.niftymarket.repos.CardRepository;
import com.lambdaschool.niftymarket.repos.UserRepository;
import com.lambdaschool.niftymarket.repos.WishListRepository;
import com.lambdaschool.niftymarket.service.CardService;
import com.lambdaschool.niftymarket.service.ProductService;
import com.lambdaschool.niftymarket.service.WishListService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductService productService;


//    @ApiOperation(value = "returns all Authors", response = Card.class, responseContainer = "List")
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
//    public ResponseEntity<?> listAllCards() {
//        List<WishList> myBooks = wishListService.findAll();
//        return new ResponseEntity<>(myBooks, HttpStatus.OK);
//    }
    @ApiOperation(value = "Currently not functioning. Would allow for authenticated user to add  wish list items.")
    @PostMapping(value = "/customer/wishlist/{itemid}")
    public ResponseEntity<?> addUserWish(@PathVariable long itemid)
    {
        //get current user object from username
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        User currentUser = userRepository.findByUsername(username);

        //Instantiate new wish-list-item based on desired product
        WishListItem wishItem = new WishListItem(productService.findProductById(itemid));
        System.out.println(wishItem);

        //OR Get current wishlist from user
        WishList currentWishlist = currentUser.getWishlist();
        if (currentWishlist == null){
            Set<WishListItem> a = new HashSet<>();
            a.add(wishItem);
            WishList emptyWishlist = new WishList(a,currentUser);
            wishListRepository.save(emptyWishlist);

        }
        else{
            WishList userlist = currentUser.getWishlist();
            userlist.getWishListItems().add(wishItem);
            wishListRepository.save(userlist);
        }



        //Instantiate new wish list object add product, add user identity, save







        return new ResponseEntity<>(HttpStatus.OK);
    }
}
