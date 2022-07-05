package com.vinni.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Segment {
    CONSUMER("Consumer"),
    CORPORATE("Corporate"),
    HOME_OFFICE("Home Office");

    private String value;

    private Segment(String value) {
        this.value = value;
    }

    public static Segment findByString(String s) {
        for (Segment item : Segment.values()) {
            if (item.getValue().equalsIgnoreCase(s)) return item;
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

}

