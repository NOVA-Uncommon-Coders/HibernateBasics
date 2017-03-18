package com.novauc;

import javax.persistence.*;

/**
 * Created by souporman on 3/16/17.
 */
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String message;

    @ManyToOne
    User user;

    public Message() {
    }

    public Message(String message, User user) {
        this.message = message;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}