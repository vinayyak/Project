package com.vinni.constant.converter;

import com.vinni.constant.Segment;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SegmentConverter implements AttributeConverter<Segment, String> {

    @Override
    public String convertToDatabaseColumn(Segment segment) {
        if (segment == null) {
            return null;
        }
        return segment.getValue();
    }

    @Override
    public Segment convertToEntityAttribute(String s) {
        return Segment.findByString(s);
    }
}
