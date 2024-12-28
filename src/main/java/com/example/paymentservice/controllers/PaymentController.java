package com.example.paymentservice.controllers;

import com.example.paymentservice.dtos.InitiatePaymentDto;
import com.example.paymentservice.services.PaymentService;
import com.example.paymentservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    private ProductService productService;

    public PaymentController(PaymentService paymentService, ProductService productService){
        this.paymentService=paymentService;
        this.productService=productService;
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

    @GetMapping("/product/{id}")
    public String getProductData(@PathVariable String id){
        return productService.getProductData(id);
    }
}
