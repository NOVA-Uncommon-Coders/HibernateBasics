package com.novauc;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
        @ManyToOne
        User user;

        @Id
        @GeneratedValue
        int id;

        @Column(nullable = false)
        private String message;


        public Message() {
        }

        public Message(String message,  User user) {
            this.message = message;
            this.user = user;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}
