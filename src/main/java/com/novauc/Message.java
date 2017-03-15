package com.novauc;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

        @Id
        @GeneratedValue
        int id;

        @Column(nullable = false)
        private String message;


        public Message() {
        }

        public Message(String message) {
            this.message = message;
        }
}
