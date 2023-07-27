package com.iisysgroup.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iisysgroup.demo.components.PayHandler;
import com.iisysgroup.demo.models.RequestPayment;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    @Autowired
    private PayHandler route;

    @PostMapping("/pay")
    public Map<String, Object> createUser(@Valid @RequestBody RequestPayment request) {
        return route.pay(request);
    }

}