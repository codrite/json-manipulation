package com.codrite.jsonmanipulation;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class JsonManipulatorTest {

    @Test
    public void assert_that_when_attribute_is_added_to_json_string_is_changed() throws IOException {
        JsonManipulator jsonManipulator = new JsonManipulator();
        log.info(jsonManipulator.add("name", "arnab"));
        log.info(jsonManipulator.add(new String[]{"primary", "secondary"}, new String[]{"arnab", "saurabh"}));
        log.info(jsonManipulator.add("primary", new String[]{"arnab", "saurabh"}));
    }


}