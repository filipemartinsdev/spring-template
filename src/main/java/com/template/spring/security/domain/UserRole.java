package com.template.spring.security.domain;

public enum UserRole {
    USER("user"),
    ADMIN("admin");

    private final String value;

    private UserRole(String value){
        this.value = value;
    }

    public String value() {
        return value;
    }
}
