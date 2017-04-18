package com.novauc;

import javax.persistence.*;

/**
 * Created by vtcurry on 4/8/17.
 */

@Entity
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String messageStyle;

    @Column(nullable = false)
    String messageType;

    @Column(nullable = false)
    int messageYear;

    public Message() {
    }

    public Message(String name, String messageStyle, String messageType, int messageYear) {
        this.name = name;
        this.messageStyle = messageStyle;
        this.messageType = messageType;
        this.messageYear = messageYear;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageStyle() {
        return messageStyle;
    }

    public void setMessageStyle(String messageStyle) {
        this.messageStyle = messageStyle;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public int getMessageYear() {
        return messageYear;
    }

    public void setMessageYear(int messageYear) {
        this.messageYear = messageYear;
    }
}