package dev.hendratommy.training.inventory.framework.adapter.output.sql.data;

import io.quarkus.logging.Log;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

import java.util.Optional;

@Converter
public class UUIDTypeConverter implements AttributeConverter<UUID, String> {
    @Override
    public String convertToDatabaseColumn(final UUID entityValue) {
        Log.info("KICKS convertToDatabaseColumn");
        return Optional.ofNullable(entityValue)
                .map(entityUuid -> entityUuid.toString())
                .orElse(null);
    }

    @Override
    public UUID convertToEntityAttribute(final String databaseValue) {
        Log.info("KICKS convertToEntityAttribute");
        return Optional.ofNullable(databaseValue)
                .map(databaseUuid -> UUID.fromString(databaseUuid))
                .orElse(null);
    }
}
