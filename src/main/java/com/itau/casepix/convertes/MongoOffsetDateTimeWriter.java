package com.itau.casepix.convertes;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class MongoOffsetDateTimeWriter implements Converter<LocalDateTime, Document> {

    public static final String DATE_FIELD = "dateTime";
    public static final String OFFSET_FIELD = "offset";

    @Override
    public Document convert(final LocalDateTime localDateTime) {
        final Document document = new Document();
        document.put(DATE_FIELD, Date.from(localDateTime.toInstant(ZoneOffset.UTC)));
        document.put(OFFSET_FIELD, localDateTime.atOffset(ZoneOffset.UTC).toString());
        return document;
    }

}