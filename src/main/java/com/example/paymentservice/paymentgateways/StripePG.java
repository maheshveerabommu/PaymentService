package com.example.paymentservice.paymentgateways;

import com.stripe.param.PaymentLinkCreateParams;

public class StripePG implements PaymentGateway {
    @Override
    public String genaratePaymentLink(String email, String phoneNumber, String orderId, Long amount) {

//        PaymentLinkCreateParams params = PaymentLinkCreateParams.builder()
//                .addLineItem(
//                        PaymentLinkCreateParams.LineItem.builder()
//                                .setQuantity(1L)
//                                .setPrice(
//                                        PaymentLinkCreateParams.LineItem.builder()
//                                                .setCurrency("usd")
//                                                .setUnitAmount(amount)
//                                                .setProductData(
//                                                        PaymentLinkCreateParams.LineItem.PriceData.ProductData.builder()
//                                                                .setName("Payment for order " + orderId)
//                                                                .build()
//                                                )
//                                                .build()
//                                )
//                                .build()
//                )
        return "Stripe Payment Gateway";
    }
}
