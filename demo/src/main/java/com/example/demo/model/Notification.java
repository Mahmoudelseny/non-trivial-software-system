package com.example.demo.model;
import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String recipient; // Email or phone number
    private String notificationType; // Order placement or shipment
    private LocalDateTime sentAt;

    public Notification(Long id, String content, String recipient, String notificationType, LocalDateTime sentAt) {
        this.id = id;
        this.content = content;
        this.recipient = recipient;
        this.notificationType = notificationType;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    // Constructors, Getters, and Setters (as previously shown)
}

