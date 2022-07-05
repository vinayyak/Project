package com.vinni.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ShipMode {
    FIRST_CLASS("First Class"),
    SECOND_CLASS("Second Class"),
    STANDARD_CLASS("Standard Class");
    private String value;

    private ShipMode(String value) {
        this.value = value;
    }

    public static ShipMode findByString(String s) {
        for (ShipMode item : ShipMode.values()) {
            if (item.getValue().equalsIgnoreCase(s)) return item;
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }
}
