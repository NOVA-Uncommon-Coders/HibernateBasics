package com.novauc;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {


    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    private String userName;


    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
