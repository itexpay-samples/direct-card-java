package com.iisysgroup.demo.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.iisysgroup.demo.utility.Converter;

@Component
public class SendHttp {

    public Map<String, Object> post(String requestBody, String url, HttpHeaders headers) {

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());

        Map<String, Object> responseBody = new HashMap<>();
        responseBody = Converter.jsonToMap(response.getBody());
        responseBody.put("statuscode", response.getStatusCode().toString());

        return responseBody;

    }

    public Map<String, Object> get(String url, HttpHeaders headers) {
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                String.class);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());

        Map<String, Object> responseBody = new HashMap<>();
        responseBody = Converter.jsonToMap(response.getBody());
        responseBody.put("statuscode", response.getStatusCode().toString());

        return responseBody;
    }
}
