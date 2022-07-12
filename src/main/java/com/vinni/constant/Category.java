package com.vinni.constant;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    None(""),
    FURNITURE("Furniture"),
    OFFICE_SUPPLIES("Office Supplies"),
    TECHNOLOGY("Technology");

    private String value;

    private Category(String value){
        this.value = value;
    }

    public static Category findByString(String s) {
        for (Category item : Category.values()) {
            if (item.getValue().equalsIgnoreCase(s)) return item;
        }
        return null;
    }
    @JsonValue
    public String getValue() {
        return this.value;
    }

}
