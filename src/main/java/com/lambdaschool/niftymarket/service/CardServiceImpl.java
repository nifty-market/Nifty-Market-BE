package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.repos.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Card findByBookid(long cardid) {

        return cardRepository.findById(cardid).orElseThrow(() -> new EntityNotFoundException(Long.toString(cardid)));
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Card update(Card author, long id) {
        return null;
    }
}
