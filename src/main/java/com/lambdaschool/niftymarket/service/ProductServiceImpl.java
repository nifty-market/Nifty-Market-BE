package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.exception.ResourceNotFoundException;
import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Product;
import com.lambdaschool.niftymarket.model.Role;
import com.lambdaschool.niftymarket.repos.CardRepository;
import com.lambdaschool.niftymarket.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll(Pageable pageable)
    {
        ArrayList<Product> list = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(list::add);
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

//    @Transactional
//    @Override
//    public Product save(Product product)
//    {
//        Card newcard = new Card();
//        newcard.setCategory(card.getCategory());
//        newcard.setName(card.getName());
//        newcard.setImgUrl(card.getImgUrl());
//        newcard.setDescription(card.getDescription());
//        newcard.setPrice(card.getPrice());
//        newcard.setSubcategory(card.getSubcategory());
//        newcard.setUser(card.getUser());
//
//
//        return cardRepository.save(newcard);
//    }

    @Override
    public Product findProductById(long id)
    {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }


//    @Override
//    public Card update(Card card, long id)
//    {
//        Card currentCard = cardRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
//
//        if (card.getCategory() != null)
//        {
//            currentCard.setCategory(card.getCategory());
//        }
//
//        if (card.getSubcategory() != null)
//        {
//            currentCard.setSubcategory(card.getSubcategory());
//        }
//
//        if (card.getPrice() != null)
//        {
//            currentCard.setPrice(card.getPrice());
//        }
//
//        if (card.getDescription() != null)
//        {
//            currentCard.setDescription(card.getDescription());
//        }
//
//        if (card.getName() != null)
//        {
//            currentCard.setName(card.getName());
//        }
//
//        if (card.getDescription() != null)
//        {
//            currentCard.setDescription(card.getDescription());
//        }
//
//        if (card.getImgUrl() != null)
//        {
//            currentCard.setImgUrl(card.getImgUrl());
//        }
//
//        return cardRepository.save(currentCard);
//    }
}

