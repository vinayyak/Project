package com.vinni.constant.converter;

import com.vinni.constant.Region;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RegionConverter implements AttributeConverter<Region, String> {

    @Override
    public String convertToDatabaseColumn(Region region) {
        if (region == null) {
            return null;
        }
        return region.getValue();
    }

    @Override
    public Region convertToEntityAttribute(String s) {
        return Region.findByString(s);
    }
}
