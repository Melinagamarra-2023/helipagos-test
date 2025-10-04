package com.melinagamarra.paymentrequests.service;

import com.melinagamarra.paymentrequests.dto.*;
import com.melinagamarra.paymentrequests.mapper.PaymentMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import java.io.IOException;


import static org.mockito.Mockito.when;

@ActiveProfiles("test")
class WebClientServiceTest {

    private static MockWebServer mockWebServer;
    private WebClientService webClientService;
    private PaymentMapper paymentMapper;

    @BeforeAll
    static void setUpAll() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void tearDownAll() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    void setUp() {
        WebClient webClient = WebClient.builder()
                .baseUrl(mockWebServer.url("/").toString())
                .build();

        paymentMapper = Mockito.mock(PaymentMapper.class);
        webClientService = new WebClientService(webClient, paymentMapper);
    }

    @Test
    void testGetPayments() {
        String json = """
                [
                  {
                    "id_sp": 1,
                    "codigo_barra": "123",
                    "estado_pago": "PENDIENTE",
                    "medio_pago": "EFECTIVO",
                    "descripcion": "Pago test",
                    "importe": 1500
                  }
                ]
                """;

        mockWebServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/json"));

        StepVerifier.create(webClientService.getPayments(0, 10))
                .expectNextMatches(p -> p.getIdSp() == 1 &&
                        "Pago test".equals(p.getDescripcion()) &&
                        p.getImporte() == 1500.0)
                .verifyComplete();
    }

    @Test
    void testGetPaymentById() {
        String json = """
                {
                  "content": [
                    {
                      "id_sp": 99,
                      "codigo_barra": "XYZ",
                      "estado_pago": "PAGADO",
                      "medio_pago": "TARJETA",
                      "descripcion": "Pago único",
                      "importe": 2000
                    }
                  ],
                  "totalPages": 1,
                  "totalElements": 1
                }
                """;

        mockWebServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/json"));

        PaymentResponse mappedResponse = PaymentResponse.builder()
                .idSp(99)
                .descripcion("Pago único")
                .importe(2000.0)
                .estadoPago("PAGADO")
                .medioPago("TARJETA")
                .build();

        when(paymentMapper.toPaymentResponse(Mockito.any(PaymentPageResponse.class)))
                .thenReturn(mappedResponse);

        StepVerifier.create(webClientService.getPaymentById(99))
                .expectNextMatches(p -> p.getIdSp() == 99 &&
                        "Pago único".equals(p.getDescripcion()) &&
                        "PAGADO".equals(p.getEstadoPago()))
                .verifyComplete();
    }

    @Test
    void testCreatePayment() {
        String json = """
                {
                  "id_sp": 500,
                  "id_cliente": 10,
                  "estado": "CREADO",
                  "referencia_externa": "ABC123",
                  "descripcion": "Nueva solicitud",
                  "checkout_url": "http://checkout.com/pay"
                }
                """;

        mockWebServer.enqueue(new MockResponse()
                .setBody(json)
                .addHeader("Content-Type", "application/json"));

        PaymentRequest request = PaymentRequest.builder()
                .importe(1200)
                .fechaVto("2025-12-31")
                .recargo(0)
                .descripcion("Nueva solicitud")
                .referenciaExterna("ABC123")
                .urlRedirect("http://redirect.com")
                .webhook("http://webhook.com")
                .qr(true)
                .build();

        StepVerifier.create(webClientService.createPayment(request))
                .expectNextMatches(resp -> resp.getIdSp() == 500 &&
                        "CREADO".equals(resp.getEstado()) &&
                        "http://checkout.com/pay".equals(resp.getCheckoutUrl()))
                .verifyComplete();
    }
}
