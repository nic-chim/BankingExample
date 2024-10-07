package com.example.api.model;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private Boolean isActive;
    private LocalDateTime createdAt;

    public BaseEntity() {
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }
}