package com.vinni.constant.converter;

import com.vinni.constant.ShipMode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ShipModeConverter implements AttributeConverter<ShipMode, String> {

    @Override
    public String convertToDatabaseColumn(ShipMode shipMode) {
        if (shipMode == null) {
            return null;
        }
        return shipMode.getValue();
    }

    @Override
    public ShipMode convertToEntityAttribute(String s) {
        return ShipMode.findByString(s);
    }
}
