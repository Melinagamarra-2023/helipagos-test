package com.melinagamarra.paymentrequests.controller;

import com.melinagamarra.paymentrequests.dto.PaymentResponse;
import com.melinagamarra.paymentrequests.service.WebClientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("payments")
public class WebClientController {

    private final WebClientService webClientService;


    public WebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @PostMapping
    public Flux<PaymentResponse> getPayments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return webClientService.getPayments(page, limit);
    }

   @GetMapping("/{id}")
    public Mono<PaymentResponse> getPayment(
            @PathVariable Integer id) {
        return webClientService.getPaymentById( id);
    }


}



