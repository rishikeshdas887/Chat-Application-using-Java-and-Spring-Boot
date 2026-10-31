package com.rishikesh.chat.entity;

import java.time.LocalDateTime;

import com.rishikesh.chat.enums.MessageType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; //a user can send many messages in many conversations
import jakarta.persistence.ManyToOne; //foreign key column sender_id chaiye
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table; //foreign key column conversation_id chaiye
//message database table mein store hone wali entity hai 

@Entity
@Table(name = "messages") // table ka naam messages rakhnna h

public class Message {

    @Id // says database that this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // THIS TELLS THE SYSTEM HOW TO CREATE IDs

    private Long id; // kisne bheja message ka unique id
    private String content; // ky bheja
    @ManyToOne
    @JoinColumn(name = "sender_id") // foreign key column sender_id chaiye
    private User sender; // kisne bheja

    @ManyToOne
    @JoinColumn(name = "conversation_id") // foreign key column conversation_id chaiye
    private Conversation conversation; // kis conversation mein bheja
    private LocalDateTime createdAt; // kab bheja
    @Enumerated(EnumType.STRING) // enum is used for fixed options
    private MessageType type; // message ka type kya hai txt /img/etc..

    @PrePersist // ye method tab call hoga jab message database mein save hoga
    protected void createdAt() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    //// <--------------------Getters------------------------>

    public Long getId() { // every class need DB generated id this method return that id
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getSender() { // when message is sen tby which user
        return sender;
    }

    public Conversation getConversation() { // when messages sent in which conversation
        return conversation;
    }

    public LocalDateTime getCreatedAt() { // when messages was sent
        return createdAt;
    }

    public MessageType getType() { // what type of message is sent
        return type;
    }

    // <<---------------------Setters---------------------->

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(User sender) { // when message is sent by which user
        this.sender = sender;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

}
