package com.melinagamarra.paymentrequests.service;


import com.melinagamarra.paymentrequests.dto.PaymentCreateResponse;
import com.melinagamarra.paymentrequests.dto.PaymentPageResponse;
import com.melinagamarra.paymentrequests.dto.PaymentRequest;
import com.melinagamarra.paymentrequests.dto.PaymentResponse;
import com.melinagamarra.paymentrequests.mapper.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WebClientService {

    private final WebClient webClient;
    private final PaymentMapper paymentMapper;


    public WebClientService(WebClient helipagosWebClient, PaymentMapper paymentMapper) {
        this.webClient = helipagosWebClient;
        this.paymentMapper = paymentMapper;
    }

    public Flux<PaymentResponse> getPayments(int pageNumber, int pageSize) {

        return webClient.post()
                .uri("/api/solicitud_pago/v1/get_solicitud_pago")
                .retrieve()
                .bodyToFlux(PaymentResponse.class)
                .skip((long) pageNumber * pageSize)
                .take(pageSize);
    }

    public Mono<PaymentResponse> getPaymentById(Integer id) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/solicitud_pago/v1/page/solicitud_pago")
                        .queryParam("id", id)
                        .build())
                .retrieve()
                .bodyToMono(PaymentPageResponse.class)
                .map(paymentMapper::toPaymentResponse);

    }


    public Mono<PaymentCreateResponse> createPayment(PaymentRequest request) {
        return webClient.post()
                .uri("/api/solicitud_pago/v1/checkout/solicitud_pago")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(PaymentCreateResponse.class);
    }

}

