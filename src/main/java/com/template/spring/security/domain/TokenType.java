package com.template.spring.security.domain;

public enum TokenType {
    ACCESS("access"), REFRESH("refresh");

    private final String VALUE;

    TokenType(String value){
        this.VALUE = value;
    }

    public String getValue(){
        return this.VALUE;
    }
}
