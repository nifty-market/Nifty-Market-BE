package com.lambdaschool.niftymarket.service;


import com.lambdaschool.niftymarket.exception.ResourceNotFoundException;
import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.GameItem;
import com.lambdaschool.niftymarket.model.Role;
import com.lambdaschool.niftymarket.repos.CardRepository;
import com.lambdaschool.niftymarket.repos.GameItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "gameItemService")
public class GameItemServiceImpl implements GameItemService{

    @Autowired
    private GameItemRepository gameItemRepository;

    @Override
    public List<GameItem> findAll(Pageable pageable)
    {
        ArrayList<GameItem> list = new ArrayList<>();
        gameItemRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

//    @Override
//    public Card findByBookid(long cardid) {
//
//        return cardRepository.findById(cardid).orElseThrow(() -> new EntityNotFoundException(Long.toString(cardid)));
//    }

    @Override
    public void delete(long id) {

    }

    @Transactional
    @Override
    public GameItem save(GameItem card)
    {
        GameItem newcard = new GameItem();
        newcard.setCategory(card.getCategory());
        newcard.setName(card.getName());
        newcard.setImgUrl(card.getImgUrl());
        newcard.setDescription(card.getDescription());
        newcard.setPrice(card.getPrice());
        newcard.setSubcategory(card.getSubcategory());
        newcard.setUser(card.getUser());


        return gameItemRepository.save(newcard);
    }

    @Override
    public GameItem findGameById(long id)
    {
        return gameItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }


    @Override
    public GameItem update(GameItem card, long id)
    {
        GameItem currentCard = gameItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (card.getCategory() != null)
        {
            currentCard.setCategory(card.getCategory());
        }

        if (card.getSubcategory() != null)
        {
            currentCard.setSubcategory(card.getSubcategory());
        }

        if (card.getPrice() != null)
        {
            currentCard.setPrice(card.getPrice());
        }

        if (card.getDescription() != null)
        {
            currentCard.setDescription(card.getDescription());
        }

        if (card.getName() != null)
        {
            currentCard.setName(card.getName());
        }

        if (card.getDescription() != null)
        {
            currentCard.setDescription(card.getDescription());
        }

        if (card.getImgUrl() != null)
        {
            currentCard.setImgUrl(card.getImgUrl());
        }

        return gameItemRepository.save(currentCard);
    }
}

