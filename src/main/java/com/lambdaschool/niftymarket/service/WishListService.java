package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Auditable;
import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Product;
import com.lambdaschool.niftymarket.model.WishList;
import com.lambdaschool.niftymarket.repos.WishListRepository;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface WishListService {


    List<WishList> findAll();
    //    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

//    Course findCourseByCourseName (String course);
    void insertIntoAuthBooks(long cartid, long itemid);

    List<WishList> update(WishList author, long id);




//    Card findByBookid(long bookid);
}
