package com.novauc;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevinallen on 3/15/17.
 */
public interface HibernateRepository extends CrudRepository<Message, Integer> {
}

