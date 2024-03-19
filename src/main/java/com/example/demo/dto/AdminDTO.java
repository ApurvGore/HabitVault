package com.example.demo.dto;

public class AdminDTO {

    private String name;
    private String email;
    // Add other fields as needed

    // Constructors, getters, and setters
    public AdminDTO() {
    }

    public AdminDTO(String name, String email) {
        this.name = name;
        this.email = email;
        // Initialize other fields
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Add getters and setters for other fields
}
