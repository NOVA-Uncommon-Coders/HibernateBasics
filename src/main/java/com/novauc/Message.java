package com.novauc;

import javax.persistence.*;

/**
 * Created by jerieshasmith on 3/15/17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;


    @Column(nullable = false)
    String text;

public Message(Message one){

}

public Message(String text){
    this.text = text;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

