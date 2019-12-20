package com.example.ebankingspg.java.model.serializer;

import com.example.ebankingspg.java.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class AccountSerializer extends StdSerializer<User> {

    public AccountSerializer() {
        this(null);
    }

    public AccountSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(
            User value, JsonGenerator jsonGenerator, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", value.getId());
        jsonGenerator.writeStringField("username", value.getUsername());
        jsonGenerator.writeEndObject();
    }
}

