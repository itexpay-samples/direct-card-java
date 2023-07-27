package com.iisysgroup.demo.models;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthRequest {
    private String privatekey;
    private String publickey;

    public String getPrivatekey() {
        return this.privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    public String getPublickey() {
        return this.publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AuthRequest fromJsonString(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, AuthRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
