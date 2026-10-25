//abb jb conversation participant completed to let's make kaunsa user kis conversation ka memebr hai and uska role kiya h ???

package com.rishikesh.chat.entity;

import java.time.LocalDateTime;

import com.rishikesh.chat.enums.ParticipantRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversation_participants")

public class ConversationParticipant {
    @Id // says database that this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // THIS TELLS THE SYSTEM HOW TO CREATE IDs
    private Long id;

    // one user can talk in many conversations
    // @ManytoONe ek user can be a member of many conversations
    // @JoinColumn means DB mein user_id naam ka foreign-key column chaiye ,jo users
    // table ke user ko reference kare

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // membership record kis user ka hai

    // one conversation can have multiple participants
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation; // membership record kis conversation ka hai

    @Enumerated(EnumType.STRING) // enum is used for fixed options
    private ParticipantRole role; // role of the user in that conversation , member / admin ??
    private LocalDateTime joinedAt; // kab join hua wo user us conversation mein

    // <---------------Getters-------------->

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Conversation getConversation() {
        return conversation; // user is member of which conversation
    }

    public ParticipantRole getRole() {
        return role; // user is memebr or admin
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt; // user kab join hua conversation mein
    }

    // <-------------------Setters----------------->

    public void setUser(User user) {
        this.user = user; // membership associated with user
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation; // membership ko conversation se connect karna
    }

    public void setRole(ParticipantRole role) {
        this.role = role; // user ka role set karna
    }

    // koi user agr join krega to uska joining time automatcially kaise save larenge
    // DB Mein membership intialize krne se pehle timestamp initialize karenge
    // 1. JPA ka @PrePersist annotation use kro
    @PrePersist
    protected void onCreate() {
        if (joinedAt == null) {

            joinedAt = LocalDateTime.now(); // jab bhi koi user join hoga to uska joining time automatically save ho
                                            // jaega

        }
    }

}