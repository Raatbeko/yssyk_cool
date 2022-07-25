package com.example.yssyk_cool.enums;

public enum SecurityRole {

    ROLE_PROVIDER("PROVIDER"),
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String name;

    SecurityRole(String name) {
        this.name = name;
    }


    public String getNameRole() {
        return name;
    }
}
