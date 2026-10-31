
//we gonnna check rahul sent the message to rishi , is delivered  to / read by rishi 

package com.rishikesh.chat.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import com.rishikesh.chat.enums.DeliveryStatus;

@Entity
@Table(name = "message_receipts")

public class MessageReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; // Reciept ki unique ID

    @ManyToOne
    @JoinColumn(name = "message_id") // foreign key column message_id chaiye
    private Message message; // Reciept kis message k liye hai

    @ManyToOne
    @JoinColumn(name = "recipient_id")

    private User recipient; // Reciept kis user k liye hai

    @Enumerated(EnumType.STRING) // enum is used for fixed options
    private DeliveryStatus status; // Reciept ka status kya hai delivered / read
    private LocalDateTime readAt; // Reciept kab read hua
    private LocalDateTime deliveredAt; // Reciept kab deliver hua

    public Long getId() {
        return id;
    }

    public Message getMessage() {
        return message;
    }

    public User getRecipient() {
        return recipient;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public LocalDateTime getReadAt() {
        return readAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    // <-----------------------Setters----------------->

    public void setMessage(Message message) { // connecting receipt with message
        this.message = message;
    }

    public void setRecipient(User recipient) { // to send the msg to a user connecting it with receipt
        this.recipient = recipient;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public void setReadAt(LocalDateTime readAt) {
        this.readAt = readAt; // read timestamp
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;

    }

}
