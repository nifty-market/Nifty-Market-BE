package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.GameItem;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameItemService {

    List<GameItem> findAll(Pageable pageable);
    //    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

    GameItem findGameById(long id);
    //    Course findCourseByCourseName (String course);
    GameItem save(GameItem card);

    GameItem update(GameItem card, long id);
}
