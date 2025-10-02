package com.melinagamarra.paymentrequests.service;

import com.melinagamarra.paymentrequests.PaymentrequestsApplication;
import com.melinagamarra.paymentrequests.dto.PaymentResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebClientService {

    private final WebClient webClient;


    public WebClientService(WebClient helipagosWebClient) {
        this.webClient = helipagosWebClient;
    }

    public Flux<PaymentResponse> getPayments(int page, int limit) {
        Map<String, Object> body = new HashMap<>();
        body.put("page", page);
        body.put("limit", Math.min(limit, 1000));
        return webClient.post()
                .uri("/api/solicitud_pago/v1/get_solicitud_pago")
                .bodyValue(body)
                .retrieve()
                .bodyToFlux(PaymentResponse.class);
    }

   public Mono<PaymentResponse> getPaymentById( Integer id) {
        return webClient.get()
                .uri("/api/solicitud_pago/v1/page/solicitud_pago/{id}",id)
                .retrieve()
                .bodyToMono(PaymentResponse.class);
    }

}
