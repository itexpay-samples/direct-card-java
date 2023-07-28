package com.iisysgroup.demo.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.iisysgroup.demo.utility.Converter;

@Component
public class SendHttp {

    public Map<String, Object> post(String requestBody, String url, HttpHeaders headers) {

        Map<String, Object> responseBody = new HashMap<>();
        try {
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response;
            response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    String.class);

            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());

            responseBody = Converter.jsonToMap(response.getBody());
            responseBody.put("statuscode", response.getStatusCode().toString());

        } catch (HttpClientErrorException ex) {

            String response = ex.getResponseBodyAsString();

            responseBody = Converter.jsonToMap(response);
            responseBody.put("statuscode", ex.getStatusCode().toString());

        } catch (Exception ex) {
            // Handle other types of exceptions, e.g., network errors
            ex.printStackTrace();
        }

        return responseBody;

    }

    public Map<String, Object> get(String url, HttpHeaders headers) {

        Map<String, Object> responseBody = new HashMap<>();
        try {
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    String.class);

            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());

            responseBody = Converter.jsonToMap(response.getBody());
            responseBody.put("statuscode", response.getStatusCode().toString());

        } catch (

        HttpClientErrorException ex) {

            String response = ex.getResponseBodyAsString();

            responseBody = Converter.jsonToMap(response);
            responseBody.put("statuscode", ex.getStatusCode().toString());

        } catch (Exception ex) {
            // Handle other types of exceptions, e.g., network errors
            ex.printStackTrace();
        }
        return responseBody;
    }
}
