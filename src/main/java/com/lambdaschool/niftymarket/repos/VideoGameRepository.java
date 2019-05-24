package com.lambdaschool.niftymarket.repos;

import com.lambdaschool.niftymarket.controller.VideoGameController;
import com.lambdaschool.niftymarket.model.VideoGame;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VideoGameRepository extends PagingAndSortingRepository<VideoGame, Long> {


}
