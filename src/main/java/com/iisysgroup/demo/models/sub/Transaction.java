package com.iisysgroup.demo.models.sub;

public class Transaction {
    private String merchantreference;
    private String callbackurl;
    private String authoption;
    private String paymentmethod;

    public String getMerchantreference() {
        return this.merchantreference;
    }

    public void setMerchantreference(String merchantreference) {
        this.merchantreference = merchantreference;
    }

    public String getCallbackurl() {
        return this.callbackurl;
    }

    public void setCallbackurl(String callbackurl) {
        this.callbackurl = callbackurl;
    }

    public String getAuthoption() {
        return this.authoption;
    }

    public void setAuthoption(String authoption) {
        this.authoption = authoption;
    }

    public String getPaymentmethod() {
        return this.paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

}
