package com.lambdaschool.niftymarket.controller;



import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.VideoGame;
import com.lambdaschool.niftymarket.service.VideoGameService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videogames")
public class VideoGameController {

   @Autowired
   VideoGameService videoGameService;

    @ApiOperation(value = "Currently not operational", response = Card.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> listAllVideogames(@PageableDefault(page = 0,
            size = 2) Pageable pageable)
    {
        List<VideoGame> myBooks = videoGameService.findAll(pageable);
        return new ResponseEntity<>(myBooks, HttpStatus.OK);
    }


}

