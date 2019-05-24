package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Transaction;

public interface TransactionService {
    Transaction save(Transaction transaction);

}
