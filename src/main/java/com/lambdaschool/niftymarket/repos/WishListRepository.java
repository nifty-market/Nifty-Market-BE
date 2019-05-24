package com.lambdaschool.niftymarket.repos;

import com.lambdaschool.niftymarket.model.Auditable;
import com.lambdaschool.niftymarket.model.WishList;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface WishListRepository extends CrudRepository<WishList,Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO cart_product(cart_id, product_id) values (:cart_id, :product_id)", nativeQuery = true)
    void insertIntoAuthBooks(long cart_id, long product_id);
}
