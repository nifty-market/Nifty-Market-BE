package com.lambdaschool.niftymarket.repos;

import com.lambdaschool.niftymarket.model.GameItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameItemRepository extends PagingAndSortingRepository<GameItem,Long> {

}
