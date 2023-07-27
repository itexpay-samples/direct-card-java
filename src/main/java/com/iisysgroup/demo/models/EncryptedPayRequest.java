package com.iisysgroup.demo.models;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EncryptedPayRequest {
    private String ctx;
    private String data;

    public String getCtx() {
        return this.ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
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

}
