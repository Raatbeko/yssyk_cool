package com.example.yssyk_cool.mapper;

public enum LocationTypeEnum {

    CITY(1L),
    AREA(2L);

    private final Long code;

    LocationTypeEnum(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
