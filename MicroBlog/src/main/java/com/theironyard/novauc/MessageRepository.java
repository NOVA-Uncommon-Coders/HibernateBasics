package com.theironyard.novauc;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by octavio on 3/15/17.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
