package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Auditable;
import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.WishList;
import com.lambdaschool.niftymarket.repos.CardRepository;
import com.lambdaschool.niftymarket.repos.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Override
    public List<WishList> findAll() {
        ArrayList<WishList> list = new ArrayList<>();
        wishListRepository.findAll().iterator().forEachRemaining(list::add);
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

    @Override
    public void insertIntoAuthBooks(long cartid, long itemid) {
//        Product addProduct = this.findAuthorById(authorid);
//        Book addToBook= bookRepository.findByBookid(bookid);
//        addToBook.getAuthors().add(addAuthor);
////        bookRepository.save(addToBook);
        wishListRepository.insertIntoAuthBooks(cartid, itemid);

    }

    @Override
    public List<WishList> update(WishList author, long id) {
        return null;
    }

}
