package com.novauc;
import javax.persistence.*;
/**
 * Created by Merlin on 3/15/17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;
    @Column(nullable = false)
            String name;

    public Message(){
    }
    public Message (String name)
    {this. name = name;}

    public void setName(String name)
    {this.name = name;}
}
