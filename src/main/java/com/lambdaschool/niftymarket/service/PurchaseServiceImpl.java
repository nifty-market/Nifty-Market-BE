//package com.lambdaschool.niftymarket.service;
//
//import com.lambdaschool.niftymarket.model.Card;
//import com.lambdaschool.niftymarket.model.Purchase;
//import com.lambdaschool.niftymarket.repos.PurchaseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PurchaseServiceImpl implements PurchaseService{
//
//    @Autowired
//    PurchaseRepository purchaseRepository;
//
//    @Override
//    public List<Purchase> findAll()
//    {
//        ArrayList<Purchase> list = new ArrayList<>();
//        purchaseRepository.findAll().iterator().forEachRemaining(list::add);
//        return list;
//    }
//
//
////    @Override
////    public Card findByBookid(long cardid) {
////
////        return cardRepository.findById(cardid).orElseThrow(() -> new EntityNotFoundException(Long.toString(cardid)));
////    }
//
//    @Override
//    public void delete(long id) {
//
//    }
//
//    @Override
//    public Purchase update(Purchase author, long id) {
//        return null;
//    }
//}
