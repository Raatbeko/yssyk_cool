package com.example.yssyk_cool.util;

public enum SecurityRole {

    ROLE_PROVIDER("PROVIDER"),
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    private final String name;

    SecurityRole(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
