package com.example.paymentservice.controllers;

import com.example.paymentservice.dtos.InitiatePaymentDto;
import com.example.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping
    public String initiatePayment(@RequestBody InitiatePaymentDto initiatePaymentDto){
        return paymentService.initiatePayment(
                initiatePaymentDto.getEmail(),
                initiatePaymentDto.getPhoneNumber(),
                initiatePaymentDto.getOrderId(),
                initiatePaymentDto.getAmount());
    }

    @PostMapping("/webhook")
    public String listenWebhook(@RequestBody String webhookEvent){
        System.out.println("Received webhook event: "+webhookEvent);
        return "OK";
    }
}
