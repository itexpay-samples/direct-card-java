package com.iisysgroup.demo.models;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestPayment {
    private String amount;
    private String redirecturl;
    private String description;
    private String currency;
    private String country;
    private String firstname;
    private String lastname;
    private String email;
    private String msisdn;
    private String number;
    private String cvv;
    private String expirymonth;
    private String expiryyear;
    private String fingerprint;
    private String ip;

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRedirecturl() {
        return this.redirecturl;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirymonth() {
        return this.expirymonth;
    }

    public void setExpirymonth(String expirymonth) {
        this.expirymonth = expirymonth;
    }

    public String getExpiryyear() {
        return this.expiryyear;
    }

    public void setExpiryyear(String expiryyear) {
        this.expiryyear = expiryyear;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public static RequestPayment fromJsonString(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, RequestPayment.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
