package com.lambdaschool.niftymarket.service;

import com.lambdaschool.niftymarket.model.Card;
import com.lambdaschool.niftymarket.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll(Pageable pageable);
    //    ArrayList<CountStudentsInCourses> getCountStudentsInCourse();

    void delete(long id);

    Product findProductById(long id);
//    //    Course findCourseByCourseName (String course);
//    Product save(Product card);

//    Card update(Card card, long id);

}
