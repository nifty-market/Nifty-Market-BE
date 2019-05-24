package com.lambdaschool.niftymarket.repos;

import com.lambdaschool.niftymarket.model.User;
import org.springframework.data.repository.CrudRepository;

public interface    UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
