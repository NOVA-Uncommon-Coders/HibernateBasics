package com.novauc;

import javax.persistence.*;

@Entity
@Table(name = "credenza")
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
    int time_hours;

    public Message(String author, int user_id, String text, String location, int time_hours) {
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
