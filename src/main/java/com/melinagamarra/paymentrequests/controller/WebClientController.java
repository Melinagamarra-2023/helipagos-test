package com.melinagamarra.paymentrequests.controller;

import com.melinagamarra.paymentrequests.dto.PaymentCreateResponse;
import com.melinagamarra.paymentrequests.dto.PaymentRequest;
import com.melinagamarra.paymentrequests.dto.PaymentResponse;
import com.melinagamarra.paymentrequests.service.WebClientService;
import jakarta.validation.Valid;
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

    @GetMapping
    public Flux<PaymentResponse> getPayments(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return webClientService.getPayments(pageNumber, pageSize);

    }

    @GetMapping("/{id}")
    public Mono<PaymentResponse> getPaginatedPayments(
            @PathVariable Integer id) {
        return webClientService.getPaymentById(id);
    }

    @PostMapping("/create")
    public Mono<PaymentCreateResponse> createPayment(@Valid @RequestBody PaymentRequest request) {
        return webClientService.createPayment(request);
    }


}





