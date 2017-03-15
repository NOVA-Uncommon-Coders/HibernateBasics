package com.novauc;

import javax.persistence.*;

@Entity
@Table(name = "microblog")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String author;

    @Column(nullable = false)
    int user_id;

    @Column(nullable = false)
    String text;

    @Column(nullable = false)
    String location;

    @Column(nullable = false)
    double time_hours;

    public Message(String author, int user_id, String text, String location, double time_seconds) {
        this.author = author;
        this.user_id = user_id;
        this.text = text;
        this.location = location;
        this.time_hours = time_hours;
    }

    public Message() {}
}
