package com.payment.aps.paymentapiservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RequestMapping("/pay")
@Controller
public class PaymentController {

    @GetMapping("/choose_plan")
	public String getPlans() {
		return "choose_plan";
	}

    @PostMapping("/proceed")
    public String getResponse() {
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        int randomNum = (int) ((Math.random() * (100 - 1)) + 1);
        System.out.println(randomNum);
        if (randomNum % 2 == 0){
            return "sucess";
        } else {
            return "error";
        }
    }
}