package com.iisysgroup.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "itexpay")
public class ConfigProperty {
    private String privatekey;
    private String publickey;
    private String encryptionkey;
    private String baseurl;

    @Override
    public String toString() {
        return "{" +
                " privatekey='" + getPrivatekey() + "'" +
                ", publickey='" + getPublickey() + "'" +
                ", encryptionkey='" + getEncryptionkey() + "'" +
                ", baseurl='" + getBaseurl() + "'" +
                "}";
    }

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

    public String getEncryptionkey() {
        return this.encryptionkey;
    }

    public void setEncryptionkey(String encryptionkey) {
        this.encryptionkey = encryptionkey;
    }

    public String getBaseurl() {
        return this.baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }
}