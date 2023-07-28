package com.iisysgroup.demo.components;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.iisysgroup.demo.config.ConfigProperty;
import com.iisysgroup.demo.models.AuthRequest;
import com.iisysgroup.demo.models.EncryptedPayRequest;
import com.iisysgroup.demo.models.PayRequest;
import com.iisysgroup.demo.models.RequestPayment;
import com.iisysgroup.demo.models.sub.Card;
import com.iisysgroup.demo.models.sub.Customer;
import com.iisysgroup.demo.models.sub.Device;
import com.iisysgroup.demo.models.sub.Order;
import com.iisysgroup.demo.models.sub.Source;
import com.iisysgroup.demo.models.sub.Transaction;
import com.iisysgroup.demo.utility.Generic;

@Component
public class PayHandler {

    private final ConfigProperty config;

    @Autowired
    public PayHandler(ConfigProperty config) {
        this.config = config;
    }

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private SendHttp sendHttp;

    private Map<String, Object> authenticate() {

        AuthRequest auth = new AuthRequest();
        auth.setPrivatekey(config.getPrivatekey());
        auth.setPublickey(config.getPublickey());

        System.out.println(config.getBaseurl());

        String url = config.getBaseurl() + "/authenticate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return sendHttp.post(auth.toString(), url, headers);
    }

    public Map<String, Object> pay(RequestPayment request) {

        Map<String, Object> authRequest = authenticate();

        String code = authRequest.get("code").toString();
        if (!"00".equals(code)) {
            return authRequest;
        }

        String token = authRequest.get("access_token").toString();

        PayRequest pay = new PayRequest();

        pay.transaction = new Transaction();
        pay.getTransaction().setAuthoption("3DS");
        pay.getTransaction().setMerchantreference(Generic.generateRandomReference());
        pay.getTransaction().setPaymentmethod("card");
        pay.getTransaction().setCallbackurl("https://webhook.site/edcb6485-5ba0-4ab1-b9e1-950252bf3477");
        pay.getTransaction().setRedirecturl(request.getRedirecturl());
        pay.order = new Order();
        pay.getOder().setAmount(request.getAmount());
        pay.getOder().setCountry(request.getCountry());
        pay.getOder().setCurrency(request.getCurrency());
        pay.getOder().setDescription(request.getDescription());
        pay.source = new Source();
        pay.getSource().setCustomer(new Customer());
        pay.getSource().getCustomer().setEmail(request.getEmail());
        pay.getSource().getCustomer().setFirstname(request.getFirstname());
        pay.getSource().getCustomer().setLastname(request.getLastname());
        pay.getSource().getCustomer().setMsisdn(request.getMsisdn());
        pay.getSource().getCustomer().setCard(new Card());
        pay.getSource().getCustomer().getCard().setNumber(request.getNumber());
        pay.getSource().getCustomer().getCard().setCvv(request.getCvv());
        pay.getSource().getCustomer().getCard().setExpirymonth(request.getExpirymonth());
        pay.getSource().getCustomer().getCard().setExpiryyear(request.getExpiryyear());
        pay.getSource().setDevice(new Device());
        pay.getSource().getDevice().setFingerprint(request.getFingerprint());
        pay.getSource().getDevice().setIp(request.getIp());

        EncryptedPayRequest encrypted = encryptionService.encryptData(pay.toString(),
                config.getEncryptionkey());

        if (encrypted == null) {
            authRequest.put("message", "Data encryption failed");
            return authRequest;
        }

        String url = config.getBaseurl() + "/charge";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        return sendHttp.post(encrypted.toString(), url, headers);
    }
}
