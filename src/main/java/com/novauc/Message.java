package com.novauc;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinallen on 3/15/17.
 */
@Entity
@Table(name = "messages")// entire class represents table and data base
public class Message {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false) //represents a column
     String name;


    public Message() {
    }

    public Message (String name ) {// set constructors
        this. name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}







