package com.novauc;

import javax.persistence.*;

/**
 * Created by Eric on 3/15/17.
 */
@Entity  //telling us that this class represents a database table
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String text;


    public Message() {
    }

    //this below is a constructor
    public Message(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
//I copied all of these JPA annotation from the project we did this morning.  Why would we want to put all these JPA
//annotations in, and specifically these annotations... In other words, is this project supposed to be loosely
// configured or loosely defined? because the instructions are up to interpretation, but from a learners standpoint,
//that is making the things that are necessary within this class difficult to understand.


//I guess we are creating columns in our messages table... and we can name them whatever we want.