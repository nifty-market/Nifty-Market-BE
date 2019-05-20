package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Card;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CardService
{

    List<Card> findAll(Pageable pageable);
    //    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

//    Course findCourseByCourseName (String course);

    Card update(Card author, long id);

    Card findByBookid(long bookid);

}
