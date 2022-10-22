package dev.hendratommy.training.inventory.framework.adapter.output.sql.data;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

import java.util.Optional;

@Converter(autoApply = true)
public class UUIDTypeConverter implements AttributeConverter<UUID, String> {
    @Override
    public String convertToDatabaseColumn(final UUID entityValue) {
        return Optional.ofNullable(entityValue)
                .map(entityUuid -> entityUuid.toString())
                .orElse(null);
    }

    @Override
    public UUID convertToEntityAttribute(final String databaseValue) {
        return Optional.ofNullable(databaseValue)
                .map(databaseUuid -> UUID.fromString(databaseUuid))
                .orElse(null);
    }
}
