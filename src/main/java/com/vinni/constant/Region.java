package com.vinni.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Region {
    None(""),
    SOUTH("South"),
    WEST("West"),
    CENTRAL("Central"),
    EAST("East");

    private String value;

    private Region(String value) {
        this.value = value;
    }

    public static Region findByString(String s) {
        for (Region item : Region.values()) {
            if (item.getValue().equalsIgnoreCase(s)) return item;
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    }


