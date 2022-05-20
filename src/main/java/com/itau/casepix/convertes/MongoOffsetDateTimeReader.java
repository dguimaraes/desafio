package com.itau.casepix.convertes;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class MongoOffsetDateTimeReader implements Converter<Document, LocalDateTime> {

    @Override
    public LocalDateTime convert(final org.bson.Document document) {
        final Date dateTime = document.getDate(MongoOffsetDateTimeWriter.DATE_FIELD);
        final ZoneOffset offset = ZoneOffset.of(document.getString(MongoOffsetDateTimeWriter.OFFSET_FIELD));
        return LocalDateTime.ofInstant(dateTime.toInstant(), offset);
    }

}