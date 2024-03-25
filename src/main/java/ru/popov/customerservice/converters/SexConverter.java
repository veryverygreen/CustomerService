package ru.popov.customerservice.converters;

import jakarta.persistence.AttributeConverter;
import ru.popov.customerservice.support.Sex;

public class SexConverter implements AttributeConverter<Sex,String> {
    @Override
    public String convertToDatabaseColumn(Sex attribute) {
        return attribute.name().toLowerCase();
    }

    @Override
    public Sex convertToEntityAttribute(String dbData) {
        return Sex.valueOf(dbData.toUpperCase());
    }
}
