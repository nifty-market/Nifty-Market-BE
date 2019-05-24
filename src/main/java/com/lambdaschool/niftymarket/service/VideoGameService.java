package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.controller.VideoGameController;
import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.VideoGame;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VideoGameService {

    List<VideoGame> findAll(Pageable pageable);
    //    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

//    Course findCourseByCourseName (String course);

    Card update(Card author, long id);

    VideoGame findByVidid(long bookid);

}
