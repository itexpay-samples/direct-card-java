package com.iisysgroup.demo.utility;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

    public static Map<String, Object> jsonToMap(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
