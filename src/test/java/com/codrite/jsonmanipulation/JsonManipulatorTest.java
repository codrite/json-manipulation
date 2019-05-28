package com.codrite.jsonmanipulation;

import org.junit.Test;

import java.io.IOException;

public class JsonManipulatorTest {

    @Test
    public void assert_that_when_attribute_is_added_to_json_string_is_changed() throws IOException {
        JsonManipulator jsonManipulator = new JsonManipulator();
        System.out.println(jsonManipulator.add("name", "arnab"));
        System.out.println(jsonManipulator.add(new String[]{"primary", "secondary"}, new String[]{"arnab", "saurabh"}));
        System.out.println(jsonManipulator.add("primary", new String[]{"arnab", "saurabh"}));
    }


}