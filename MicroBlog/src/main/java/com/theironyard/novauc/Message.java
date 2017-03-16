package com.theironyard.novauc;

import javax.persistence.*;

/**
 * Created by octavio on 3/15/17.
 */


@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String mensaje;

//    @Column (nullable = false)
//    String actualMessage;

//    @Column (nullable = false)
//    String genre;
//
//    @Column (nullable = false)
//    int releaseYear;

    public Message() {

    }

    public Message(String mensaje) {
//        this.id = id;
        this.mensaje = mensaje;
//        this.actualMessage = actualMessage;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
