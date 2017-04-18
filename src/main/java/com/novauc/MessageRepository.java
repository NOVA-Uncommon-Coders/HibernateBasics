package com.novauc;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by vtcurry on 4/9/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}

