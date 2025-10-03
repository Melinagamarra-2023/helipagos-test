package com.melinagamarra.paymentrequests.controller;

import com.melinagamarra.paymentrequests.dto.PaymentCreateResponse;
import com.melinagamarra.paymentrequests.dto.PaymentPageResponse;
import com.melinagamarra.paymentrequests.dto.PaymentRequest;
import com.melinagamarra.paymentrequests.dto.PaymentResponse;
import com.melinagamarra.paymentrequests.service.WebClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public Mono<PaymentPageResponse> getPaginatedPayments(
            @PathVariable Integer id,
            @RequestParam int pageNumber,
            @RequestParam int pageSize) {
        return webClientService.getPaymentById(pageNumber, pageSize, id);
    }

    @PostMapping("/create")
    public Mono<PaymentCreateResponse> createPayment(@Valid @RequestBody PaymentRequest request) {
        return webClientService.createPayment(request);
    }


}





