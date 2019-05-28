package com.codrite.jsonmanipulation;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class JsonManipulator {

    String add(String name, String value) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        ObjectNode on = om.createObjectNode();
        JsonNode jsonNode = TextNode.valueOf(value);
        on.set(name, jsonNode);
        return om.writeValueAsString(on);
    }

    String add(String[] name, String[] value) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        ObjectNode on = om.createObjectNode();
        int i = 0;
        for (String eachName : name) {
            JsonNode jsonNode = TextNode.valueOf(value[i++]);
            on.set(eachName, jsonNode);
        }
        return om.writeValueAsString(on);
    }

    String add(String name, String[] values) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        ArrayNode arrayNode = om.createArrayNode();
        arrayNode.addAll(Stream.of(values).map(TextNode::valueOf).collect(Collectors.toSet()));
        ObjectNode on = om.createObjectNode();
        on.set(name, arrayNode);
        return om.writeValueAsString(on);
    }

    public void create(String name, String value) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(new File("user.json"), JsonEncoding.UTF8);
        generator.writeStartObject();
        generator.writeStringField(name, value);
        generator.writeEndObject();
        generator.close();
    }

    public String remove(String json, String name) {
        return null;
    }

    public String find(String name) {
        return null;
    }

}
