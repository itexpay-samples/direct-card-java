package com.iisysgroup.demo.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iisysgroup.demo.models.sub.Order;
import com.iisysgroup.demo.models.sub.Source;
import com.iisysgroup.demo.models.sub.Transaction;

public class PayRequest {
    public Transaction transaction;
    public Order order;
    public Source source;

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Order getOder() {
        return this.order;
    }

    public void setOder(Order oder) {
        this.order = oder;
    }

    public Source getSource() {
        return this.source;
    }

    public void setSource(Source source) {
        this.source = source;
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

    public static PayRequest fromJsonString(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, PayRequest.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
