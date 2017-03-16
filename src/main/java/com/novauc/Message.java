package com.novauc;

import javax.persistence.*;

/**
 * Created by ANVIL_OCTOPUS on 3/15/17.
 */
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(nullable = false)
    String text;




    public Message() {


    }

    public Message(String text) {
        this.text = text;

    }


}
