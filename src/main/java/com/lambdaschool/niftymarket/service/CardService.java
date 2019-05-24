package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Role;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CardService
{

    List<Card> findAll(Pageable pageable);
    //    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

    Card findCardById(long id);
//    Course findCourseByCourseName (String course);
    Card save(Card card);

    Card update(Card card, long id);

//    Card findByBookid(long bookid);

}
