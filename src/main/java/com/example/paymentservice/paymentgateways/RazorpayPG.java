package com.example.paymentservice.paymentgateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RazorpayPG implements PaymentGateway{
    private RazorpayClient razorpayClient;

    public RazorpayPG(RazorpayClient razorpayClient){
        this.razorpayClient=razorpayClient; // Initialize the RazorpayClient
    }

    @Override
    public String genaratePaymentLink(String email, String phoneNumber, String orderId, Long amount)  {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("expire_by",1734784490);
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for policy no "+orderId);
        JSONObject customer = new JSONObject();
        customer.put("name","+919966266261");
        customer.put("contact","Mahesh V");
        customer.put("email","maheshveerabommu12@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",false);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Payment for your Amazon Order");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com");
        paymentLinkRequest.put("callback_method","get");
        PaymentLink paymentlink = null;
        try {
            paymentlink = razorpayClient.paymentLink.create(paymentLinkRequest);
        }
        catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
        return paymentlink.get("short_url").toString();
    }

}
