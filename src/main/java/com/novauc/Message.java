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
    String platform;

    @Column(nullable = false)
    String genre;

    @Column(nullable = false)
    int releaseYear;

    public Message() {
    }

    public Message(String name, String platform, String genre, int releaseYear) {
        this.name = name;
        this.platform = platform;
        this.genre = genre;
        this.releaseYear = releaseYear;
        }
    }