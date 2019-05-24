package com.lambdaschool.niftymarket.repos;

import com.lambdaschool.niftymarket.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {

}
