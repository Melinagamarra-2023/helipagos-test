package com.melinagamarra.paymentrequests.service;


import com.melinagamarra.paymentrequests.dto.PaymentCreateResponse;
import com.melinagamarra.paymentrequests.dto.PaymentPageResponse;
import com.melinagamarra.paymentrequests.dto.PaymentRequest;
import com.melinagamarra.paymentrequests.dto.PaymentResponse;
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

    public Mono<PaymentPageResponse> getPaymentById(int pageNumber, int pageSize, Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/solicitud_pago/v1/page/solicitud_pago")
                        .queryParam("pageNumber", pageNumber)
                        .queryParam("pageSize", pageSize)
                        .queryParam("id", id)
                        .build())
                .retrieve()
                .bodyToMono(PaymentPageResponse.class);
    }


   public Mono<PaymentCreateResponse> createPayment(PaymentRequest request) {
        return webClient.post()
                .uri("/api/solicitud_pago/v1/checkout/solicitud_pago")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(PaymentCreateResponse.class);
    }

}

