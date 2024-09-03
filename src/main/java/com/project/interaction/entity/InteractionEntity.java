package com.project.interaction.entity;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "int_history")
public class InteractionEntity {
    
    @Id
    private String interactionId;
   
    @Column(name = "customer_id")
    private Long customerId;
    
    private String interactionType;
    private String channel;
    private LocalDateTime interactionDate;
    private String details;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public String getInteractionId() {
        return interactionId;
    }
    public void setInteractionId(String interactionId) {
        this.interactionId = interactionId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getInteractionType() {
        return interactionType;
    }
    public void setInteractionType(String interactionType) {
        this.interactionType = interactionType;
    }
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public LocalDateTime getInteractionDate() {
        return interactionDate;
    }
    public void setInteractionDate(LocalDateTime interactionDate) {
        this.interactionDate = interactionDate;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public InteractionEntity() {
    }
    public InteractionEntity(String interactionId, Long customerId, String interactionType, String channel,
            LocalDateTime interactionDate, String details, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.interactionId = interactionId;
        this.customerId = customerId;
        this.interactionType = interactionType;
        this.channel = channel;
        this.interactionDate = interactionDate;
        this.details = details;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    @Override
    public String toString() {
        return "InteractionEntity [interactionId=" + interactionId + ", customerId=" + customerId + ", interactionType="
                + interactionType + ", channel=" + channel + ", interactionDate=" + interactionDate + ", details="
                + details + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }
}