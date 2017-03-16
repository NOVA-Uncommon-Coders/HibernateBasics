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

        @Column(nullable = false)
        private int userId;


        public Message() {
        }

        public Message(String message, int userId, User user) {
            this.message = message;
            this.userId = userId;
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

        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }
}
