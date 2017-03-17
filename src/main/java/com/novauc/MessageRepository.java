package com.novauc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jerieshasmith on 3/15/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

    //@Query("UPDATE m FROM MESSAGE WHERE m.text LIKE ?1%")
    //List<Message> findByMessage(String text);

}
