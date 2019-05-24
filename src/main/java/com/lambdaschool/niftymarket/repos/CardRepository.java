package com.lambdaschool.niftymarket.repos;

import com.lambdaschool.niftymarket.model.Card;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
    List<Card> findBynameContainingIgnoreCase(String name, Pageable pageable);



//    @Transactional
//    @Modifying
//    @Query(value = "DELETE from Cards where id = :id", nativeQuery = true)
//    void deleteCardId(long id);

}

