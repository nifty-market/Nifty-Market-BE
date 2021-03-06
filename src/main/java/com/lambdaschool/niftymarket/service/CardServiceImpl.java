package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.exception.ResourceNotFoundException;
import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Role;
import com.lambdaschool.niftymarket.repos.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "cardService")
public class CardServiceImpl implements CardService{

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> findAll(Pageable pageable)
    {
        ArrayList<Card> list = new ArrayList<>();
        cardRepository.findAll().iterator().forEachRemaining(list::add);
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
    public Card save(Card card)
    {
        Card newcard = new Card();
        newcard.setCategory(card.getCategory());
        newcard.setName(card.getName());
        newcard.setImgUrl(card.getImgUrl());
        newcard.setDescription(card.getDescription());
        newcard.setPrice(card.getPrice());
        newcard.setSubcategory(card.getSubcategory());
        newcard.setUser(card.getUser());


        return cardRepository.save(newcard);
    }

    @Override
    public Card findCardById(long id)
    {
        return cardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }


    @Override
    public Card update(Card card, long id)
    {
        Card currentCard = cardRepository.findById(id)
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

        return cardRepository.save(currentCard);
    }
}
