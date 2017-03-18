package com.novauc;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by souporman on 3/16/17.
 */
public interface UserRepo extends CrudRepository<User,Integer>{
    User findFirstByName(String userName);
}
