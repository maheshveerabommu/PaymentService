package com.example.paymentservice.services;

import com.example.paymentservice.paymentgateways.RazorpayPG;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private RazorpayPG razorpayPG;
    public PaymentService(RazorpayPG razorpayPG){
        this.razorpayPG=razorpayPG;
    }
    public String initiatePayment(String email, String phoneNumber, String orderId, Long amount) {
        /*
        1. call order service
        2. get order details
        3. verify amount
        3. call payment gateway and get payment link
        4. return paymentlink
         */
        return razorpayPG.genaratePaymentLink(email,phoneNumber,orderId,amount);
    }
}
