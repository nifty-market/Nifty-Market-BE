package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Transaction;
import com.lambdaschool.niftymarket.repos.CardRepository;
import com.lambdaschool.niftymarket.repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    @Override
    public Transaction save(Transaction transaction)
    {
        Transaction newtrans = new Transaction();
        newtrans.setName(transaction.getName());
        newtrans.setPrice(transaction.getPrice());
        newtrans.setDescription(transaction.getDescription());
        newtrans.setImgUrl(transaction.getImgUrl());
        newtrans.setUser(transaction.getUser());



        return transactionRepository.save(newtrans);
    }
}
