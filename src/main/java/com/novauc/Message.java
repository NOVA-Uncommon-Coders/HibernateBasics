package com.novauc;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int time_hours;

    public Message(String author, int user_id, String text, String location, int time_hours) {
        this.author = author;
        this.user_id = user_id;
        this.text = text;
        this.location = location;
        this.time_hours = time_hours;
    }

    public Message(String author, String text, String location, int time_hours) {
        this.author = author;
        this.user_id = user_id;
        this.text = text;
        this.location = location;
        this.time_hours = time_hours;
    }

    public Message() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime_hours() {
        return time_hours;
    }

    public void setTime_hours(int time_hours) {
        this.time_hours = time_hours;
    }
}
