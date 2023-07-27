package com.iisysgroup.demo.models.sub;

public class Card {
    private String number;
    private String cvv;
    private String expirymonth;
    private String expiryyear;

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

}
