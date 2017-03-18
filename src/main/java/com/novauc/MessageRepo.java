package com.novauc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by souporman on 3/16/17.
 */
public interface MessageRepo extends CrudRepository<Message,Integer>{

    List<Message> findByUser(User user);
}
