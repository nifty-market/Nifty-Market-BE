package com.lambdaschool.niftymarket.repos;

import com.lambdaschool.niftymarket.model.Card;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardRepository extends PagingAndSortingRepository<Card, Long> {
    List<Card> findByCardnameContainingIgnoreCase(String name, Pageable pageable);

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO authbooks(authorid, bookid) values (:authorid, :bookid)", nativeQuery = true)
//    void insertIntoAuthBooks(long authorid, long bookid);
}
